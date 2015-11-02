package br.univel.cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
private static Connection con;
	
	public Connection getConnection(){
			
			if (con == null){ //Se n�o ouver conex�o instanciada
				try{ // Tenta abrir uma nova conex�o
					String url = "jdbc:h2:~/sisvendas";
					String user = "sa";
					String pass = "sa";
						
					con = DriverManager.getConnection(url, user, pass);
				} catch (SQLException e){ //Se n�o conseguir abrir conex�o, retorna erro
					System.out.println("Erro ao abrir conex�o");
					e.printStackTrace();
				}
			}
			synchronized (con) {
			return con; //retorna conex�o
		}
	}
}
