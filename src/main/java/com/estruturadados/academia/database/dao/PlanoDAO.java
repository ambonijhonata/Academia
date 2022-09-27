package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Plano;

public class PlanoDAO extends SistemaDAO{
    
    private Connection conexao;
    private String select = "select * from public.planos;";
    private String insert = "insert into public.planos (modalidade, plano, valor_mensal) values ( ?, ?, ?);";
    private String update = "update public.planos set modalidade = ?, plano = ?, valor_mensal = ? where modalidade = ? and plano = ?;";
    private String delete = "delete from public.planos where modalidade = ? and plano = ?;";
    
    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

    public PlanoDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }
    
    @Override
    public long Delete(Object param) {
        Plano p = (Plano) param;
        try{
            pstDelete.setString(1, p.getModalidade());
            pstDelete.setString(2, p.getPlano());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Plano p = (Plano) param;
        pstInsert.setString(1, p.getModalidade());
        pstInsert.setString(2, p.getPlano());
        pstInsert.setDouble(3, p.getValorMensal());
        pstInsert.execute();
        return 0;
    }

    @Override
    public List<Object> Select() throws SQLException {
        ResultSet resultado =  pstSelect.executeQuery();
        List<Object> lista = new ArrayList<Object>();

        while(resultado.next()){
            Plano p = new Plano();
            p.setModalidade(resultado.getString("modalidade"));
            p.setPlano(resultado.getString("plano"));
            p.setValorMensal(resultado.getDouble("valor_mensal"));
            lista.add(p);
        }
        return null;
    }

    @Override
    public long Update(Object param) {
        Plano p = (Plano) param;
        try{
            pstUpdate.setString(1, p.getModalidade());
            pstUpdate.setString(2, p.getPlano());
            pstUpdate.setDouble(3, p.getValorMensal());
            pstUpdate.setString(4, p.getModalidade());
            pstUpdate.setString(5, p.getPlano());
            pstUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
