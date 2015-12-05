package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.venda.VendaDAOImpl;

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
		MioloCadVenda mcv = MioloCadVenda.getInstance();		
		super.add(mcv, BorderLayout.CENTER);
		
		super.setAcaoSalvar(mcv.getAcaoSalvar());
		super.setAcaoExcluir(mcv.getAcaoExcluir());
	}
}
