package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class BD {

	public Connection con; // conexao
	public PreparedStatement st; // execucao instrucao sql
	public ResultSet rs; // recebe o resultado da instrucao sql

	//credenciais de acesso (arquivo externo)

	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASENAME = "ProjetoOficina";
	private final String URL = "jdbc:sqlserver://localhost:1433;databasename="+DATABASENAME;
	private final String LOGIN = "sa";
	private final String SENHA = "123456";

	public boolean getConnection() {
		try {
			Class.forName(DRIVER); //não seja encontrado 
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou...");
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver não encontrado! not Blz");

		}
		catch(SQLException erro) {
			System.out.println("Falha"+erro);

		}
		return false;

	}

	public void close() {
		try {
			if(rs!=null) rs.close();
		}
		catch(SQLException erro) {}
		try {
			if(st!=null) st.close();
		}
		catch(SQLException erro) {}
		try {
			if(con!=null) {
				con.close();
				System.out.println("Desconectou...");
			};
		}
		catch(SQLException erro) {}
	}


}

/*public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		// executo a operacao
		bd.close();
	}*/

