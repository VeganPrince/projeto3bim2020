package banco_de_Dados_Avaliacao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexao {

    // CONFIGURAÇÃO DA CONEXÃO DO BANCO DE DADOS
    private Connection conexao;
    private final String url = "jdbc:postgresql://localhost:5432/prontuario";
    private final String user = "postgres";
    private final String password = "123456";

    // METODO PARA CONECTAR AO BANCO DE DADOS
    public Connection Conectar() {
        try {
            this.conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar o Banco de Dados" + ex.toString());
            return null;
        }
        System.out.println("Banco de Dados Conectado");
        return conexao;
    }
    // METODO PARA DESCONECTAR DO BANCO DE DADOS

    public boolean Desconectar() {
        try {
            if (this.conexao.isClosed() == false) // se não estiver fechada a conexao 
            {
                this.conexao.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar do Banco de Dados" + ex.toString());
            return false;
        }
        System.out.println("Banco de Dados desconectado");
        return true;
    }

}
