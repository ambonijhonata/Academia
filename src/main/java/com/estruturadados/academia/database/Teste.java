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
									"containers-us-west-55.railway.app", 
									"7412", 
									"sensei_academia", 
									"postgres", 
									"68aQuRLOMf5oT5yA7RGP"
								);
		if (connection != null) {
			System.out.println("CONECTADO");
			
			AlunoDAO dao = new AlunoDAO(connection);
			
			/*Pessoa p = new Pessoa();
			p.setNome("Junior");
			p.setCpf("789");
			
			int fezInsert = dao.Insert(p);
			
			System.out.println(fezInsert);*/
			
			List<Object> listaPessoa = dao.Select();
			
			for (int i = 0; i < listaPessoa.size(); i++) {
				
				Aluno p = (Aluno)listaPessoa.get(i);
				System.out.println(p);
				System.out.println("====================");
				
			}
			
			
		} 
		else {
			System.out.println("NÃO CONECTADO");
		}

	}

}
