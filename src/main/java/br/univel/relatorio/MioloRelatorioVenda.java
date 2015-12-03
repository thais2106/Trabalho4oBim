package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

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

	/**
	 * Create the panel.
	 */
	public MioloRelatorioVenda() {
		setLayout(null);
		
		JLabel lblVenda = new JLabel("Relat\u00F3rio de Vendas");
		lblVenda.setBounds(10, 0, 118, 14);
		add(lblVenda);
		
		JLabel lblDia = new JLabel("Per\u00EDodo");
		lblDia.setBounds(10, 25, 86, 14);
		add(lblDia);
		
		txtdataini = new JTextField();
		txtdataini.setBounds(10, 41, 86, 20);
		add(txtdataini);
		txtdataini.setColumns(10);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(102, 44, 26, 14);
		add(lblA);
		
		txtdatafim = new JTextField();
		txtdatafim.setBounds(112, 41, 86, 20);
		add(txtdatafim);
		txtdatafim.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 72, 86, 14);
		add(lblCliente);
		
		cbxCliente = new JComboBox();
		cbxCliente.setBounds(10, 89, 300, 20);
		add(cbxCliente);
		
		JLabel lblCategoria = new JLabel("Categoria do produto");
		lblCategoria.setBounds(10, 119, 162, 14);
		add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(10, 136, 300, 20);
		add(cbxCategoria);

		preencherCbxCliente();
		preencherCbxCategoria();

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
			
			String sql = "SELECT * FROM venda WHERE ";
			
			if (validarPeriodo()){
				
				sql += "data BETWEEN";
				
				if (cbxCliente.getSelectedIndex() != 0){
					String cliente = cbxCliente.getSelectedItem().toString();
					sql += "AND nomecliente like \"%" + cliente + "%\" ";
				}
				
				if (cbxCategoria.getSelectedIndex() != 0){
					String categoria = cbxCategoria.getSelectedItem().toString();
					sql += "AND categoria like \"%" + categoria + "%\" ";
				}
				
				
				
			}
			
			
		};
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
