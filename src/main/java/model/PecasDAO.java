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

/**
 *
 * @author Aluno
 */
public class PecasDAO {

    public PecasDAO() {
    }
   
   
    public void inserir_peca(PecasBean gerenciapcs){
    try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
           
            stmt = conn.prepareStatement("INSERT INTO items (cod,nome,cod_orgnl,qntde) values (?, ?, ?, ?)");
            stmt.setInt(1, gerenciapcs.getCod());
            stmt.setString(2, gerenciapcs.getNome());
            stmt.setString(3, gerenciapcs.getCod_orgnl());
            stmt.setInt(4,gerenciapcs.getQntde());
           
            stmt.executeUpdate();
           
           
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }
   
    public List<PecasBean> listarpecas(){
        List<PecasBean> lista = new ArrayList<>();
       
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT t.id, t.cod,t.nome,t.cod_orgnl,t.qntd FROM items t"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PecasBean t = new PecasBean();
                t.setId(rs.getInt("id"));
                t.setCod(rs.getInt("cod"));
                t.setNome(rs.getString("nome"));
                t.setCod_orgnl(rs.getString("cod_orgnl"));
                t.setQntde(rs.getInt("qntde"));
                lista.add(t);
            }        
        }catch(SQLException e ){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
        return lista;
    }
    
    public void atualizar(PecasBean gerenciapcs) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            
            stmt = conn.prepareStatement("UPDATE items SET cod = ?, nome = ?, cod_orgnl = ?, qntde = ? WHERE id = ?");
            stmt.setInt(1, gerenciapcs.getCod());       // Atualiza o título
            stmt.setString(2, gerenciapcs.getNome());   // Atualiza a descrição
            stmt.setString(3, gerenciapcs.getCod_orgnl()); // Atualiza o responsável
            stmt.setInt(4, gerenciapcs.getQntde());      // Atualiza o status
            stmt.setInt(5, gerenciapcs.getId());             // Define qual tarefa será atualizada (por ID)
            
            // Executa a instrução de atualização no banco
            stmt.executeUpdate();
            stmt.close();   // Fecha a instrução preparada
            conn.close();   // Fecha a conexão com o banco
            
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
        }
    }
}