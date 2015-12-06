package br.univel.relatorio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.math.BigDecimal;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import net.sf.jasperreports.engine.util.JRStyledText.Run;
import br.univel.produto.Categoria;
import br.univel.utilitarios.FileChooserUtil;
import br.univel.utilitarios.GerarRelatorioUtil;
import br.univel.utilitarios.JasperReportUtil;
import br.univel.utilitarios.StatusBar;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;

/**
 * Tela para gerar relatório de produto.
 * 
 * @author tcrivelatti - 01/12/2015 - 20:08:31
 *
 */
public class MioloRelatorioProduto extends JPanel {
	private JComboBox cbxCategoria;
	private JTextField txtMargemLucro;
	private JPanel panel_tipo;
	private JComboBox cbxTipoRelatorio;
	private JPanel panel_salvar;
	private JTextField txtLocal;
	private JButton button;
	private JPanel panel_status;
	private StatusBar statusBar;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 46, 45, 50, 0, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel_tipo = new JPanel();
		panel_tipo.setBorder(new TitledBorder(null, "Tipo de Relat\u00F3rio",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_tipo = new GridBagConstraints();
		gbc_panel_tipo.fill = GridBagConstraints.BOTH;
		gbc_panel_tipo.insets = new Insets(20, 10, 5, 10);
		gbc_panel_tipo.gridwidth = 2;
		gbc_panel_tipo.gridx = 0;
		gbc_panel_tipo.gridy = 0;
		add(panel_tipo, gbc_panel_tipo);
		GridBagLayout gbl_panel_tipo = new GridBagLayout();
		gbl_panel_tipo.columnWidths = new int[] { 0, 0 };
		gbl_panel_tipo.rowHeights = new int[] { 20, 0 };
		gbl_panel_tipo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_tipo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_tipo.setLayout(gbl_panel_tipo);

		cbxTipoRelatorio = new JComboBox();
		cbxTipoRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensagensStatus();
			}
		});
		GridBagConstraints gbc_cbxTipoRelatorio = new GridBagConstraints();
		gbc_cbxTipoRelatorio.anchor = GridBagConstraints.NORTH;
		gbc_cbxTipoRelatorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoRelatorio.gridx = 0;
		gbc_cbxTipoRelatorio.gridy = 0;
		panel_tipo.add(cbxTipoRelatorio, gbc_cbxTipoRelatorio);

		JPanel panel_categoria = new JPanel();
		panel_categoria.setBorder(new TitledBorder(null,
				"Categoria do Produto", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		GridBagConstraints gbc_panel_categoria = new GridBagConstraints();
		gbc_panel_categoria.fill = GridBagConstraints.BOTH;
		gbc_panel_categoria.insets = new Insets(5, 10, 5, 10);
		gbc_panel_categoria.gridx = 0;
		gbc_panel_categoria.gridy = 1;
		add(panel_categoria, gbc_panel_categoria);
		GridBagLayout gbl_panel_categoria = new GridBagLayout();
		gbl_panel_categoria.columnWidths = new int[] { 0, 0 };
		gbl_panel_categoria.rowHeights = new int[] { 20, 0 };
		gbl_panel_categoria.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_panel_categoria.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_categoria.setLayout(gbl_panel_categoria);

		cbxCategoria = new JComboBox();
		GridBagConstraints gbc_cbxCategoria = new GridBagConstraints();
		gbc_cbxCategoria.anchor = GridBagConstraints.NORTH;
		gbc_cbxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxCategoria.gridx = 0;
		gbc_cbxCategoria.gridy = 0;
		panel_categoria.add(cbxCategoria, gbc_cbxCategoria);

		JPanel panel_margem = new JPanel();
		panel_margem.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Margem de Lucro",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_margem = new GridBagConstraints();
		gbc_panel_margem.fill = GridBagConstraints.BOTH;
		gbc_panel_margem.insets = new Insets(5, 5, 5, 10);
		gbc_panel_margem.gridx = 1;
		gbc_panel_margem.gridy = 1;
		add(panel_margem, gbc_panel_margem);
		GridBagLayout gbl_panel_margem = new GridBagLayout();
		gbl_panel_margem.columnWidths = new int[] { 0, 0 };
		gbl_panel_margem.rowHeights = new int[] { 20, 0 };
		gbl_panel_margem.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_margem.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_margem.setLayout(gbl_panel_margem);

		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.anchor = GridBagConstraints.NORTH;
		gbc_txtMargemLucro.gridx = 0;
		gbc_txtMargemLucro.gridy = 0;
		panel_margem.add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);

		panel_salvar = new JPanel();
		panel_salvar.setBorder(new TitledBorder(null, "Salvar como",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_salvar = new GridBagConstraints();
		gbc_panel_salvar.fill = GridBagConstraints.BOTH;
		gbc_panel_salvar.insets = new Insets(5, 10, 5, 10);
		gbc_panel_salvar.gridwidth = 2;
		gbc_panel_salvar.gridx = 0;
		gbc_panel_salvar.gridy = 2;
		add(panel_salvar, gbc_panel_salvar);
		GridBagLayout gbl_panel_salvar = new GridBagLayout();
		gbl_panel_salvar.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_salvar.rowHeights = new int[] { 23, 0 };
		gbl_panel_salvar.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_salvar.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_salvar.setLayout(gbl_panel_salvar);

		txtLocal = new JTextField();
		txtLocal.setEditable(false);
		txtLocal.setColumns(10);
		GridBagConstraints gbc_txtLocal = new GridBagConstraints();
		gbc_txtLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLocal.insets = new Insets(0, 0, 0, 5);
		gbc_txtLocal.gridx = 0;
		gbc_txtLocal.gridy = 0;
		panel_salvar.add(txtLocal, gbc_txtLocal);

		button = new JButton("Local");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileChooserUtil file = new FileChooserUtil();
				file.escolherLocal(txtLocal);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel_salvar.add(button, gbc_button);

		panel_status = new JPanel();
		panel_status.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		GridBagConstraints gbc_panel_status = new GridBagConstraints();
		gbc_panel_status.fill = GridBagConstraints.BOTH;
		gbc_panel_status.gridwidth = 2;
		gbc_panel_status.gridx = 0;
		gbc_panel_status.gridy = 4;
		add(panel_status, gbc_panel_status);
		panel_status.setLayout(new BorderLayout(0, 0));
		
		statusBar = new StatusBar();
		panel_status.add(statusBar, BorderLayout.CENTER);

		popularCombobox();
	}

	public void mensagensStatus() {
		if (cbxTipoRelatorio.getSelectedIndex()==0){
			statusBar.setMessage("Gerar relatório de todos os produtos cadastrados.");
			cbxCategoria.setEnabled(false);
			txtMargemLucro.setEnabled(false);
		}
		
		if (cbxTipoRelatorio.getSelectedIndex()==1){
			statusBar.setMessage("Gera relatório de produtos por categoria.");
			cbxCategoria.setEnabled(true);
			txtMargemLucro.setEnabled(false);
		}
		
		if (cbxTipoRelatorio.getSelectedIndex()==2){
			statusBar.setMessage("Gera relatório de produtos por margem de lucro.");
			cbxCategoria.setEnabled(false);
			txtMargemLucro.setEnabled(true);
		}
	}

	private void popularCombobox() {
		cbxTipoRelatorio.addItem("Todos os produtos");
		cbxTipoRelatorio.addItem("Produtos por categoria");
		cbxTipoRelatorio.addItem("Produtos por margem de lucro");
		
		Categoria.comboboxCategoria(cbxCategoria);
	}

	public Runnable setAcaoGerarRelatorio() {
		return () -> {
			
			String caminho = txtLocal.getText();
			String sql = "select * from produto";

			if (cbxTipoRelatorio.getSelectedIndex() == 1)
				sql += gerarProdutosCategoria();

			if (cbxTipoRelatorio.getSelectedIndex() == 2)
				sql += gerarProdutosMargem();

			GerarRelatorioUtil gr = new GerarRelatorioUtil();
			gr.gerarRelatorio(sql, "/RelatorioProdutos.jasper", caminho);	
		};
	}

	private String gerarProdutosMargem() {
		String sql = null;
		if (txtMargemLucro.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Informe uma margem de lucro!");
		else
			sql = " where margemlucro = " + new BigDecimal(txtMargemLucro.getText());
		return sql;
	}

	private String gerarProdutosCategoria() {
		String sql = null;
		String categoria = cbxCategoria.getSelectedItem().toString();
		sql = " WHERE categoria like \"%" + categoria + "%\" ";
		
		return sql;
	}
}
