package com.estruturadados.academia.database.model;

import java.util.Date;

public class Matricula {
    
    private int codigoMatricula;
    private int codigoAluno;
    private Date dataMatricula;
    private int dataVencimento;
    private Date dataEncerramento;


    public Matricula() {
        
    }
    
    public Matricula(int codigo_matricula, int codigo_aluno, Date data_matricula, int dia_vencimento, Date data_encerramento) {
        this.codigoMatricula = codigo_matricula;
        this.codigoAluno = codigo_aluno;
        this.dataMatricula = data_matricula;
        this.dataVencimento = dia_vencimento;
        this.dataEncerramento = data_encerramento;
    }

    public int getCodigo_matricula() {
        return codigoMatricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigoMatricula = codigo_matricula;
    }

    public int getCodigo_aluno() {
        return codigoAluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigoAluno = codigo_aluno;
    }

    public Date getData_matricula() {
        return dataMatricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.dataMatricula = data_matricula;
    }

    public int getDia_vencimento() {
        return dataVencimento;
    }

    public void setDia_vencimento(int dia_vencimento) {
        this.dataVencimento = dia_vencimento;
    }

    public Date getData_encerramento() {
        return dataEncerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.dataEncerramento = data_encerramento;
    }

}
