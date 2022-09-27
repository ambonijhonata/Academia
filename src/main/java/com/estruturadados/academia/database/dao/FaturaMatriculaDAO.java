package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.FaturasMatricula;

public class FaturaMatriculaDAO extends SistemaDAO{
    
    private Connection conexao;
    private String select = "select * from public.faturas_matriculas;";
    private String insert = "insert into public.faturas_matriculas (codigo_matricula, data_vencimento,valor,data_pagamento,data_cancelamento) values (?, ?, ?, ?, ?);";
    private String update = "update public.faturas_matriculas set codigo_matricula = ?, data_vencimento = ?, valor = ?, data_pagamento = ?, data_cancelamento = ? where codigo_matricula = ?;";
    private String delete = "delete from public.faturas_matriculas where codigo_matricula = ?;";
    
    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;

    public FaturaMatriculaDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public long Delete(Object param) {
        FaturasMatricula f = (FaturasMatricula) param;
        try{
            pstDelete.setLong(1, f.getCodigoMatricula());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        FaturasMatricula f = (FaturasMatricula) param;
        pstInsert.setLong(1, f.getCodigoMatricula());
        pstInsert.setTimestamp(2, new Timestamp(f.getDataVencimento().getTime()));
        pstInsert.setDouble(3, f.getValor());
        pstInsert.setTimestamp(4, new Timestamp(f.getDataPagamento().getTime()));
        pstInsert.setTimestamp(5, new Timestamp(f.getDataCancelamento().getTime()));
        pstInsert.execute();
        return 0;
    }

    @Override
    public List<Object> Select() throws SQLException {
        FaturasMatricula f = new FaturasMatricula();
        List<Object> lista = new ArrayList<>();

        ResultSet resultado =  pstSelect.executeQuery();
        while (resultado.next()) {
            f.setCodigoMatricula(resultado.getInt("codigo_matricula"));
            f.setDataVencimento(resultado.getDate("data_vencimento"));
            f.setValor(resultado.getDouble("valor"));
            f.setDataPagamento(resultado.getDate("data_pagamento"));
            f.setDataCancelamento(resultado.getDate("data_cancelamento"));
            lista.add(f);
        }
        
        return lista;
    }

    @Override
    public long Update(Object param) {
        FaturasMatricula f = (FaturasMatricula) param;
        try{
            pstUpdate.setLong(1, f.getCodigoMatricula());
            pstUpdate.setTimestamp(2, new Timestamp(f.getDataVencimento().getTime()));
            pstUpdate.setDouble(3, f.getValor());
            pstUpdate.setTimestamp(4, new Timestamp(f.getDataPagamento().getTime()));
            pstUpdate.setTimestamp(5, new Timestamp(f.getDataCancelamento().getTime()));
            pstUpdate.setLong(6, f.getCodigoMatricula());
            pstUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
