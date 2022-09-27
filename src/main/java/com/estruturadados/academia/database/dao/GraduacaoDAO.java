package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Graduacao;
public class GraduacaoDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "select * from public.graduacoes;";
    private String insert = "insert into public.graduacoes (modalidade, graduacao) values ( ?, ?);";
    private String update = "update public.graduacoes (modalidade, graduacao) values ( ?, ?);";

    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

    public GraduacaoDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
    }

    @Override
    public long Delete(Object param) {
        Graduacao g = (Graduacao) param;
        try{
            pstDelete.setString(1, g.getModalidade());
            pstDelete.setString(2, g.getGraduacao());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Graduacao g = (Graduacao) param;
        pstInsert.setString(1, g.getModalidade());
        pstInsert.setString(2, g.getGraduacao());
        pstInsert.execute();
        return 0;
    }

    @Override
    public List<Object> Select() throws SQLException {
        Graduacao g = new Graduacao();
        List<Object> lista = new ArrayList<>();

        ResultSet resultado =  pstSelect.executeQuery();
        while (resultado.next()) {
            g.setModalidade(resultado.getString("modalidade"));
            g.setGraduacao(resultado.getString("graduacao"));
            lista.add(g);
        }

        return lista;
    }

    @Override
    public long Update(Object param) {
        Graduacao g = (Graduacao) param;
        try{
            pstUpdate.setString(1, g.getModalidade());
            pstUpdate.setString(2, g.getGraduacao());
            pstUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
    