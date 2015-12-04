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
	private JTextField txtcliente;
	private JButton btnProcurar;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioVenda() {
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
		panel_content.setLayout(null);

		JPanel panel_periodo = new JPanel();
		panel_periodo.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Per\u00EDodo",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_periodo.setBounds(10, 86, 205, 50);
		panel_content.add(panel_periodo);
		panel_periodo.setLayout(null);

		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(10, 19, 86, 20);
		panel_periodo.add(txtDataInicial);
		txtDataInicial.setColumns(10);

		txtDataFinal = new JTextField();
		txtDataFinal.setBounds(106, 19, 86, 20);
		panel_periodo.add(txtDataFinal);
		txtDataFinal.setColumns(10);

		JPanel panel_categoria = new JPanel();
		panel_categoria.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Categoria",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_categoria.setBounds(217, 86, 204, 50);
		panel_content.add(panel_categoria);
		panel_categoria.setLayout(null);

		cbxCategoria = new JComboBox();
		cbxCategoria.setEnabled(false);
		cbxCategoria.setBounds(10, 19, 184, 20);
		panel_categoria.add(cbxCategoria);

		JPanel panel_cliente = new JPanel();
		panel_cliente.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_cliente.setBounds(10, 147, 411, 50);
		panel_content.add(panel_cliente);
		panel_cliente.setLayout(null);
		
		txtcliente = new JTextField();
		txtcliente.setEnabled(false);
		txtcliente.setBounds(10, 19, 332, 20);
		panel_cliente.add(txtcliente);
		txtcliente.setColumns(10);
		
		btnProcurar = new JButton("");
		btnProcurar.setIcon(new ImageIcon(MioloRelatorioVenda.class.getResource("/br/univel/icones/procura.png")));
		btnProcurar.setBounds(352, 18, 49, 23);
		panel_cliente.add(btnProcurar);

		JPanel panel_tipo = new JPanel();
		panel_tipo.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Tipo de Relat\u00F3rio",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_tipo.setBounds(10, 29, 411, 50);
		panel_content.add(panel_tipo);
		panel_tipo.setLayout(null);

		cbxTipoRelatorio = new JComboBox();
		cbxTipoRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarCampos();
			}
		});
		cbxTipoRelatorio.setBounds(10, 20, 391, 20);
		panel_tipo.add(cbxTipoRelatorio);
		
		JPanel panel_salvar = new JPanel();
		panel_salvar.setBorder(new TitledBorder(null, "Salvar como", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_salvar.setBounds(10, 208, 411, 50);
		panel_content.add(panel_salvar);
		panel_salvar.setLayout(null);
		
		JButton btnLocal = new JButton("Local");
		btnLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolherLocal();
			}
		});
		btnLocal.setBounds(312, 16, 89, 23);
		panel_salvar.add(btnLocal);
		
		txtLocal = new JTextField();
		txtLocal.setEditable(false);
		txtLocal.setBounds(10, 17, 292, 20);
		panel_salvar.add(txtLocal);
		txtLocal.setColumns(10);

		popularCbxTipoRelatorio();
		Categoria.comboboxCategoria(cbxCategoria);
		
	}

	protected void escolherLocal() {
		JFileChooser file = new JFileChooser();
		int i = file.showSaveDialog(null);
		
		if (i==1){
			txtLocal.setText("");
		} else {
			File arquivo = file.getSelectedFile();
			txtLocal.setText(arquivo.getPath());
		}
		
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
			String caminho = txtLocal.getText();
			String sql = "SELECT * FROM VENDA";

			if (cbxTipoRelatorio.getSelectedIndex() == 0)
				sql += gerarVendasPeriodo(sql);

			if (cbxTipoRelatorio.getSelectedIndex() == 1)
				// sql += gerarVendasCliente();

				if (cbxTipoRelatorio.getSelectedIndex() == 2)
					// sql += gerarVendasCategoria;

					System.out.println("sql " + sql);

			JasperReportUtil.geraRelatorioEmPdfConsulta(sql,
					"/RelatorioVendas.jasper", caminho);

		};
	}

	private String gerarVendasPeriodo(String sql) {
		System.out.println("entrou gerar vendas " + sql);
		
		String dataInicial = txtDataInicial.getText();
		String dataFinal = txtDataFinal.getText();
		
		if (dataInicial.isEmpty() && dataFinal.isEmpty())
			return sql;
		else {
			if (validarPeriodo())
				sql += "WHERE data BETWEEN CONVERT(DATETIME, " + dataInicial
				+ ", 103) " + "AND CONVERT(DATETIME, " + dataFinal
				+ ", 103);";
			
			return sql;
		}
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
