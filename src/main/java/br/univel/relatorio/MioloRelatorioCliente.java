package br.univel.relatorio;

import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.univel.cliente.UF;

public class MioloRelatorioCliente extends JPanel {
	private JTextField txtcidade;
	private ButtonGroup buttongroup = new ButtonGroup();
	private JRadioButton radioUf;
	private JRadioButton radioCidade;
	private JComboBox cbxuf;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioCliente() {
		setLayout(null);
		
		JLabel lblPesquisaDeClientes = new JLabel("Pesquisa de Clientes");
		lblPesquisaDeClientes.setBounds(0, 0, 98, 14);
		add(lblPesquisaDeClientes);
		
		radioCidade = new JRadioButton("Cidade");
		radioCidade.setBounds(0, 19, 76, 23);
		add(radioCidade);
		buttongroup.add(radioCidade);
		
		txtcidade = new JTextField();
		txtcidade.setBounds(82, 20, 192, 20);
		add(txtcidade);
		txtcidade.setColumns(10);
		
		radioUf = new JRadioButton("Estado");
		radioUf.setBounds(280, 19, 64, 23);
		add(radioUf);
		buttongroup.add(radioUf);
		
		
		cbxuf = new JComboBox(UF.values());
		cbxuf.setBounds(350, 19, 82, 22);
		add(cbxuf);

	}
	
	public Runnable getAcaoGerarRelatorio() throws SQLException {
		return () -> {
			
			String sql = "select * from cliente where ";
			
			if (radioCidade.isSelected()){
				
				if (txtcidade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe uma cidade!");
				} else {
					sql += "cidade like \"%" + txtcidade.getText()  + "%\" ";
				}
			}
			
			if (radioUf.isSelected()) {
				UF uf = (UF) cbxuf.getSelectedItem();
				
				sql += "uf like \"%" + uf.toString() + "%\" ";
			}
			
			JasperReportUtil.geraRelatorioEmPdfConsulta(sql, "/RelatorioClientes.jasper", "RelatorioClientes");
			
		};
	}
}
