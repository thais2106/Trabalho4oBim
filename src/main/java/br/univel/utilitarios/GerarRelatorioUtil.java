package br.univel.utilitarios;


/**
 * Classe para gerar relatórios. Só é preciso passar a sql, o caminho do jasper e o caminho para
 * salvar o arquivo. Ele valida o caminho dado e depois o JasperReportUtil é chamado.
 * @author Thaís - 05/12/2015 - 14:34:55
 *
 */

public class GerarRelatorioUtil {
	
	public void gerarRelatorio(String sql, String relatorio, String caminhoArquivo) {
		FileChooserUtil file = new FileChooserUtil();
		
		if (file.validarLocal(caminhoArquivo))
			JasperReportUtil.geraRelatorioEmPdfConsulta(sql, relatorio, caminhoArquivo);
	}

}
