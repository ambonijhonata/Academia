package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Graduacao;
import com.estruturadados.academia.database.model.Modalidade;
import com.estruturadados.academia.database.model.Usuario;

public class GraduacaoDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "SELECT * FROM public.graduacoes ORDER BY modalidade ASC";
    private String insert = "INSERT INTO public.graduacoes (modalidade, graduacao) VALUES ( ?, ?)";
    private String update = "UPDATE public.graduacoes SET modalidade = ?, graduacao = ? WHERE modalidade = ? AND graduacao = ?";
    private String delete = "DELETE FROM public.graduacoes WHERE modalidade = ? AND graduacao = ?;";

    private PreparedStatement pstSelect;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public GraduacaoDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public long Delete(Object param) {
        Graduacao g = (Graduacao) param;
        try {
            //pstDelete.setString(1, g.getModalidade());
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
        pstInsert.setString(1, g.getModalidade().getModalidade());
        pstInsert.setString(2, g.getGraduacao());

        try {
            pstInsert.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pstInsert.getUpdateCount();
    }

    @Override
    public List<Graduacao> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();

        List<Graduacao> lista = new ArrayList<>();

        while (resultado.next()) {
            Modalidade modalidade = new Modalidade(resultado.getString("modalidade"));
            Graduacao graduacao = new Graduacao(modalidade, resultado.getString("graduacao"));
            lista.add(graduacao);
        }

        return lista;
    }

    @Override
    public long Update(Object graduacaoAntiga, Object graduacaoNova) {
        Graduacao gAntiga = (Graduacao) graduacaoAntiga;
        Graduacao gNova = (Graduacao) graduacaoNova;

        try {
            pstUpdate.setString(1, gNova.getModalidade().getModalidade());
            pstUpdate.setString(2, gNova.getGraduacao());
            pstUpdate.setString(3, gAntiga.getModalidade().getModalidade());
            pstUpdate.setString(4, gAntiga.getGraduacao());
            pstUpdate.execute();

            return pstUpdate.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Usuario SelectWithCondition(Object usuarioBuscar) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
