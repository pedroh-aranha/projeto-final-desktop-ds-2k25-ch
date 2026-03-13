/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciarpecas;

/**
 *
 * @author Aluno
 */
public class Gerenciapcs {
    private int id;
    private String nome;
    private int cod;
    private String cod_orgnl;

    public Gerenciapcs() {
    }

    public Gerenciapcs(int id, String nome, int cod, String cod_orgnl) {
        this.id = id;
        this.nome = nome;
        this.cod = cod;
        this.cod_orgnl = cod_orgnl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCod_orgnl() {
        return cod_orgnl;
    }

    public void setCod_orgnl(String cod_orgnl) {
        this.cod_orgnl = cod_orgnl;
    }

    
}
