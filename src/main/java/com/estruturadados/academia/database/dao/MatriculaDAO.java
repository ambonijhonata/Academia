package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.Matricula;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "SELECT matriculas.codigo_matricula, alunos.aluno, matriculas.data_matricula, "
            + "matriculas.dia_vencimento, matriculas.data_encerramento FROM public.matriculas "
            + "inner join alunos on matriculas.codigo_aluno = alunos.codigo_aluno";
    private String selectWithCondition = "SELECT * FROM public.matriculas WHERE codigo_aluno = ? ";
    private String insert = "INSERT INTO public.matriculas "
            + "(codigo_aluno, data_matricula, dia_vencimento)"
            + "VALUES (?, ?, ?);";
    private String delete = "DELETE FROM public.matriculas WHERE codigo_matricula=?;";

    private PreparedStatement pstSelect;
    private PreparedStatement pstSelectWithCondition;
    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;

    public MatriculaDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstSelectWithCondition = this.conexao.prepareStatement(selectWithCondition);
        pstInsert = this.conexao.prepareStatement(insert);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public List<Matricula> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Matricula> arlMatricula = new ArrayList<>();

        while (resultado.next()) {
            Aluno aluno = new Aluno();
            aluno.setAluno(resultado.getString("aluno"));
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(resultado.getInt("codigo_matricula"));
            matricula.setAluno(aluno);
            matricula.setDataMatricula(resultado.getDate("data_matricula"));
            matricula.setDiaVencimento(resultado.getInt("dia_vencimento"));
            matricula.setDataEncerramento(resultado.getDate("data_encerramento"));

            arlMatricula.add(matricula);
        }

        return arlMatricula;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Matricula matricula = (Matricula) param;

        pstInsert.setInt(1, matricula.getAluno().getCodigoAluno());
        pstInsert.setDate(2, new java.sql.Date(matricula.getDataMatricula().getTime()));
        pstInsert.setInt(3, matricula.getDiaVencimento());
        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
    public long Delete(Object param) {
        Matricula p = (Matricula) param;
        try {
            //  pstDelete.setInt(1, p.getCodigoMatricul());
            pstDelete.execute();
            return pstDelete.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Boolean SelectWithCondition(Object alunoBuscar) throws SQLException {
        Aluno aluno = (Aluno) alunoBuscar;

        pstSelectWithCondition.setInt(1, aluno.getCodigoAluno());

        ResultSet rs = pstSelectWithCondition.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long Update(Object param, Object param2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
