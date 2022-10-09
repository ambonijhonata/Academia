package com.estruturadados.academia.database.model;

import java.util.Date;
import java.util.List;

public class Aluno {

    private int codigoAluno;
    private String aluno;
    private Date dataNascimento;
    private String sexo;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public Aluno() {
    }

    public Aluno(
            int codigo_aluno,
            String aluno,
            Date data_nascimento,
            String sexo,
            String telefone,
            String celular,
            String email,
            String observacao,
            String endereco,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String pais,
            String cep) {
        this.codigoAluno = codigo_aluno;
        this.aluno = aluno;
        this.dataNascimento = data_nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.observacao = observacao;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigo_aluno) {
        this.codigoAluno = codigo_aluno;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return ("Codigo Aluno: "
                + this.codigoAluno
                + ", Aluno: "
                + this.aluno
                + ", Data Nascimento: "
                + this.dataNascimento
                + ", Sexo: "
                + this.sexo
                + ", Telefone: "
                + this.telefone
                + ", Celular: "
                + this.celular
                + ", E-mail: "
                + this.email
                + ", Observação: "
                + this.observacao
                + ", Endereço: "
                + this.endereco
                + ", Número: "
                + this.numero
                + ", Complemento: "
                + this.complemento
                + ", Bairro: "
                + this.bairro
                + ", Cidade: "
                + this.cidade
                + ", Estado: "
                + this.estado
                + ", País: "
                + this.pais
                + ", CEP: "
                + this.cep);
    }

}
