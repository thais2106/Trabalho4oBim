package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.univel.cadastros.Cliente;
import br.univel.cadastros.ClienteDAOImpl;
import br.univel.cadastros.Venda;
import br.univel.cadastros.VendaDAOImpl;

/**
 * Campos da tela de venda
 * @author Thaís - 05/11/2015 - 16:15:22
 *
 */

public class MioloCadVenda extends JPanel {
	protected JTextField txtidvenda;
	protected JTextField txtvaltotal;
	protected JTextField txtpagamento;
	protected JTextField txttroco;
	protected JTextField txtidprod;
	protected JTextField txtquantidade;
	protected JTextField txtvalunit;
	protected JTable tableprodutos;
	protected JComboBox cbxcliente;

	/**
	 * Create the panel.
	 */
	public MioloCadVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblVenda = new JLabel("Venda");
		GridBagConstraints gbc_lblVenda = new GridBagConstraints();
		gbc_lblVenda.anchor = GridBagConstraints.WEST;
		gbc_lblVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenda.gridx = 0;
		gbc_lblVenda.gridy = 0;
		add(lblVenda, gbc_lblVenda);
		
		txtidvenda = new JTextField();
		txtidvenda.setEditable(false);
		GridBagConstraints gbc_txtidvenda = new GridBagConstraints();
		gbc_txtidvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidvenda.insets = new Insets(0, 0, 5, 5);
		gbc_txtidvenda.gridx = 0;
		gbc_txtidvenda.gridy = 1;
		add(txtidvenda, gbc_txtidvenda);
		txtidvenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);
		
		cbxcliente = new JComboBox();
		GridBagConstraints gbc_cbxcliente = new GridBagConstraints();
		gbc_cbxcliente.gridwidth = 5;
		gbc_cbxcliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbxcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxcliente.gridx = 0;
		gbc_cbxcliente.gridy = 3;
		add(cbxcliente, gbc_cbxcliente);
		
		JLabel lblProduto = new JLabel("C\u00F3digo produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.WEST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 4;
		add(lblProduto, gbc_lblProduto);
		
		JLabel lblDescricao = new JLabel("Descricao");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.WEST;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 1;
		gbc_lblDescricao.gridy = 4;
		add(lblDescricao, gbc_lblDescricao);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.WEST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 3;
		gbc_lblQuantidade.gridy = 4;
		add(lblQuantidade, gbc_lblQuantidade);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		GridBagConstraints gbc_lblValorUnitrio = new GridBagConstraints();
		gbc_lblValorUnitrio.anchor = GridBagConstraints.WEST;
		gbc_lblValorUnitrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorUnitrio.gridx = 4;
		gbc_lblValorUnitrio.gridy = 4;
		add(lblValorUnitrio, gbc_lblValorUnitrio);
		
		txtidprod = new JTextField();
		GridBagConstraints gbc_txtidprod = new GridBagConstraints();
		gbc_txtidprod.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidprod.insets = new Insets(0, 0, 5, 5);
		gbc_txtidprod.gridx = 0;
		gbc_txtidprod.gridy = 5;
		add(txtidprod, gbc_txtidprod);
		txtidprod.setColumns(10);
		
		JComboBox cbxproduto = new JComboBox();
		cbxproduto.setEditable(true);
		GridBagConstraints gbc_cbxproduto = new GridBagConstraints();
		gbc_cbxproduto.gridwidth = 2;
		gbc_cbxproduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbxproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxproduto.gridx = 1;
		gbc_cbxproduto.gridy = 5;
		add(cbxproduto, gbc_cbxproduto);
		
		txtquantidade = new JTextField();
		GridBagConstraints gbc_txtquantidade = new GridBagConstraints();
		gbc_txtquantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtquantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantidade.gridx = 3;
		gbc_txtquantidade.gridy = 5;
		add(txtquantidade, gbc_txtquantidade);
		txtquantidade.setColumns(10);
		
		txtvalunit = new JTextField();
		txtvalunit.setEditable(false);
		GridBagConstraints gbc_txtvalunit = new GridBagConstraints();
		gbc_txtvalunit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvalunit.insets = new Insets(0, 0, 5, 5);
		gbc_txtvalunit.gridx = 4;
		gbc_txtvalunit.gridy = 5;
		add(txtvalunit, gbc_txtvalunit);
		txtvalunit.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 5;
		gbc_btnOk.gridy = 5;
		add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);
		
		tableprodutos = new JTable();
		scrollPane.setViewportView(tableprodutos);
		
		JLabel lblValorTotal = new JLabel("Valor total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.WEST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 9;
		add(lblValorTotal, gbc_lblValorTotal);
		
		JLabel lblValor = new JLabel("Pagamento");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 2;
		gbc_lblValor.gridy = 9;
		add(lblValor, gbc_lblValor);
		
		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.WEST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 4;
		gbc_lblTroco.gridy = 9;
		add(lblTroco, gbc_lblTroco);
		
		txtvaltotal = new JTextField();
		GridBagConstraints gbc_txtvaltotal = new GridBagConstraints();
		gbc_txtvaltotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvaltotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtvaltotal.gridx = 0;
		gbc_txtvaltotal.gridy = 10;
		add(txtvaltotal, gbc_txtvaltotal);
		txtvaltotal.setColumns(10);
		
		txtpagamento = new JTextField();
		GridBagConstraints gbc_txtpagamento = new GridBagConstraints();
		gbc_txtpagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpagamento.insets = new Insets(0, 0, 0, 5);
		gbc_txtpagamento.gridx = 2;
		gbc_txtpagamento.gridy = 10;
		add(txtpagamento, gbc_txtpagamento);
		txtpagamento.setColumns(10);
		
		txttroco = new JTextField();
		txttroco.setEditable(false);
		GridBagConstraints gbc_txttroco = new GridBagConstraints();
		gbc_txttroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttroco.insets = new Insets(0, 0, 0, 5);
		gbc_txttroco.gridx = 4;
		gbc_txttroco.gridy = 10;
		add(txttroco, gbc_txttroco);
		txttroco.setColumns(10);
	}

	public Runnable getAcaoSalvar() {
		return () -> {
			VendaDAOImpl dao = new VendaDAOImpl();
			Venda v = new Venda();
		
			try {
				int id = dao.buscarID();
				txtidvenda.setText(String.valueOf(id));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			//v = setarValores();
			
			try {
				dao.inserir(v);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		};
	}

	private Venda setarValores() {
		Venda v = new Venda();
		/*
		v.setIdVenda(Integer.parseInt(txtidvenda.getText()));
		v.setIdCliente(idCliente);
		v.setNomeCliente(nomeCliente);
		v.setValorTotal(valorTotal);
		v.setValorPagamento(valorPagamento);
		
		*/
		
		
		return v;
	}

	public Runnable getAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

}
