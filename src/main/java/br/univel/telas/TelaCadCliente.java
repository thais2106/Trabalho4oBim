package br.univel.telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.cliente.ClienteDAOImpl;

/**
 * Tela que configura o MioloCadastroCliente e o DAOCliente na mesma tela
 * @author tcrivelatti - 28/10/2015 - 19:30
 *
 */
public class TelaCadCliente extends MolduraAbstrata{
	
	private ClienteDAOImpl dao;
	
	public TelaCadCliente(){
		super();
	}

	@Override
	protected void configuraMiolo() {
		MioloCadCliente mcc = new MioloCadCliente();
		dao = new ClienteDAOImpl();
		
		try {
			mcc.txtid.setText(String.valueOf(dao.buscarID()));
		} catch (SQLException e1) {
			System.out.println("Erro ao buscar código do cliente!");
			e1.printStackTrace();
		}
		
		super.add(mcc, BorderLayout.CENTER);
		
		try {
			super.setAcaoSalvar(mcc.getAcaoSalvar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.setAcaoExcluir(mcc.getAcaoExcluir());
	}
}
