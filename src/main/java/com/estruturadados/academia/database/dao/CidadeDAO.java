package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Cidade;

public class CidadeDAO {
    private Connection conexao;
	private String select = "select * from public.cidades;";
    private String insert = "insert into public.cidades (cidade, estado, pais) values (?, ?, ?);";
    private String update = "update public.cidades set cidade = ?, estado = ? where cidade = ?;";
    private String delete = "delete from public.cidades where cidade = ?;";

    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

    public CidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    

    
}
