package br.univel.conexao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConexaoServidorTest {
	private static Connection con;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		con = ConexaoServidor.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		if (con != null)
			System.out.println("Conectado");
		else
			System.out.println("Conexão não estabelecida");
	}

}
