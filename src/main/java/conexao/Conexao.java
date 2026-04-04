/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {
    private static Connection conn = null;
    private static final  String url = "jdbc:mysql://localhost:3306/gerenciador";
    private static final String user = "root";
    private static final String senha = "@Peranha318";
    
    private Conexao(){
   }
   
    public static synchronized Connection conectar(){
       try{
           if(conn == null || conn.isClosed()){
               conn = DriverManager.getConnection(url, user, senha);
           }
       } catch(SQLException e){
           e.printStackTrace();
       }
    return conn;
   }
    public void testarConexao(){
        Connection conn = conectar();
        if(conn == null){
            System.out.println("Erro ao conectar com o banco de dados");
        } else {
            System.out.println("conectado com sucesso");
        }
    }
}
