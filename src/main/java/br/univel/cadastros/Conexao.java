package br.univel.cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
private static Connection con;
	
	public Connection getConnection(){
			
			if (con == null){ //Se não ouver conexão instanciada
				try{ // Tenta abrir uma nova conexão
					String url = "jdbc:h2:~/sisvendas";
					String user = "sa";
					String pass = "sa";
						
					con = DriverManager.getConnection(url, user, pass);
				} catch (SQLException e){ //Se não conseguir abrir conexão, retorna erro
					System.out.println("Erro ao abrir conexão");
					e.printStackTrace();
				}
			}
			synchronized (con) {
			return con; //retorna conexão
		}
	}
}
