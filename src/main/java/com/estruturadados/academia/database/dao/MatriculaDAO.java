import com.estruturadados.academia.database.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends SistemaDAO {

  private Connection conexao;
  private String select = "select * from public.matriculas;";
  private String insert =
    "INSERT INTO public.matriculas " +
    "(codigo_matricula,codigo_aluno,data_matricula,dia_vencimento,data_encerramento) " +
    "VALUES (?, ?, ?, ?, ?);";
  private String update =
    "UPDATE public.matriculas " +
    "SET codigo_matricula=?, codigo_aluno=?, data_matricula=?, dia_vencimento=?, data_encerramento=? " +
    "WHERE codigo_matricula=?;";
  private String delete =
    "DELETE FROM public.matriculas WHERE codigo_matricula=?;";

  private PreparedStatement pstSelect;
  private PreparedStatement pstInsert;

  @Override
  public List<Object> Select() throws SQLException {
    ResultSet resultado = pstSelect.executeQuery();
    List<Object> arlPessoa = new ArrayList<Object>();

    while (resultado.next()) {
      Matricula p = new Matricula();
      p.setCodigo_matricula("codigo_matricula");
     

      arlPessoa.add(p);
    }

    return arlPessoa;
  }

  @Override
  public int Insert(Object param) throws SQLException {
    Aluno p = (Aluno) param;
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
