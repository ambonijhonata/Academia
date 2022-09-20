package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Cidade;

public class CidadeDAO extends SistemaDAO {

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

    @Override
	public List<Object> Select() throws SQLException {
        
        ResultSet resultado = pstSelect.executeQuery();		
        List<Object> arlCidade = new ArrayList<Object>();
        
        while (resultado.next()) {
            
            Cidade c = new Cidade();
            c.setCidade(resultado.getString("cidade"));
            c.setEstado(resultado.getString("estado"));
            c.setPais(resultado.getString("pais"));
            arlCidade.add(c);
        }
        
        return arlCidade;
    }    

    @Override
    public int Insert(Object param) throws SQLException{
        Cidade c = (Cidade) param;
        pstInsert.setString(1, c.getCidade());
        pstInsert.setString(2, c.getEstado());
        pstInsert.setString(3, c.getPais());
        
        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
	public long Delete(Object param){
        Cidade c = (Cidade)param;
        try {
            pstDelete.setString(1, c.getCidade());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
	public long Update(Object param){
        Cidade c = (Cidade)param;
        try {
            pstUpdate.setString(1, c.getCidade());
            pstUpdate.setString(2, c.getEstado());
            pstUpdate.setString(3, c.getCidade());
            pstUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
