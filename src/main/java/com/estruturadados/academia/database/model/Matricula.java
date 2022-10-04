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

    public int getCodigoMatricul() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigo_matricula) {
        this.codigoMatricula = codigo_matricula;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigo_aluno) {
        this.codigoAluno = codigo_aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date data_matricula) {
        this.dataMatricula = data_matricula;
    }

    public int getDiaVencimento() {
        return dataVencimento;
    }

    public void setDiaVencimento(int dia_vencimento) {
        this.dataVencimento = dia_vencimento;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date data_encerramento) {
        this.dataEncerramento = data_encerramento;
    }

    @Override
    public String toString() {
        return "codigoMatricula=" + codigoMatricula + ", codigoAluno=" + codigoAluno + ", dataMatricula=" + dataMatricula + ", diaVencimento=" + dataVencimento + ", dataEncerramento=" + dataEncerramento + "";
    }
}
