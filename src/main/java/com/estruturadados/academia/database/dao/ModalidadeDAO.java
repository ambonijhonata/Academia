package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Modalidade;

public class ModalidadeDAO extends SistemaDAO{
    private Connection conexao;
    private String select = "select * from modalidade";
    private String insert = "insert into modalidade (modalidade) VALUES (?)";
    private String delete = "delete from modalidade where modalidade = ? ;";
    
    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstDelete;
    
    public ModalidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstDelete = this.conexao.prepareStatement(delete);
    }
    @Override
    public long Delete(Object param) {
        Modalidade m = (Modalidade) param;
        try{
            pstDelete.setString(1, m.getModalidade());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Modalidade m = (Modalidade) param;
        pstInsert.setString(1, m.getModalidade());
        return 0;
    }

    @Override
    public List<Object> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Object> lista = new ArrayList<Object>();
        while(resultado.next()){
            Modalidade m = new Modalidade();
            m.setModalidade(resultado.getString("modalidade"));
            lista.add(m);
        }
        return null;
    }

    @Override
    public long Update(Object param) {
        // TODO Auto-generated method stub
        return 0;
    }

}
