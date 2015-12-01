package br.univel.relatorio;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.telas.MioloCadCliente;

public class TelaRelatorioCliente extends MolduraRelatorio{
	
	public TelaRelatorioCliente() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		
		MioloRelatorioCliente mrc = new MioloRelatorioCliente();
		super.add(mrc, BorderLayout.CENTER);
		
		super.setAcaoSalvar(mrc.getAcaoSalvar());
	}
	


}
