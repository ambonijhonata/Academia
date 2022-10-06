/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controler;

import com.estruturadados.academia.database.dao.UsuarioDAO;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class LoginViewController {

    private final Connection connection;

    public LoginViewController(Connection connection) {
        this.connection = connection;
    }

    public boolean fazerLogin(Usuario usuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuarioDAO.selectLogin(usuario);

            boolean isRetorno = usuario.getUsuario() != null && usuario.getSenha() != null;

            return isRetorno;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
