package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Aluno;

public class AlunoDAO extends SistemaDAO {
	
	private Connection conexao;
	private String select = "select * from public.alunos;";
	private String insert = "INSERT INTO public.alunos(aluno, cep) VALUES (?, ?);";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	
	
	public AlunoDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
		pstSelect = this.conexao.prepareStatement(select);
		pstInsert = this.conexao.prepareStatement(insert);
	}

	@Override
	public List<Object> Select() throws SQLException {
		
		ResultSet resultado = pstSelect.executeQuery();		
		List<Object> arlPessoa = new ArrayList<Object>();
		
		while (resultado.next()) {
			
			Aluno p = new Aluno();
			p.setCodigoAluno(resultado.getInt("codigo_aluno"));
			p.setAluno(resultado.getString("aluno"));
			p.setCep(resultado.getString("cep"));
			
			arlPessoa.add(p);
			
		}
		
		return arlPessoa;
	}

	@Override
	public int Insert(Object param) throws SQLException {
		
		Aluno p = (Aluno)param;
		pstInsert.setString(1, p.getAluno());
		pstInsert.setString(2, p.getCep());
		
		pstInsert.execute();
		
		return pstInsert.getUpdateCount();
	}

	@Override
	public long Delete(Object param) {
		return 0;
	}

	@Override
	public long Update(Object param) {
		return 0;
	}

}
