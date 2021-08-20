// CLASSE PARA MANIPULAÇÃO DAS INFORMAÇÕES REFERENTES AO MÉDICO
package banco_de_Dados_Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Medico {

    @SuppressWarnings("empty-statement")
    public boolean VerficarLogon(Connection con, Integer CRM, String Senha) throws SQLException {
        String sql = "select nome from medico "
                + " where crm = ? and senha = ? ";

        // Usado para criar um OBJETO que REPRESENTA a INSTRUÇÂO SQL que será EXECUTADA
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, CRM);
        stmt.setString(2, Senha);

        // Tras os resultados da consulta
        ResultSet rs = stmt.executeQuery();

        // Verifica se a consulta teve um retorno (quando tem retorno é pq as informações inseridas estavam corretas)
        if (rs.next()) {
            rs.close();
            stmt.close();;
            return true;
        } else {
            rs.close();
            stmt.close();;
            return false;
        }

    }// FIM VERFICARLOGON 

    public void Inserir(Connection con, Integer CRM, String Nome, String CPF, String Email, String NumCelular,
            String DataNascimento, String Senha) throws SQLException, ParseException {

        String sql = " insert into Medico (crm, nome, cpf, email, numcelular, datanascimento, senha)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, CRM);
        stmt.setString(2, Nome);
        stmt.setString(3, CPF);
        stmt.setString(4, Email);
        stmt.setString(5, NumCelular);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  //Para formatar a data p/ um tipo aceito no BD
        java.util.Date data = sdf.parse(DataNascimento);
        java.sql.Date datasql = new java.sql.Date(data.getTime());
        stmt.setDate(6, datasql);
        stmt.setString(7, Senha);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Dados inseridos com sucesso");

    }   // FIM INSERIR

}
