package com.estruturadados.academia.database.model;

public class Graduacao {
    private String modalidade;
    private String graduacao;

    public Graduacao() {
        
    }

    public Graduacao(String modalidade, String graduacao) {
        this.modalidade = modalidade;
        this.graduacao = graduacao;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
}
