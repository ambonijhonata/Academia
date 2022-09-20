package com.estruturadados.academia.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.dao.CidadeDAO;
import com.estruturadados.academia.database.model.Cidade;

public class Teste {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = ConnectionFactory.getConnection
								(
									"localhost", 
									"5432", 
									"sensei_academia", 
									"postgres", 
									"123"
								);
		if (connection != null) {
			System.out.println("CONECTADO");
			
			AlunoDAO alunoDAO = new AlunoDAO(connection);
            CidadeDAO cidadeDAO = new CidadeDAO(connection);
			
			/*Pessoa p = new Pessoa();
			p.setNome("Junior");
			p.setCpf("789");
			
			int fezInsert = dao.Insert(p);
			
			System.out.println(fezInsert);*/
			
			List<Object> listaAluno = alunoDAO.Select();
            List<Object> listaCidade = cidadeDAO.Select();
			
			
			
		} 
		else {
			System.out.println("NÃO CONECTADO");
		}

	}

}
