package br.univel.relatorio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.univel.conexao.ConexaoServidor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class JasperReportUtil {
	public static void geraRelatorioEmPdfConsulta(String sql, String jasper, String caminho) {
	//public static void geraRelatorioEmPdfConsulta(String sql, String jasper, String nomeRelatorio) {
		try {
			String saida = null;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("SQL", sql);

			InputStream jasperTemplate = JasperReportUtil.class.getClass().getResourceAsStream(jasper);
			
			JasperPrint print = JasperFillManager.fillReport(jasperTemplate, map, ConexaoServidor.getConnection());
			saida = caminho + ".pdf";
			//saida = "C:\\Users\\tcrivelatti\\Downloads\\" + nomeRelatorio + ".pdf";
			JasperExportManager.exportReportToPdfFile(print, saida);
			JOptionPane.showMessageDialog(null, "<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
					+ " ao Sistema operacional <br>para abrir com o visualizador" + " padrão.");

			Desktop.getDesktop().open(new File(saida));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
}