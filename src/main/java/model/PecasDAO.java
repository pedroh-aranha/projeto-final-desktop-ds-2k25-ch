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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
 
public class PecasDAO {
 
    public PecasDAO() {}
 
    public void inserir_peca(PecasBean gerenciapcs) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO items (cod, nome, cod_orgnl, qntde) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, gerenciapcs.getCod());
            stmt.setString(2, gerenciapcs.getNome());
            stmt.setString(3, gerenciapcs.getCod_orgnl());
            stmt.setInt(4, gerenciapcs.getQntde());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<PecasBean> listarpecas() {
        List<PecasBean> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT t.id, t.cod, t.nome, t.cod_orgnl, t.qntde FROM items t"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PecasBean t = new PecasBean();
                t.setId(rs.getInt("id"));
                t.setCod(rs.getInt("cod"));
                t.setNome(rs.getString("nome"));
                t.setCod_orgnl(rs.getString("cod_orgnl"));
                t.setQntde(rs.getInt("qntde"));
                lista.add(t);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return lista;
    }
 
    public void atualizar(PecasBean gerenciapcs) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE items SET cod = ?, nome = ?, cod_orgnl = ?, qntde = ? WHERE id = ?"
            );
            stmt.setInt(1, gerenciapcs.getCod());
            stmt.setString(2, gerenciapcs.getNome());
            stmt.setString(3, gerenciapcs.getCod_orgnl());
            stmt.setInt(4, gerenciapcs.getQntde());
            stmt.setInt(5, gerenciapcs.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletar(int id) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM items WHERE id = ?"
            );
            stmt.setInt(1, id); // O id vem da variável pecaEditandoId da tela Mudanca
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        }
    }
    
    public boolean validarAdmin(String usuario, String senha) {
        boolean ehAdmin = false;
        // Use try-with-resources para garantir que a conexão feche sempre
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ? AND admin = 1"; 

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ehAdmin = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao validar banco: " + e.getMessage());
        }
        return ehAdmin;
    }
}