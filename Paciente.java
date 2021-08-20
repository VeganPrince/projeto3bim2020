
package banco_de_Dados_Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Paciente {
    
    public void Inserir_Paciente (Connection con, String nome, String sexo, String datanascimento,String endereco, String telefone
            , String numcelular, String email) throws SQLException, ParseException  {

        String sql = " insert into Paciente (nome ,sexo ,datanascimento ,endereco ,telefone ,numcelular ,email )"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, sexo);
        stmt.setString(4, endereco);
        stmt.setString(5, telefone);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  //Para formatar a data p/ um tipo aceito no BD
        java.util.Date data = sdf.parse(datanascimento);
        java.sql.Date datasql =  new java.sql.Date(data.getTime());
        stmt.setDate(3, datasql);

        stmt.setString(6, numcelular);
        stmt.setString(7, email);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Dados inseridos com sucesso");

    }   // FIM INSERIR
}
