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
 * @author Aluno
 */
public class SaidaDAO {
    
    public int registrarSaida(SaidaBean saida) {
        int idGerado = -1;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO saidas (data, veiculo, cod, nome, saida, qntde_restante, usuario) VALUES (?, ?, ?, ?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, saida.getData());
            stmt.setString(2, saida.getVeiculo());
            stmt.setInt(3, saida.getCod());
            stmt.setString(4, saida.getNome());
            stmt.setInt(5, saida.getSaida());
            stmt.setInt(6, saida.getQntde());
            stmt.setString(7, saida.getUsuario());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            rs.close();
            stmt.close();

            PreparedStatement stmtUpdate = conn.prepareStatement(
                "UPDATE items SET qntde = qntde - ? WHERE cod = ?"
            );
            stmtUpdate.setInt(1, saida.getSaida());
            stmtUpdate.setInt(2, saida.getCod());
            stmtUpdate.executeUpdate();
            stmtUpdate.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return idGerado;
    }
    
  
    public SaidaBean buscarPorId(int id) {
      SaidaBean saida = null;
      try {
          Connection conn = Conexao.conectar();
          PreparedStatement stmt = conn.prepareStatement(
              "SELECT * FROM saidas WHERE id = ?"
          );
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();

          if (rs.next()) {
              saida = new SaidaBean();
              saida.setIdossaida(rs.getInt("id"));
              saida.setData(rs.getString("data"));
              saida.setUsuario(rs.getString("usuario"));
              saida.setVeiculo(rs.getString("veiculo"));
              saida.setCod(rs.getInt("cod"));
              saida.setNome(rs.getString("nome"));
              saida.setSaida(rs.getInt("saida"));
              saida.setQntde(rs.getInt("qntde_restante"));
          }

          rs.close();
          stmt.close();
          conn.close();
      } catch (SQLException e) {
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
      }
      return saida;
    }
    
    public int proximoId() {
        int id = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'gerenciador' AND table_name = 'saidas'"
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
