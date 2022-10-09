/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controler;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.model.Aluno;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemAlunosViewController {
    
    private Connection connection;
    
    public ListagemAlunosViewController(Connection connection) {
        this.connection = connection;
    }
    
    public void listarAlunos(DefaultTableModel modeloTabela) {
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            List<Aluno> listaAlunos = alunoDAO.Select();
            
            if (listaAlunos != null) {
                modeloTabela.setRowCount(0);                
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                for (Aluno a : listaAlunos) {
                    Object[] dados = {a.getAluno(), sdf.format(a.getDataNascimento()), a.getCidade()};
                    modeloTabela.addRow(dados);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
