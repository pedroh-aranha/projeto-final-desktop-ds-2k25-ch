/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class EntradaDAO {


    // Registra a entrada e atualiza o estoque na tabela items
    public int registrarEntrada(EntradaBean entrada) {
        int idGerado = -1;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO entradas (data, cod, nome, cod_orgnl, qntde) VALUES (?, ?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, entrada.getData());
            stmt.setInt(2, entrada.getCod());
            stmt.setString(3, entrada.getNome());
            stmt.setString(4, entrada.getCod_orgnl());
            stmt.setInt(5, entrada.getQntde());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }

            rs.close();
            stmt.close();

            PreparedStatement stmtUpdate = conn.prepareStatement(
                "UPDATE items SET qntde = qntde + ? WHERE cod = ?"
            );
            stmtUpdate.setInt(1, entrada.getQntde());
            stmtUpdate.setInt(2, entrada.getCod());
            stmtUpdate.executeUpdate();
            stmtUpdate.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return idGerado;
    }
    
    public EntradaBean buscarPorId(int id) {
        EntradaBean entrada = null;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM entradas WHERE id = ?"
            );
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entrada = new EntradaBean();
                entrada.setId(rs.getInt("id"));
                entrada.setData(rs.getString("data"));
                entrada.setCod(rs.getInt("cod"));
                entrada.setNome(rs.getString("nome"));
                entrada.setCod_orgnl(rs.getString("cod_orgnl"));
                entrada.setQntde(rs.getInt("qntde"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return entrada;
    }
    
    public int proximoId() {
        int id = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'gerenciador' AND table_name = 'entradas'"
            );
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
}
    

