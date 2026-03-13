/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public class Saida {
    private int id;
    private int qmbaixa;
    private String data;
    private String tipoveiculo;
    private String placa;
    private int cod;
    private String nome;
    private int qntde;

    public Saida() {
    }

    public Saida(int id, int qmbaixa, String data, String tipoveiculo, String placa, int cod, String nome, int qntde) {
        this.id = id;
        this.qmbaixa = qmbaixa;
        this.data = data;
        this.tipoveiculo = tipoveiculo;
        this.placa = placa;
        this.cod = cod;
        this.nome = nome;
        this.qntde = qntde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQmbaixa() {
        return qmbaixa;
    }

    public void setQmbaixa(int qmbaixa) {
        this.qmbaixa = qmbaixa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoveiculo() {
        return tipoveiculo;
    }

    public void setTipoveiculo(String tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntde() {
        return qntde;
    }

    public void setQntde(int qntde) {
        this.qntde = qntde;
    }
    
    
}
