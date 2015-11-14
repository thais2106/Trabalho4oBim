package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.cadastros.VendaDAOImpl;
import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;

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
		VendaDAOImpl vendadao = new VendaDAOImpl();
		ClienteDAOImpl clienteDao = new ClienteDAOImpl();
		List<Cliente> clientes = new ArrayList<Cliente>(); //array para popular combobox de clientes na tela de vendas
		
		//Criando lista de clientes do banco para popular combobox
		try {
			clientes = clienteDao.listarOrdemNome();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Cliente c : clientes) {
			extracted(mcv, c);
		}
		
		
		//Pegando ID da venda automaticamente
		mcv.txtidvenda.setText(String.valueOf(vendadao.buscarID()));
		
		
		super.add(mcv, BorderLayout.CENTER);
		
		super.setAcaoSalvar(mcv.getAcaoSalvar());
		
		super.setAcaoExcluir(mcv.getAcaoExcluir());
		
	}

	private void extracted(MioloCadVenda mcv, Cliente c) {
		mcv.cbxcliente.addItem(c.getNome());
	}
}
