/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controler;

import com.estruturadados.academia.database.dao.ModalidadeDAO;
import com.estruturadados.academia.database.model.Modalidade;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemModalidadesViewController {

    private Connection connection;

    public ListagemModalidadesViewController(Connection connection) {
        this.connection = connection;
    }

    public void listarModalidades(DefaultTableModel modeloTabela) {
        try {
            ModalidadeDAO modalidadeDAO = new ModalidadeDAO(connection);
            List<Modalidade> listaModalidades = modalidadeDAO.Select();

            if (listaModalidades != null) {
                modeloTabela.setRowCount(0);

                for (Modalidade m : listaModalidades) {
                    Object[] dados = {m.getModalidade()};
                    modeloTabela.addRow(dados);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletarModalidade(Modalidade modalidade) {
        try {
            ModalidadeDAO modalidadeDAO = new ModalidadeDAO(connection);

            return modalidadeDAO.Delete(modalidade) > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
