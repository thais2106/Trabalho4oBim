package br.univel.relatorio;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.telas.MioloCadCliente;
/**
 * Classe que faz junção da tela do relatório de cliente com a moldura
 * @author tcrivelatti - 03/12/2015 - 19:39:08
 *
 */
public class TelaRelatorioCliente extends MolduraRelatorio{
	
	public TelaRelatorioCliente() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		
		MioloRelatorioCliente mrc = new MioloRelatorioCliente();
		super.add(mrc, BorderLayout.CENTER);
		
		super.setAcaoGerarRelatorio(mrc.getAcaoGerarRelatorio());
	}
	


}
