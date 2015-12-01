package br.univel.relatorio;

import java.awt.BorderLayout;
import java.sql.SQLException;

public class TelaRelatorioProduto extends MolduraRelatorio{
	
	public TelaRelatorioProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		MioloRelatorioProduto mrp = new MioloRelatorioProduto();
		super.add(mrp, BorderLayout.CENTER);
		
		super.setAcaoGerarRelatorio(mrp.setAcaoGerarRelatorio());
	}

}
