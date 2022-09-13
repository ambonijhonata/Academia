package com.estruturadados.academia.database.model;

public class Usuario {
    private String usuario;
    private String perfil;

    public Usuario() {
        
    }

    public Usuario(String usuario, String perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}


