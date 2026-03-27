/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public class PecasBean {
    private int id;
    private String nome;
    private int cod;
    private String cod_orgnl;
    private int qntde;
    
    public PecasBean() {
    }

    public PecasBean(int id, String nome, int cod, String cod_orgnl, int qntde) {
        this.id = id;
        this.nome = nome;
        this.cod = cod;
        this.cod_orgnl = cod_orgnl;
        this.qntde = qntde;
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

    public int getQntde() {
        return qntde;
    }

    public void setQntde(int qntde) {
        this.qntde = qntde;
    }

    
}
