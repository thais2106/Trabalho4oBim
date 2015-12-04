package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.cliente.ClienteDAO;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.produto.Categoria;
/**
 * Campos do relatório de venda
 * @author tcrivelatti - 03/12/2015 - 19:56:08
 *
 */
public class MioloRelatorioVenda extends JPanel {
	private JTextField txtdatafim;
	private JTextField txtdataini;
	private JComboBox cbxCliente;
	private JComboBox cbxCategoria;
	private JComboBox cbxTipoRelatorio;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioVenda() {
		setLayout(null);
		
		JLabel lblVenda = new JLabel("Relat\u00F3rio de Vendas");
		lblVenda.setBounds(10, 0, 118, 14);
		add(lblVenda);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 405, 61);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTiposDeRelatrios = new JLabel("Tipos de Relat\u00F3rios");
		lblTiposDeRelatrios.setBounds(10, 9, 91, 14);
		panel.add(lblTiposDeRelatrios);
		
		cbxTipoRelatorio = new JComboBox();
		cbxTipoRelatorio.setBounds(10, 28, 385, 22);
		panel.add(cbxTipoRelatorio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 90, 405, 61);
		add(panel_1);
		panel_1.setLayout(null);
		
		cbxCliente = new JComboBox();
		cbxCliente.setEditable(true);
		cbxCliente.setEnabled(false);
		cbxCliente.setBounds(10, 28, 385, 20);
		panel_1.add(cbxCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 11, 86, 14);
		panel_1.add(lblCliente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 158, 200, 61);
		add(panel_2);
		
		JLabel lblCategoria = new JLabel("Categoria do produto");
		lblCategoria.setBounds(10, 11, 162, 14);
		panel_2.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setEditable(true);
		cbxCategoria.setEnabled(false);
		cbxCategoria.setBounds(10, 28, 180, 20);
		panel_2.add(cbxCategoria);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(215, 158, 200, 61);
		add(panel_3);
		
		JLabel lblDia = new JLabel("Per\u00EDodo");
		lblDia.setBounds(10, 11, 86, 14);
		panel_3.add(lblDia);
		
		txtdataini = new JTextField();
		txtdataini.setEnabled(false);
		txtdataini.setBounds(10, 27, 86, 20);
		panel_3.add(txtdataini);
		txtdataini.setColumns(10);
		
		txtdatafim = new JTextField();
		txtdatafim.setEnabled(false);
		txtdatafim.setBounds(106, 27, 86, 20);
		panel_3.add(txtdatafim);
		txtdatafim.setColumns(10);

		popularCbxTipoRelatorio();
		preencherCbxCliente();
		preencherCbxCategoria();

	}

	private void popularCbxTipoRelatorio() {
		cbxTipoRelatorio.addItem("Todas as vendas");
		cbxTipoRelatorio.addItem("Vendas por período")
		cbxTipoRelatorio.addItem("Vendas por cliente");
		cbxTipoRelatorio.addItem("Vendas por categoria");
	}

	private void preencherCbxCategoria() {
		cbxCategoria.addItem("Selecionar categoria");

		for (Categoria categoria : Categoria.values()) {
			cbxCategoria.addItem(categoria);
		}
	}

	private void preencherCbxCliente() {
		ClienteDAOImpl dao = new ClienteDAOImpl();
		try {
			dao.preencherCombobox(cbxCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Runnable setAcaoGerarRelatorio() {
		return () -> {
			String sql = "SELECT * FROM VENDA";
			
			/*
			if (cbxTipoRelatorio.getSelectedIndex()==0)
				sql = ;
				*/
			
			if (cbxTipoRelatorio.getSelectedIndex()==1)
				sql += gerarVendasPeriodo();
			
			if (cbxTipoRelatorio.getSelectedIndex()==2)
				sql += gerarVendasCliente();
			
			if (cbxTipoRelatorio.getSelectedIndex()==3)
				sql += gerarVendasCategoria;
			
			JasperReportUtil.geraRelatorioEmPdfConsulta(sql, "/RelatorioVendas.jasper", "RelatorioVendas");
			
			
		};
	}

	
			



	private String gerarVendasPeriodo(String sql) {
		txtdataini.setEnabled(true);
		txtdatafim.setEnabled(true);
		
		if (validarPeriodo()){
			
			
		}
	}

	private boolean validarPeriodo() {
		
		if (!txtdataini.getText().isEmpty() && txtdatafim.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Insira uma data final!");
			txtdatafim.requestFocus();
			return false;
		}
		
		if (txtdataini.getText().isEmpty() && !txtdatafim.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Insira uma data inicial!");
			txtdataini.requestFocus();
			return false;
		}
		
		return true;
	}
}
