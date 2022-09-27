package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "select * from public.matriculas;";
    private String insert = "INSERT INTO public.matriculas " +
            "(codigo_matricula,codigo_aluno,data_matricula,dia_vencimento,data_encerramento) " +
            "VALUES (?, ?, ?, ?, ?);";
    private String update = "UPDATE public.matriculas " +
            "SET codigo_matricula=?, codigo_aluno=?, data_matricula=?, dia_vencimento=?, data_encerramento=? " +
            "WHERE codigo_matricula=?;";
    private String delete = "DELETE FROM public.matriculas WHERE codigo_matricula=?;";

    private PreparedStatement pstSelect;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public MatriculaDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public List<Object> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Object> arlPessoa = new ArrayList<Object>();

        while (resultado.next()) {
            Matricula p = new Matricula();
            p.setCodigoMatricula(resultado.getInt("codigo_matricula"));
            p.setCodigoAluno(resultado.getInt("codigo_aluno"));
            p.setDataMatricula(resultado.getDate("data_matricula"));
            p.setDataEncerramento(resultado.getDate("data_encerramento"));
            p.setDiaVencimento(resultado.getInt("dia_vencimento"));

            arlPessoa.add(p);
        }

        return arlPessoa;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Matricula p = (Matricula) param;

        pstInsert.setInt(1, p.getCodigoMatricul());
        pstInsert.setInt(2, p.getCodigoAluno());
        pstInsert.setInt(3, p.getDiaVencimento());
        pstInsert.setTimestamp(4, new Timestamp(p.getDataEncerramento().getTime()));

        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
    public long Delete(Object param) {
        Matricula p = (Matricula) param;
        try {
            pstDelete.setInt(1, p.getCodigoMatricul());
            pstDelete.execute();
            return pstDelete.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long Update(Object param) {
        Matricula p = (Matricula) param;
        try {
            pstUpdate.setInt(1, p.getCodigoMatricul());
            pstUpdate.setInt(2, p.getCodigoAluno());
            pstUpdate.setInt(3, p.getDiaVencimento());
            pstUpdate.setTimestamp(
                    4,
                    new Timestamp(p.getDataEncerramento().getTime()));

            pstUpdate.execute();
            return pstUpdate.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
