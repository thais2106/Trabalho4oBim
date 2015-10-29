package br.univel.telas;

import java.awt.BorderLayout;

/**
 * Tela que configura o MioloCadastroCliente e o DAOCliente na mesma tela
 * @author tcrivelatti - 28/10/2015 - 19:30
 *
 */
public class TelaCadastroCliente extends MolduraAbstrata{
	
	public TelaCadastroCliente(){
		super();
	}

	@Override
	protected void configuraMiolo() {
		MioloCadastroCliente mioloCadastroCliente = new MioloCadastroCliente();
		super.add(mioloCadastroCliente, BorderLayout.CENTER);
		super.setAcaoSalvar(mioloCadastroCliente.getAcaoSalvar());
	}
}
