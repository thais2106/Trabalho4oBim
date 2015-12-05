package br.univel.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.univel.tabelas.ItemModel;
import br.univel.venda.Item;
import br.univel.venda.Venda;
import br.univel.venda.VendaDAOImpl;

public class MioloCadVenda extends JPanel {
	private static MioloCadVenda instance;
	protected JTextField txtidvenda;
	protected JTextField txtidcliente;
	protected JTextField txtnomecliente;
	protected JTextField txtpreco;
	protected JTextField txtquantidade;
	protected JTextField txtdescricao;
	protected JTextField txtidproduto;
	protected JTable tabitens;
	protected JTextField txtpagamento;
	protected JTextField txtvaltotal;
	protected JTextField txttroco;
	protected ItemModel model;
	private JButton btnProcuraProduto;
	private JButton btnIncluir;
	private JButton btnExcluir;

	/**
	 * Create the panel.
	 */

	public synchronized static MioloCadVenda getInstance() {
		if (instance == null) {
			instance = new MioloCadVenda();
		}
		return instance;
	}

	private MioloCadVenda() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 632, 0 };
		gridBagLayout.rowHeights = new int[] { 35, 48, 97, 191, 79, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_codigo = new JPanel();
		GridBagConstraints gbc_panel_codigo = new GridBagConstraints();
		gbc_panel_codigo.anchor = GridBagConstraints.NORTH;
		gbc_panel_codigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_codigo.insets = new Insets(20, 10, 5, 10);
		gbc_panel_codigo.gridx = 0;
		gbc_panel_codigo.gridy = 0;
		add(panel_codigo, gbc_panel_codigo);
		GridBagLayout gbl_panel_codigo = new GridBagLayout();
		gbl_panel_codigo.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_codigo.rowHeights = new int[] { 30, 0 };
		gbl_panel_codigo.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_codigo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_codigo.setLayout(gbl_panel_codigo);

		JLabel lblVendaNmero = new JLabel("Venda n\u00FAmero:");
		lblVendaNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblVendaNmero = new GridBagConstraints();
		gbc_lblVendaNmero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVendaNmero.insets = new Insets(10, 0, 0, 5);
		gbc_lblVendaNmero.gridx = 0;
		gbc_lblVendaNmero.gridy = 0;
		panel_codigo.add(lblVendaNmero, gbc_lblVendaNmero);

		txtidvenda = new JTextField();
		GridBagConstraints gbc_txtidvenda = new GridBagConstraints();
		gbc_txtidvenda.insets = new Insets(10, 0, 0, 5);
		gbc_txtidvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidvenda.gridx = 1;
		gbc_txtidvenda.gridy = 0;
		panel_codigo.add(txtidvenda, gbc_txtidvenda);
		txtidvenda.setEditable(false);
		txtidvenda.setColumns(10);

		JButton btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNova.setIcon(new ImageIcon("src/main/resources/add.png"));
		GridBagConstraints gbc_btnNova = new GridBagConstraints();
		gbc_btnNova.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNova.insets = new Insets(10, 0, 0, 5);
		gbc_btnNova.gridx = 2;
		gbc_btnNova.gridy = 0;
		panel_codigo.add(btnNova, gbc_btnNova);

		JPanel panel_cliente = new JPanel();
		panel_cliente.setBorder(new TitledBorder(null, "Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_cliente = new GridBagConstraints();
		gbc_panel_cliente.anchor = GridBagConstraints.NORTH;
		gbc_panel_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_cliente.insets = new Insets(5, 10, 5, 10);
		gbc_panel_cliente.gridx = 0;
		gbc_panel_cliente.gridy = 1;
		add(panel_cliente, gbc_panel_cliente);
		GridBagLayout gbl_panel_cliente = new GridBagLayout();
		gbl_panel_cliente.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_cliente.rowHeights = new int[] { 25, 0 };
		gbl_panel_cliente.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_cliente.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_cliente.setLayout(gbl_panel_cliente);

		txtidcliente = new JTextField();
		GridBagConstraints gbc_txtidcliente = new GridBagConstraints();
		gbc_txtidcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidcliente.anchor = GridBagConstraints.SOUTH;
		gbc_txtidcliente.insets = new Insets(0, 0, 0, 5);
		gbc_txtidcliente.gridx = 0;
		gbc_txtidcliente.gridy = 0;
		panel_cliente.add(txtidcliente, gbc_txtidcliente);
		txtidcliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
					abrirProcuraCliente();
				}
			}
		});
		txtidcliente.setColumns(10);

		txtnomecliente = new JTextField();
		GridBagConstraints gbc_txtnomecliente = new GridBagConstraints();
		gbc_txtnomecliente.anchor = GridBagConstraints.SOUTH;
		gbc_txtnomecliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnomecliente.insets = new Insets(0, 0, 0, 5);
		gbc_txtnomecliente.gridx = 1;
		gbc_txtnomecliente.gridy = 0;
		panel_cliente.add(txtnomecliente, gbc_txtnomecliente);
		txtnomecliente.setColumns(10);

		JButton btnProcuraCliente = new JButton("");
		btnProcuraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirProcuraCliente();
			}
		});
		btnProcuraCliente.setIcon(new ImageIcon("src/main/resources/procura.png"));
		GridBagConstraints gbc_btnProcuraCliente = new GridBagConstraints();
		gbc_btnProcuraCliente.fill = GridBagConstraints.VERTICAL;
		gbc_btnProcuraCliente.anchor = GridBagConstraints.EAST;
		gbc_btnProcuraCliente.gridx = 2;
		gbc_btnProcuraCliente.gridy = 0;
		panel_cliente.add(btnProcuraCliente, gbc_btnProcuraCliente);

		JPanel panel_produto = new JPanel();
		panel_produto.setBorder(new TitledBorder(null, "Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_produto = new GridBagConstraints();
		gbc_panel_produto.anchor = GridBagConstraints.NORTH;
		gbc_panel_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_produto.insets = new Insets(5, 10, 5, 10);
		gbc_panel_produto.gridx = 0;
		gbc_panel_produto.gridy = 2;
		add(panel_produto, gbc_panel_produto);
		GridBagLayout gbl_panel_produto = new GridBagLayout();
		gbl_panel_produto.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_produto.rowHeights = new int[] { 15, 25, 25, 0 };
		gbl_panel_produto.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_produto.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_produto.setLayout(gbl_panel_produto);

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3d. produto");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		panel_produto.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 0;
		panel_produto.add(lblDescrio, gbc_lblDescrio);

		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.NORTH;
		gbc_lblQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 3;
		gbc_lblQuantidade.gridy = 0;
		panel_produto.add(lblQuantidade, gbc_lblQuantidade);

		JLabel lblPreo = new JLabel("Pre\u00E7o unit\u00E1rio");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.anchor = GridBagConstraints.SOUTH;
		gbc_lblPreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPreo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPreo.gridx = 4;
		gbc_lblPreo.gridy = 0;
		panel_produto.add(lblPreo, gbc_lblPreo);

		txtidproduto = new JTextField();
		GridBagConstraints gbc_txtidproduto = new GridBagConstraints();
		gbc_txtidproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidproduto.anchor = GridBagConstraints.SOUTH;
		gbc_txtidproduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtidproduto.gridx = 0;
		gbc_txtidproduto.gridy = 1;
		panel_produto.add(txtidproduto, gbc_txtidproduto);
		txtidproduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
					abrirProcuraProduto();
				}
			}
		});
		txtidproduto.setColumns(10);

		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.anchor = GridBagConstraints.SOUTH;
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtdescricao.gridx = 1;
		gbc_txtdescricao.gridy = 1;
		panel_produto.add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);

		btnProcuraProduto = new JButton("");
		btnProcuraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirProcuraProduto();
			}
		});
		btnProcuraProduto.setIcon(new ImageIcon("src/main/resources/procura.png"));
		GridBagConstraints gbc_btnProcuraProduto = new GridBagConstraints();
		gbc_btnProcuraProduto.fill = GridBagConstraints.BOTH;
		gbc_btnProcuraProduto.insets = new Insets(0, 0, 5, 5);
		gbc_btnProcuraProduto.gridx = 2;
		gbc_btnProcuraProduto.gridy = 1;
		panel_produto.add(btnProcuraProduto, gbc_btnProcuraProduto);

		txtquantidade = new JTextField();
		GridBagConstraints gbc_txtquantidade = new GridBagConstraints();
		gbc_txtquantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtquantidade.anchor = GridBagConstraints.SOUTH;
		gbc_txtquantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantidade.gridx = 3;
		gbc_txtquantidade.gridy = 1;
		panel_produto.add(txtquantidade, gbc_txtquantidade);
		txtquantidade.setColumns(10);

		txtpreco = new JTextField();
		GridBagConstraints gbc_txtpreco = new GridBagConstraints();
		gbc_txtpreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpreco.anchor = GridBagConstraints.SOUTH;
		gbc_txtpreco.insets = new Insets(0, 0, 5, 0);
		gbc_txtpreco.gridx = 4;
		gbc_txtpreco.gridy = 1;
		panel_produto.add(txtpreco, gbc_txtpreco);
		txtpreco.setColumns(10);

		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirItem();
			}
		});
		btnIncluir.setIcon(new ImageIcon("src/main/resources/add.png"));
		GridBagConstraints gbc_btnIncluir = new GridBagConstraints();
		gbc_btnIncluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIncluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnIncluir.gridx = 3;
		gbc_btnIncluir.gridy = 2;
		panel_produto.add(btnIncluir, gbc_btnIncluir);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("src/main/resources/delete.png"));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 2;
		panel_produto.add(btnExcluir, gbc_btnExcluir);

		JPanel panel_venda = new JPanel();
		panel_venda.setBorder(new TitledBorder(null, "Itens da Venda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_venda = new GridBagConstraints();
		gbc_panel_venda.fill = GridBagConstraints.BOTH;
		gbc_panel_venda.insets = new Insets(5, 10, 5, 10);
		gbc_panel_venda.gridx = 0;
		gbc_panel_venda.gridy = 3;
		add(panel_venda, gbc_panel_venda);
		GridBagLayout gbl_panel_venda = new GridBagLayout();
		gbl_panel_venda.columnWidths = new int[] { 416, 172, 0 };
		gbl_panel_venda.rowHeights = new int[] { 145, 23, 0 };
		gbl_panel_venda.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_venda.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_venda.setLayout(gbl_panel_venda);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_venda.add(scrollPane, gbc_scrollPane);

		tabitens = new JTable();
		tabitens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					alterarItem();
				}
			}
		});
		tabitens.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
					model.excluirItem(tabitens.getSelectedRow());
				}
			}
		});
		scrollPane.setViewportView(tabitens);

		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 1;
		panel_venda.add(lblTotal, gbc_lblTotal);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtvaltotal = new JTextField();
		txtvaltotal.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_txtvaltotal = new GridBagConstraints();
		gbc_txtvaltotal.anchor = GridBagConstraints.NORTH;
		gbc_txtvaltotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvaltotal.gridx = 1;
		gbc_txtvaltotal.gridy = 1;
		panel_venda.add(txtvaltotal, gbc_txtvaltotal);
		txtvaltotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtvaltotal.setEditable(false);
		txtvaltotal.setColumns(10);

		JPanel panel_pagamento = new JPanel();
		panel_pagamento.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Pagamento",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_pagamento = new GridBagConstraints();
		gbc_panel_pagamento.insets = new Insets(5, 10, 5, 10);
		gbc_panel_pagamento.fill = GridBagConstraints.BOTH;
		gbc_panel_pagamento.gridx = 0;
		gbc_panel_pagamento.gridy = 4;
		add(panel_pagamento, gbc_panel_pagamento);
		GridBagLayout gbl_panel_pagamento = new GridBagLayout();
		gbl_panel_pagamento.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_pagamento.rowHeights = new int[] { 15, 21, 0 };
		gbl_panel_pagamento.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_pagamento.rowWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		panel_pagamento.setLayout(gbl_panel_pagamento);

		JLabel lblPagamento = new JLabel("Valor ");
		GridBagConstraints gbc_lblPagamento = new GridBagConstraints();
		gbc_lblPagamento.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagamento.gridx = 0;
		gbc_lblPagamento.gridy = 0;
		panel_pagamento.add(lblPagamento, gbc_lblPagamento);

		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 0);
		gbc_lblTroco.gridx = 1;
		gbc_lblTroco.gridy = 0;
		panel_pagamento.add(lblTroco, gbc_lblTroco);

		txtpagamento = new JTextField();
		GridBagConstraints gbc_txtpagamento = new GridBagConstraints();
		gbc_txtpagamento.anchor = GridBagConstraints.NORTH;
		gbc_txtpagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpagamento.insets = new Insets(0, 0, 0, 5);
		gbc_txtpagamento.gridx = 0;
		gbc_txtpagamento.gridy = 1;
		panel_pagamento.add(txtpagamento, gbc_txtpagamento);
		txtpagamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER)
					calcularTroco();
			}
		});
		txtpagamento.setColumns(10);

		txttroco = new JTextField();
		GridBagConstraints gbc_txttroco = new GridBagConstraints();
		gbc_txttroco.anchor = GridBagConstraints.SOUTH;
		gbc_txttroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttroco.gridx = 1;
		gbc_txttroco.gridy = 1;
		panel_pagamento.add(txttroco, gbc_txttroco);
		txttroco.setEditable(false);
		txttroco.setColumns(10);

		setModelTabela();

	}

	protected void limparCampos() {
		buscarID();
		txtidcliente.setText("");
		txtnomecliente.setText("");
		txtidproduto.setText("");
		txtdescricao.setText("");
		txtquantidade.setText("");
		txtvaltotal.setText("");
		txtpagamento.setText("");
		txttroco.setText("");
		txtidcliente.requestFocus();
		setModelTabela();
		;
	}

	private int buscarID() {
		VendaDAOImpl dao = new VendaDAOImpl();
		int id = 0;

		try {
			id = dao.buscarID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	protected void calcularTroco() {
		BigDecimal troco = new BigDecimal(0);
		BigDecimal pagamento = new BigDecimal(txtpagamento.getText());

		troco = pagamento.subtract(new BigDecimal(txtvaltotal.getText()));

		txttroco.setText(String.valueOf(troco));
	}

	protected void incluirItem() {

		List<Item> itens = model.retornarItens();
		Item i = new Item();

		i.setIdproduto(Integer.parseInt(txtidproduto.getText()));
		i.setDescricao(txtdescricao.getText());
		i.setQuantidade(Integer.parseInt(txtquantidade.getText()));
		i.setPrecounitario(new BigDecimal(
				Double.parseDouble(txtpreco.getText())));

		int qtd = Integer.parseInt(txtquantidade.getText());
		BigDecimal preco = new BigDecimal(txtpreco.getText());

		// Multiplicando o preco unitário pela quantidade
		preco = preco.multiply(new BigDecimal(qtd));
		i.setTotalProduto(preco);

		// Adicionando na tabela de Itens
		model.incluirItem(i);

		BigDecimal total = calcularTotal(itens);
		txtvaltotal.setText(String.valueOf(total));

	}

	protected void alterarItem() {
		txtidproduto.setText(String.valueOf(tabitens.getValueAt(
				tabitens.getSelectedRow(), 0)));
		txtdescricao.setText(String.valueOf(tabitens.getValueAt(
				tabitens.getSelectedRow(), 1)));
		txtquantidade.setText(String.valueOf(tabitens.getValueAt(
				tabitens.getSelectedRow(), 2)));
		txtpreco.setText(String.valueOf(tabitens.getValueAt(
				tabitens.getSelectedRow(), 3)));
	}

	private void setModelTabela() {
		model = new ItemModel();
		tabitens.setModel(model);
	}

	public Runnable getAcaoSalvar() {
		return () -> {
			VendaDAOImpl dao = new VendaDAOImpl();
			Venda v = new Venda();

			if (verificarValores()) {
				v = setarValores();
				try {
					dao.inserir(v);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
		};
	}

	private boolean verificarValores() {
		int id = 0;

		if (txtidcliente.getText().isEmpty()
				|| txtnomecliente.getText().isEmpty()
				|| txtidproduto.getText().isEmpty()
				|| txtdescricao.getText().isEmpty()
				|| txtquantidade.getText().isEmpty()
				|| txtvaltotal.getText().isEmpty()
				|| txtpagamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Preencha todos os campos para salvar!");
			return false;
		}
		if (model.retornarItens().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Não é possível salvar uma venda sem produtos!");
			return false;
		}
		try {
			id = Integer.parseInt(txtidcliente.getText());
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(null,
							"Código do cliente inválido! \n Informe um valor numérico.");
			// return false;
		}
		try {
			id = Integer.parseInt(txtidproduto.getText());
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null,
							"Código do produto inválido! \n Informe um valor numérico.");
		}

		try {
			id = Integer.parseInt(txtquantidade.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Quantidade inválida! \n Informe um valor numérico.");
		}
		return true;
	}

	private BigDecimal calcularTotal(List<Item> itens) {
		BigDecimal total = new BigDecimal(0);

		for (Item item : itens) {
			total = total.add(item.getTotalProduto());
		}

		return total;
	}

	public Runnable getAcaoExcluir() {
		return null;
	}

	private Venda setarValores() {

		Venda v = new Venda();

		v.setIdVenda(Integer.parseInt(txtidvenda.getText()));
		v.setIdCliente(Integer.parseInt(txtidcliente.getText()));
		v.setNomeCliente(txtnomecliente.getText());
		v.setValorPagamento(new BigDecimal(txtpagamento.getText()));
		v.setValorTotal(new BigDecimal(txtvaltotal.getText()));
		v.setItens(model.retornarItens());
		v.setData(new Date());
		v.setHora(System.currentTimeMillis());

		return v;
	}

	public void abrirProcuraProduto() {
		TelaProcuraProduto tpp = new TelaProcuraProduto();
		tpp.setVisible(true);
	}

	public void abrirProcuraCliente() {
		TelaProcuraCliente tpc = new TelaProcuraCliente();
		tpc.setVisible(true);
		tpc.selectClienteTelaVenda();
	}
}
