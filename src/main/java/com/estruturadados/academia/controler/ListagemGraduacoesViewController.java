/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controler;

import com.estruturadados.academia.database.dao.GraduacaoDAO;
import com.estruturadados.academia.database.model.Graduacao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemGraduacoesViewController {

    private Connection connection;
    
    public ListagemGraduacoesViewController(Connection connection) {
        this.connection = connection;
    }
    
    public void listarGraduacoes(DefaultTableModel modeloTabela) {
        try {
            GraduacaoDAO graduacaoDAO = new GraduacaoDAO(connection);
            List<Graduacao> listaGraduacoes = graduacaoDAO.Select();
            
            if (listaGraduacoes != null) {
                modeloTabela.setRowCount(0);
                for (Graduacao g : listaGraduacoes) {
                    Object[] dados = {g.getModalidade().getModalidade(), g.getGraduacao()};
                    modeloTabela.addRow(dados);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
