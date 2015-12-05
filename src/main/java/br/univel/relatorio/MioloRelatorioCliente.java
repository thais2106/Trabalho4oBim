package br.univel.relatorio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import br.univel.cliente.UF;
import br.univel.utilitarios.FileChooserUtil;
import br.univel.utilitarios.JasperReportUtil;

public class MioloRelatorioCliente extends JPanel {
	private JTextField txtcidade;
	private JComboBox cbxuf;
	private JPanel panel_tipo;
	private JComboBox cbxTipoRelatorio;
	private JPanel panel_cidade;
	private JPanel panel_estado;
	private JPanel panel_salvar;
	private JTextField txtLocal;
	private JButton btnLocal;
	private JPanel panel_status;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 311, 129, 0 };
		gridBagLayout.rowHeights = new int[] { 57, 48, 46, 42, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel_tipo = new JPanel();
		panel_tipo.setBorder(new TitledBorder(null, "Tipo de Relat\u00F3rio",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_tipo = new GridBagConstraints();
		gbc_panel_tipo.fill = GridBagConstraints.BOTH;
		gbc_panel_tipo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_tipo.gridwidth = 2;
		gbc_panel_tipo.gridx = 0;
		gbc_panel_tipo.gridy = 0;
		add(panel_tipo, gbc_panel_tipo);
		GridBagLayout gbl_panel_tipo = new GridBagLayout();
		gbl_panel_tipo.columnWidths = new int[] { 427, 0 };
		gbl_panel_tipo.rowHeights = new int[] { 20, 0 };
		gbl_panel_tipo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_tipo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_tipo.setLayout(gbl_panel_tipo);

		cbxTipoRelatorio = new JComboBox();
		GridBagConstraints gbc_cbxTipoRelatorio = new GridBagConstraints();
		gbc_cbxTipoRelatorio.anchor = GridBagConstraints.NORTH;
		gbc_cbxTipoRelatorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoRelatorio.gridx = 0;
		gbc_cbxTipoRelatorio.gridy = 0;
		panel_tipo.add(cbxTipoRelatorio, gbc_cbxTipoRelatorio);

		panel_cidade = new JPanel();
		panel_cidade.setBorder(new TitledBorder(null, "Cidade",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_cidade = new GridBagConstraints();
		gbc_panel_cidade.fill = GridBagConstraints.BOTH;
		gbc_panel_cidade.insets = new Insets(0, 0, 5, 5);
		gbc_panel_cidade.gridx = 0;
		gbc_panel_cidade.gridy = 1;
		add(panel_cidade, gbc_panel_cidade);
		GridBagLayout gbl_panel_cidade = new GridBagLayout();
		gbl_panel_cidade.columnWidths = new int[] { 291, 0 };
		gbl_panel_cidade.rowHeights = new int[] { 20, 0 };
		gbl_panel_cidade.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_cidade.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_cidade.setLayout(gbl_panel_cidade);

		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.anchor = GridBagConstraints.NORTH;
		gbc_txtcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcidade.gridx = 0;
		gbc_txtcidade.gridy = 0;
		panel_cidade.add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);

		panel_estado = new JPanel();
		panel_estado.setBorder(new TitledBorder(null, "Estado",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_estado = new GridBagConstraints();
		gbc_panel_estado.fill = GridBagConstraints.BOTH;
		gbc_panel_estado.insets = new Insets(0, 0, 5, 0);
		gbc_panel_estado.gridx = 1;
		gbc_panel_estado.gridy = 1;
		add(panel_estado, gbc_panel_estado);
		panel_estado.setLayout(null);

		cbxuf = new JComboBox(UF.values());
		cbxuf.setBounds(10, 17, 112, 20);
		panel_estado.add(cbxuf);

		panel_salvar = new JPanel();
		panel_salvar.setBorder(new TitledBorder(null, "Salvar como",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_salvar = new GridBagConstraints();
		gbc_panel_salvar.anchor = GridBagConstraints.NORTH;
		gbc_panel_salvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_salvar.insets = new Insets(0, 0, 5, 0);
		gbc_panel_salvar.gridwidth = 2;
		gbc_panel_salvar.gridx = 0;
		gbc_panel_salvar.gridy = 2;
		add(panel_salvar, gbc_panel_salvar);
		GridBagLayout gbl_panel_salvar = new GridBagLayout();
		gbl_panel_salvar.columnWidths = new int[] { 351, 57, 0 };
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

		btnLocal = new JButton("Local");
		GridBagConstraints gbc_btnLocal = new GridBagConstraints();
		gbc_btnLocal.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnLocal.gridx = 1;
		gbc_btnLocal.gridy = 0;
		panel_salvar.add(btnLocal, gbc_btnLocal);

		panel_status = new JPanel();
		panel_status.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		GridBagConstraints gbc_panel_status = new GridBagConstraints();
		gbc_panel_status.anchor = GridBagConstraints.SOUTH;
		gbc_panel_status.fill = GridBagConstraints.BOTH;
		gbc_panel_status.gridwidth = 2;
		gbc_panel_status.gridx = 0;
		gbc_panel_status.gridy = 4;
		add(panel_status, gbc_panel_status);
		
		popularComboboxRelatorio();

	}

	private void popularComboboxRelatorio() {
		cbxTipoRelatorio.addItem("Todos os clientes");
		cbxTipoRelatorio.addItem("Clientes por cidade");
		cbxTipoRelatorio.addItem("Clientes por estado");
	}

	public Runnable getAcaoGerarRelatorio() throws SQLException {
		return () -> {
			FileChooserUtil file = new FileChooserUtil();
			String caminho = txtLocal.getText();
			String sql = "select * from cliente where ";
			
			if (cbxTipoRelatorio.getSelectedIndex()==1)
				sql += gerarClienteCidade();
			
			if (cbxTipoRelatorio.getSelectedIndex()==2)
				sql += gerarClienteEstado();

			if (file.validarLocal(txtLocal))
				JasperReportUtil.geraRelatorioEmPdfConsulta(sql,
						"/RelatorioClientes.jasper", caminho);

		};
	}

	private String gerarClienteEstado() {
		String sql = null;
		UF uf = (UF) cbxuf.getSelectedItem();
		sql += "uf like \"%" + uf.toString() + "%\" ";
		return sql;
	}

	private String gerarClienteCidade() {
		String sql = null;
		if (txtcidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe uma cidade!");
		} else {
			sql += "cidade like \"%" + txtcidade.getText() + "%\" ";
		}
		return sql;
	}
}
