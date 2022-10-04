package com.estruturadados.academia.database;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.CidadeDAO;
import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.Cidade;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Teste {

  public static void main(String[] args) throws SQLException {
    Connection connection = ConnectionFactory.getConnection(
      "localhost",
      "5432",
      "academia",
      "postgres",
      "postgres"
    );
    if (connection != null) {
      System.out.println("CONECTADO");

      AlunoDAO alunoDAO = new AlunoDAO(connection);
      CidadeDAO cidadeDAO = new CidadeDAO(connection);

      List<Object> listaAluno = alunoDAO.Select();

      for (Object o : listaAluno) {
        System.out.println(((Aluno) o).toString());
      }
      //   List<Object> listaCidade = cidadeDAO.Select();

    } else {
      System.out.println("NÃO CONECTADO");
    }
  }
}
