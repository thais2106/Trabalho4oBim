package br.univel.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com banco de dados
 * @author tcrivelatti - 10/11/2015 - 19:51:04
 *
 */

public class ConexaoServidor {
	private static Connection con;
	private static String url;
	private static String user;
	private static String pass;
		
	
	private ConexaoServidor(){
		url = "jdbc:mysql://localhost/sisvendas";
		user = "root";
		//pass = "root"; //faculdade
		pass = ""; //casa
		
		try {
			//Conectando banco de dados
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco de dados" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		if (con == null){
			new ConexaoServidor();
		}
		
		return con;
	}
	
}
