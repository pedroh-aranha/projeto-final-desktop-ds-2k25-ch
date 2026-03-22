/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import conexao.Conexao;
import gerenciarpecas.Gerenciapcs;
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
   
   
    public void inserir_peca(Gerenciapcs gerenciapcs){
    try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
           
            stmt = conn.prepareStatement("INSERT INTO items (cod,nome,cod_orgnl) values (?, ?, ?)");
            stmt.setInt(1, gerenciapcs.getCod());
            stmt.setString(2, gerenciapcs.getNome());
            stmt.setString(3, gerenciapcs.getCod_orgnl());
           
            stmt.executeUpdate();
           
           
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }
   
    public List<Gerenciapcs> listarpecas(){
        List<Gerenciapcs> lista = new ArrayList<>();
       
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT t.id, t.cod,t.nome,t.cod_orgnl FROM items t"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Gerenciapcs t = new Gerenciapcs();
                t.setId(rs.getInt("id"));
                t.setCod(rs.getInt("cod"));
                t.setNome(rs.getString("nome"));
                t.setCod_orgnl(rs.getString("cod_orgnl"));
                lista.add(t);
            }        
        }catch(SQLException e ){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
        return lista;
    }
}
