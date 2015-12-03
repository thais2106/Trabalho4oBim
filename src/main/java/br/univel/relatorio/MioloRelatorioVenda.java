package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.cliente.ClienteDAO;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.produto.Categoria;

public class MioloRelatorioVenda extends JPanel {
	private JTextField txtdatafim;
	private JTextField txtdataini;
	private JComboBox cbxCliente;
	private JComboBox cbxProduto;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioVenda() {
		setLayout(null);
		
		JLabel lblVenda = new JLabel("Relat\u00F3rio de Vendas");
		lblVenda.setBounds(10, 0, 118, 14);
		add(lblVenda);
		
		JLabel lblDia = new JLabel("Per\u00EDodo");
		lblDia.setBounds(10, 25, 36, 14);
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
		lblCliente.setBounds(10, 72, 46, 14);
		add(lblCliente);
		
		cbxCliente = new JComboBox();
		cbxCliente.setBounds(10, 89, 300, 20);
		add(cbxCliente);
		
		JLabel lblCategoria = new JLabel("Categoria do produto");
		lblCategoria.setBounds(10, 119, 118, 14);
		add(lblCategoria);
		
		cbxProduto = new JComboBox(Categoria.values());
		cbxProduto.setBounds(10, 136, 300, 20);
		add(cbxProduto);
		
		preencherCbxCliente();

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
			
		};
	}
}
