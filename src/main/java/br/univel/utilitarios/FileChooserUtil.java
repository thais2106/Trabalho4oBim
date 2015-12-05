package br.univel.utilitarios;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileChooserUtil {
	
	public void escolherLocal(JTextField txtLocal) {
		JFileChooser file = new JFileChooser();
		int i = file.showSaveDialog(null);

		if (i == 1) {
			txtLocal.setText("");
		} else {
			File arquivo = file.getSelectedFile();
			txtLocal.setText(arquivo.getPath());
		}
	}
	
	public boolean validarLocal(String caminhoArquivo) {
		if (caminhoArquivo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um caminho para salvar o relatório!");
			return false;
		}
		return true;
	}

}
