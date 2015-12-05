package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.cliente.ClienteDAO;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.produto.Categoria;
import br.univel.telas.TelaProcuraCliente;
import br.univel.utilitarios.FileChooserUtil;
import br.univel.utilitarios.JasperReportUtil;
import br.univel.utilitarios.StatusBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.FileChooserUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Campos do relatório de venda
 * 
 * @author tcrivelatti - 03/12/2015 - 19:56:08
 *
 */
public class MioloRelatorioVenda extends JPanel {
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JComboBox cbxCategoria;
	private JComboBox cbxTipoRelatorio;
	private StatusBar statusBar = new StatusBar();
	private JTextField txtLocal;
	public JTextField txtcliente;
	private JButton btnProcurar;
	private static MioloRelatorioVenda instance;

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public static synchronized MioloRelatorioVenda getRelatorioVenda() {
		if (instance == null)
			instance = new MioloRelatorioVenda();

		return instance;
	}

	private MioloRelatorioVenda() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_status = new JPanel();
		panel_status.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		add(panel_status, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_status = new GridBagLayout();
		gbl_panel_status.columnWidths = new int[] { 165, 0 };
		gbl_panel_status.rowHeights = new int[] { 16, 0 };
		gbl_panel_status.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_status.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_status.setLayout(gbl_panel_status);
		GridBagConstraints gbc_statusBar = new GridBagConstraints();
		gbc_statusBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_statusBar.gridx = 0;
		gbc_statusBar.gridy = 0;
		panel_status.add(statusBar, gbc_statusBar);
		statusBar
				.setMessage("Deixe o período em branco para listar todas as vendas.");

		JPanel panel_content = new JPanel();
		add(panel_content, BorderLayout.CENTER);
		GridBagLayout gbl_panel_content = new GridBagLayout();
		gbl_panel_content.columnWidths = new int[] { 205, 204, 0 };
		gbl_panel_content.rowHeights = new int[] { 50, 50, 50, 50, 0 };
		gbl_panel_content.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_content.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_content.setLayout(gbl_panel_content);

		JPanel panel_tipo = new JPanel();
		panel_tipo.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Tipo de Relat\u00F3rio",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_tipo = new GridBagConstraints();
		gbc_panel_tipo.fill = GridBagConstraints.BOTH;
		gbc_panel_tipo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_tipo.gridwidth = 2;
		gbc_panel_tipo.gridx = 0;
		gbc_panel_tipo.gridy = 0;
		panel_content.add(panel_tipo, gbc_panel_tipo);
		GridBagLayout gbl_panel_tipo = new GridBagLayout();
		gbl_panel_tipo.columnWidths = new int[] { 391, 0 };
		gbl_panel_tipo.rowHeights = new int[] { 20, 0 };
		gbl_panel_tipo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_tipo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_tipo.setLayout(gbl_panel_tipo);

		cbxTipoRelatorio = new JComboBox();
		cbxTipoRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarCampos();
			}
		});
		GridBagConstraints gbc_cbxTipoRelatorio = new GridBagConstraints();
		gbc_cbxTipoRelatorio.anchor = GridBagConstraints.NORTH;
		gbc_cbxTipoRelatorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoRelatorio.gridx = 0;
		gbc_cbxTipoRelatorio.gridy = 0;
		panel_tipo.add(cbxTipoRelatorio, gbc_cbxTipoRelatorio);

		JPanel panel_periodo = new JPanel();
		panel_periodo.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Per\u00EDodo",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_periodo = new GridBagConstraints();
		gbc_panel_periodo.fill = GridBagConstraints.BOTH;
		gbc_panel_periodo.insets = new Insets(0, 0, 5, 5);
		gbc_panel_periodo.gridx = 0;
		gbc_panel_periodo.gridy = 1;
		panel_content.add(panel_periodo, gbc_panel_periodo);
		GridBagLayout gbl_panel_periodo = new GridBagLayout();
		gbl_panel_periodo.columnWidths = new int[] { 86, 86, 0 };
		gbl_panel_periodo.rowHeights = new int[] { 20, 0 };
		gbl_panel_periodo.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_periodo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_periodo.setLayout(gbl_panel_periodo);

		txtDataInicial = new JTextField();
		GridBagConstraints gbc_txtDataInicial = new GridBagConstraints();
		gbc_txtDataInicial.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDataInicial.insets = new Insets(0, 0, 0, 5);
		gbc_txtDataInicial.gridx = 0;
		gbc_txtDataInicial.gridy = 0;
		panel_periodo.add(txtDataInicial, gbc_txtDataInicial);
		txtDataInicial.setColumns(10);

		txtDataFinal = new JTextField();
		GridBagConstraints gbc_txtDataFinal = new GridBagConstraints();
		gbc_txtDataFinal.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDataFinal.gridx = 1;
		gbc_txtDataFinal.gridy = 0;
		panel_periodo.add(txtDataFinal, gbc_txtDataFinal);
		txtDataFinal.setColumns(10);

		JPanel panel_categoria = new JPanel();
		panel_categoria.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Categoria",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_categoria = new GridBagConstraints();
		gbc_panel_categoria.fill = GridBagConstraints.BOTH;
		gbc_panel_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_panel_categoria.gridx = 1;
		gbc_panel_categoria.gridy = 1;
		panel_content.add(panel_categoria, gbc_panel_categoria);
		GridBagLayout gbl_panel_categoria = new GridBagLayout();
		gbl_panel_categoria.columnWidths = new int[] { 184, 0 };
		gbl_panel_categoria.rowHeights = new int[] { 20, 0 };
		gbl_panel_categoria.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_panel_categoria.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_categoria.setLayout(gbl_panel_categoria);

		cbxCategoria = new JComboBox();
		cbxCategoria.setEnabled(false);
		GridBagConstraints gbc_cbxCategoria = new GridBagConstraints();
		gbc_cbxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxCategoria.anchor = GridBagConstraints.NORTH;
		gbc_cbxCategoria.gridx = 0;
		gbc_cbxCategoria.gridy = 0;
		panel_categoria.add(cbxCategoria, gbc_cbxCategoria);
		Categoria.comboboxCategoria(cbxCategoria);

		JPanel panel_cliente = new JPanel();
		panel_cliente.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_cliente = new GridBagConstraints();
		gbc_panel_cliente.fill = GridBagConstraints.BOTH;
		gbc_panel_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_panel_cliente.gridwidth = 2;
		gbc_panel_cliente.gridx = 0;
		gbc_panel_cliente.gridy = 2;
		panel_content.add(panel_cliente, gbc_panel_cliente);
		GridBagLayout gbl_panel_cliente = new GridBagLayout();
		gbl_panel_cliente.columnWidths = new int[] { 332, 49, 0 };
		gbl_panel_cliente.rowHeights = new int[] { 23, 0 };
		gbl_panel_cliente.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_cliente.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_cliente.setLayout(gbl_panel_cliente);

		btnProcurar = new JButton("");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcuraCliente tpc = new TelaProcuraCliente();
				tpc.setVisible(true);
				tpc.selectClienteRelatorioVenda();
			}
		});

		txtcliente = new JTextField();
		txtcliente.setEnabled(false);
		GridBagConstraints gbc_txtcliente = new GridBagConstraints();
		gbc_txtcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcliente.insets = new Insets(0, 0, 0, 5);
		gbc_txtcliente.gridx = 0;
		gbc_txtcliente.gridy = 0;
		panel_cliente.add(txtcliente, gbc_txtcliente);
		txtcliente.setColumns(10);
		btnProcurar.setIcon(new ImageIcon(MioloRelatorioVenda.class
				.getResource("/br/univel/icones/procura.png")));
		GridBagConstraints gbc_btnProcurar = new GridBagConstraints();
		gbc_btnProcurar.anchor = GridBagConstraints.EAST;
		gbc_btnProcurar.fill = GridBagConstraints.VERTICAL;
		gbc_btnProcurar.gridx = 1;
		gbc_btnProcurar.gridy = 0;
		panel_cliente.add(btnProcurar, gbc_btnProcurar);

		JPanel panel_salvar = new JPanel();
		panel_salvar.setBorder(new TitledBorder(null, "Salvar como",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_salvar = new GridBagConstraints();
		gbc_panel_salvar.fill = GridBagConstraints.BOTH;
		gbc_panel_salvar.gridwidth = 2;
		gbc_panel_salvar.gridx = 0;
		gbc_panel_salvar.gridy = 3;
		panel_content.add(panel_salvar, gbc_panel_salvar);
		GridBagLayout gbl_panel_salvar = new GridBagLayout();
		gbl_panel_salvar.columnWidths = new int[] { 292, 89, 0 };
		gbl_panel_salvar.rowHeights = new int[] { 23, 0 };
		gbl_panel_salvar.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_salvar.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_salvar.setLayout(gbl_panel_salvar);

		JButton btnLocal = new JButton("Local");
		btnLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileChooserUtil file = new FileChooserUtil();
				file.escolherLocal(txtLocal);
			}
		});

		txtLocal = new JTextField();
		txtLocal.setEditable(false);
		GridBagConstraints gbc_txtLocal = new GridBagConstraints();
		gbc_txtLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLocal.insets = new Insets(0, 0, 0, 5);
		gbc_txtLocal.gridx = 0;
		gbc_txtLocal.gridy = 0;
		panel_salvar.add(txtLocal, gbc_txtLocal);
		txtLocal.setColumns(10);
		GridBagConstraints gbc_btnLocal = new GridBagConstraints();
		gbc_btnLocal.anchor = GridBagConstraints.NORTH;
		gbc_btnLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLocal.gridx = 1;
		gbc_btnLocal.gridy = 0;
		panel_salvar.add(btnLocal, gbc_btnLocal);

		popularCbxTipoRelatorio();

	}

	private void popularCbxTipoRelatorio() {
		cbxTipoRelatorio.addItem("Vendas por período");
		cbxTipoRelatorio.addItem("Vendas por cliente");
		cbxTipoRelatorio.addItem("Vendas por categoria");
	}

	protected void habilitarCampos() {

		if (cbxTipoRelatorio.getSelectedIndex() == 1) {
			cbxCategoria.setEnabled(false);
			btnProcurar.setEnabled(true);
			txtcliente.setEnabled(true);
		} else if (cbxTipoRelatorio.getSelectedIndex() == 2) {
			txtcliente.setEnabled(false);
			btnProcurar.setEnabled(false);
			cbxCategoria.setEnabled(true);
		} else {
			txtcliente.setEnabled(false);
			btnProcurar.setEnabled(false);
			cbxCategoria.setEnabled(false);
		}

	}

	public Runnable setAcaoGerarRelatorio() {
		return () -> {
			FileChooserUtil file = new FileChooserUtil();
			String caminho = txtLocal.getText();
			String sql = "SELECT * FROM VENDA ";

			if (cbxTipoRelatorio.getSelectedIndex() == 0)
				sql += gerarVendasPeriodo();

			if (cbxTipoRelatorio.getSelectedIndex() == 1)
				sql += gerarVendasCliente();

			System.out.println("depois " + sql);

			if (cbxTipoRelatorio.getSelectedIndex() == 2)
				sql += gerarVendasCategoria();

			System.out.println("sql " + sql);

			if (file.validarLocal(txtLocal))
			JasperReportUtil.geraRelatorioEmPdfConsulta(sql,
					"/RelatorioVendas.jasper", caminho);

		};
	}

	private String gerarVendasCategoria() {
		String sql, categoria;

		categoria = cbxCategoria.getSelectedItem().toString();
		sql = " INNER JOIN item ON venda.idvenda = item.idvenda "
				+ "INNER JOIN produto ON produto.id = item.idproduto "
				+ "WHERE categoria like \"%" + categoria + "%\" ";

		return sql;
	}

	private String gerarVendasCliente() {
		String sql, nomeCliente;

		nomeCliente = txtcliente.getText();
		sql = "WHERE nomecliente like \"%" + nomeCliente + "%\" ";

		System.out.println("sql aqui");
		return sql;
	}

	private String gerarVendasPeriodo() {
		String sql = null;
		String dataInicial = txtDataInicial.getText();
		String dataFinal = txtDataFinal.getText();

		if (!dataInicial.isEmpty() && !dataFinal.isEmpty()) {
			if (validarPeriodo())
				sql += "WHERE datavenda BETWEEN STR_TO_DATE(" + dataInicial
						+ ", '%d/%m/%Y') AND " + "STR_TO_DATE(" + dataFinal
						+ ", '%d/%m/%Y')";

			/*
			 * sql += "WHERE datavenda BETWEEN CONVERT(DATETIME, " + dataInicial
			 * + ", 103) " + "AND CONVERT(DATETIME, " + dataFinal + ", 103)";
			 */
		}
		System.out.println("vai sair " + sql);
		return sql;
	}

	private boolean validarPeriodo() {

		if (!txtDataInicial.getText().isEmpty()
				&& txtDataFinal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira uma data final!");
			txtDataFinal.requestFocus();
			return false;
		}

		if (txtDataInicial.getText().isEmpty()
				&& !txtDataFinal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira uma data inicial!");
			txtDataInicial.requestFocus();
			return false;
		}

		return true;
	}
}
