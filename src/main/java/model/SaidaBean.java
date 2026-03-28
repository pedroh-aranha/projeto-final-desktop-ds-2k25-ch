/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public class SaidaBean {
    private int idossaida;
    private String data;
    private String veiculo;
    private int cod;
    private String nome;
    private int saida;
    private int qntde;

    public SaidaBean() {
    }

    public SaidaBean(int idossaida, String data, String veiculo, int cod, String nome, int saida, int qntde) {
        this.idossaida = idossaida;
        this.data = data;
        this.veiculo = veiculo;
        this.cod = cod;
        this.nome = nome;
        this.saida = saida;
        this.qntde = qntde;
    }

    public int getIdossaida() {
        return idossaida;
    }

    public void setIdossaida(int idossaida) {
        this.idossaida = idossaida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
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

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public int getQntde() {
        return qntde;
    }

    public void setQntde(int qntde) {
        this.qntde = qntde;
    }

   
}
