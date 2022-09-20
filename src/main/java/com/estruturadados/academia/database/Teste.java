package com.estruturadados.academia.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.model.Aluno;

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
			
			AlunoDAO dao = new AlunoDAO(connection);
			
			/*Pessoa p = new Pessoa();
			p.setNome("Junior");
			p.setCpf("789");
			
			int fezInsert = dao.Insert(p);
			
			System.out.println(fezInsert);*/
			
			List<Object> listaAluno = dao.Select();
			
			for (int i = 0; i < listaAluno.size(); i++) {
				
				Aluno p = (Aluno)listaAluno.get(i);
				System.out.println(p.getAluno());
                System.out.println(p.getDataNascimento());
                System.out.println(p.getSexo());
				System.out.println("====================");
				
			}
			
			
		} 
		else {
			System.out.println("NÃO CONECTADO");
		}

	}

}
