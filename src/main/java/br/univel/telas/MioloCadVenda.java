package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;

public class MioloCadVenda extends JPanel {
	protected JTextField txtidvenda;
	protected JComboBox cbxcliente;
	protected JTextField txtpreco;
	protected JTextField txtquantidade;
	protected JTextField txtdescricao;
	protected JTextField txtcodbarras;
	protected JTable tabitens;
	protected JTextField txtpagamento;
	protected JTextField txtvaltotal;
	protected JTextField txttroco;

	/**
	 * Create the panel.
	 */
	public MioloCadVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblVenda = new JLabel("Venda");
		GridBagConstraints gbc_lblVenda = new GridBagConstraints();
		gbc_lblVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenda.gridx = 0;
		gbc_lblVenda.gridy = 0;
		add(lblVenda, gbc_lblVenda);
		
		txtidvenda = new JTextField();
		GridBagConstraints gbc_txtidvenda = new GridBagConstraints();
		gbc_txtidvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidvenda.gridwidth = 3;
		gbc_txtidvenda.insets = new Insets(0, 0, 5, 5);
		gbc_txtidvenda.gridx = 0;
		gbc_txtidvenda.gridy = 1;
		add(txtidvenda, gbc_txtidvenda);
		txtidvenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.fill = GridBagConstraints.HORIZONTAL;
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
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		panel.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 0;
		panel.add(lblDescrio, gbc_lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 7;
		gbc_lblQuantidade.gridy = 0;
		panel.add(lblQuantidade, gbc_lblQuantidade);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreo.gridx = 8;
		gbc_lblPreo.gridy = 0;
		panel.add(lblPreo, gbc_lblPreo);
		
		txtcodbarras = new JTextField();
		GridBagConstraints gbc_txtcodbarras = new GridBagConstraints();
		gbc_txtcodbarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtcodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodbarras.gridx = 0;
		gbc_txtcodbarras.gridy = 1;
		panel.add(txtcodbarras, gbc_txtcodbarras);
		txtcodbarras.setColumns(10);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.gridwidth = 6;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 1;
		gbc_txtdescricao.gridy = 1;
		panel.add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);
		
		txtquantidade = new JTextField();
		GridBagConstraints gbc_txtquantidade = new GridBagConstraints();
		gbc_txtquantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtquantidade.gridx = 7;
		gbc_txtquantidade.gridy = 1;
		panel.add(txtquantidade, gbc_txtquantidade);
		txtquantidade.setColumns(10);
		
		txtpreco = new JTextField();
		GridBagConstraints gbc_txtpreco = new GridBagConstraints();
		gbc_txtpreco.gridwidth = 2;
		gbc_txtpreco.insets = new Insets(0, 0, 5, 5);
		gbc_txtpreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpreco.gridx = 8;
		gbc_txtpreco.gridy = 1;
		panel.add(txtpreco, gbc_txtpreco);
		txtpreco.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 10;
		gbc_btnOk.gridy = 1;
		panel.add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		tabitens = new JTable();
		scrollPane.setViewportView(tabitens);
		
		JLabel lblTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 5;
		add(lblTotal, gbc_lblTotal);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		GridBagConstraints gbc_lblPagamento = new GridBagConstraints();
		gbc_lblPagamento.anchor = GridBagConstraints.WEST;
		gbc_lblPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagamento.gridx = 1;
		gbc_lblPagamento.gridy = 5;
		add(lblPagamento, gbc_lblPagamento);
		
		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.WEST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 3;
		gbc_lblTroco.gridy = 5;
		add(lblTroco, gbc_lblTroco);
		
		txtvaltotal = new JTextField();
		GridBagConstraints gbc_txtvaltotal = new GridBagConstraints();
		gbc_txtvaltotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtvaltotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvaltotal.gridx = 0;
		gbc_txtvaltotal.gridy = 6;
		add(txtvaltotal, gbc_txtvaltotal);
		txtvaltotal.setColumns(10);
		
		txtpagamento = new JTextField();
		GridBagConstraints gbc_txtpagamento = new GridBagConstraints();
		gbc_txtpagamento.insets = new Insets(0, 0, 0, 5);
		gbc_txtpagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpagamento.gridx = 1;
		gbc_txtpagamento.gridy = 6;
		add(txtpagamento, gbc_txtpagamento);
		txtpagamento.setColumns(10);
		
		txttroco = new JTextField();
		GridBagConstraints gbc_txttroco = new GridBagConstraints();
		gbc_txttroco.gridwidth = 2;
		gbc_txttroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttroco.gridx = 3;
		gbc_txttroco.gridy = 6;
		add(txttroco, gbc_txttroco);
		txttroco.setColumns(10);

	}

	public Runnable getAcaoSalvar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Runnable getAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}
}
