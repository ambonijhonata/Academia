package com.estruturadados.academia.database.model;

public class Plano {
    private String modalidade;
    private String plano;
    private double valorMensal;

    public Plano() {
        
    }

    public Plano(String modalidade, String plano, double valorMensal) {
        this.modalidade = modalidade;
        this.plano = plano;
        this.valorMensal = valorMensal;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        return "modalidade=" + modalidade + ", plano=" + plano + ", valorMensal=" + valorMensal + "";
    }

}
