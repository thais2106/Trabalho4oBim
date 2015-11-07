package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.cadastros.Cliente;
import br.univel.cadastros.ClienteDAOImpl;

/**
 * Classe que mostra os campos da tela de vendas na MolduraAbstrata
 * @author Thaís - 05/11/2015 - 16:12:03
 *
 */

public class TelaCadVenda extends MolduraAbstrata{
	
	public TelaCadVenda() {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		MioloCadVenda mcv = new MioloCadVenda();
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			clientes = clienteDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Cliente c : clientes) {
			extracted(mcv, c);;
		}
		
		
		super.add(mcv, BorderLayout.CENTER);
		
		super.setAcaoSalvar(mcv.getAcaoSalvar());
		
		super.setAcaoExcluir(mcv.getAcaoExcluir());
		
	}

	private void extracted(MioloCadVenda mcv, Cliente c) {
		mcv.cbxcliente.addItem(c.getNome());
	}
}
