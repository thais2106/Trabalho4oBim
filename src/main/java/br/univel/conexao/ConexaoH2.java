package br.univel.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com banco de dados H2
 * @author tcrivelatti - 10/11/2015 - 19:51:04
 *
 */

public class ConexaoH2 {
	private static Connection con;
	private static String url;
	private static String user;
	private static String pass;
		
	
	private ConexaoH2(){
		url = "jdbc:h2:~/sisvendas";
		user = "sa";
		pass = "sa";
		
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if (con == null){
			new ConexaoH2();
		}
		
		return con;
	}
	
	
}
