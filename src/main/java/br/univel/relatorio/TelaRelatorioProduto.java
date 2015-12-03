package br.univel.relatorio;

import java.awt.BorderLayout;
import java.sql.SQLException;
/**
 * Classe que faz junção da tela do relatório de produtos com a moldura
 * @author tcrivelatti - 03/12/2015 - 19:38:49
 *
 */
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
