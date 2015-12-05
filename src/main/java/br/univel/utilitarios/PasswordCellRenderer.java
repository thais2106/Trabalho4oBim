package br.univel.utilitarios;

import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PasswordCellRenderer extends JPasswordField implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
			
		int length =0;
        if (value instanceof String) {
            length =  ((String) value).length();
        } else if (value instanceof char[]) {
            length = ((char[])value).length;
        }
        setText(asterisks(length));
        return this;
	}

	private String asterisks(int length) {
		int tamanhoPadrao = 20;
		int tamanhoFalta = tamanhoPadrao - length;
		
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length + tamanhoFalta; i++) {
            sb.append('*');
        }
        return sb.toString();
	}
	
	

}
