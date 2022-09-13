package com.estruturadados.academia.database.model;

public class Planos {
    private String modalidade;
    private String plano;
    private double valorMensal;

    public Planos() {
        
    }

    public Planos(String modalidade, String plano, double valorMensal) {
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

}
