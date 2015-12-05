package br.univel.relatorio;

import java.awt.BorderLayout;
import java.sql.SQLException;

/**
 * Classe que faz junção da tela do relatório de vendas com a moldura
 * @author tcrivelatti - 03/12/2015 - 19:36:27
 *
 */
public class TelaRelatorioVenda extends MolduraRelatorio{
	
	public TelaRelatorioVenda() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		MioloRelatorioVenda mrv = MioloRelatorioVenda.getRelatorioVenda();
		super.add(mrv, BorderLayout.CENTER);
		
		super.setAcaoGerarRelatorio(mrv.setAcaoGerarRelatorio());	
	}

}
