/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab202a
 */
public class UsuarioDAO extends SistemaDAO {

    private final Connection connection;
    private final String select = "SELECT * FROM public.usuarios";
    private final String insert = "INSERT INTO public.usuarios (usuario, senha, perfil) VALUES (?, ?, ?)";
    private final String delete = "DELETE FROM public.usuarios WHERE usuario = ? AND senha = ?";    
    private final String update = "UPDATE public.usuarios SET usuario = ?, senha = ?, perfil = ? WHERE usuario = ? AND senha = ?";
    
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psDelete;
    private PreparedStatement psUpdate;

    public UsuarioDAO(Connection connection) throws SQLException {
        this.connection = connection;
        psSelect = this.connection.prepareStatement(select);    
        psInsert = this.connection.prepareStatement(insert);
        psDelete = this.connection.prepareStatement(delete);
        psUpdate = this.connection.prepareStatement(update);
    }

    @Override
    public List<Object> Select() throws SQLException {
        ResultSet rs = psSelect.executeQuery();
        List<Object> usuarios = new ArrayList<Object>();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            u.setPerfil(rs.getString("perfil"));

            usuarios.add(u);
        }
        return usuarios;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Usuario usuario = (Usuario) param;
        
        psInsert.setString(1, usuario.getUsuario());
        psInsert.setString(2, usuario.getSenha());
        psInsert.setString(3, usuario.getPerfil());
        
        psInsert.execute();
        
        return psInsert.getUpdateCount(); //retorna o numero de linhas afetadas
    }

    @Override
    public long Delete(Object param) {
        try {
            Usuario usuario = (Usuario) param;
            
            psDelete.setString(1, usuario.getUsuario());
            psDelete.setString(2, usuario.getSenha());
            
            psDelete.execute();
            
            return psDelete.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public long Update(Object param) {
        try {
            Usuario usuario = (Usuario) param;
            
            psUpdate.setString(1, usuario.getUsuario());
            psUpdate.setString(2, usuario.getSenha());
            psUpdate.setString(3, usuario.getPerfil());
            psUpdate.setString(4, usuario.getUsuario());
            psUpdate.setString(5, usuario.getSenha());
            
            psUpdate.execute();
            
            return psUpdate.getUpdateCount();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return 0;
    }        
}
