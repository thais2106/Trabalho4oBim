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

/**
 * Tela para gerar relatório de produto.
 * @author tcrivelatti - 01/12/2015 - 20:08:31
 *
 */
public class MioloRelatorioProduto extends JPanel {
	private JRadioButton radioCategoria;
	private JComboBox cbxcategoria;
	private JRadioButton radioMargemLucro;
	private JTextField txtmargemlucro;

	/**
	 * Create the panel.
	 */
	public MioloRelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPesquisarProduto = new JLabel("Pesquisar produto");
		GridBagConstraints gbc_lblPesquisarProduto = new GridBagConstraints();
		gbc_lblPesquisarProduto.anchor = GridBagConstraints.WEST;
		gbc_lblPesquisarProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesquisarProduto.gridx = 0;
		gbc_lblPesquisarProduto.gridy = 0;
		add(lblPesquisarProduto, gbc_lblPesquisarProduto);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		radioCategoria = new JRadioButton("Categoria");
		GridBagConstraints gbc_radioCategoria = new GridBagConstraints();
		gbc_radioCategoria.anchor = GridBagConstraints.WEST;
		gbc_radioCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_radioCategoria.gridx = 0;
		gbc_radioCategoria.gridy = 0;
		panel.add(radioCategoria, gbc_radioCategoria);
		
		cbxcategoria = new JComboBox(Categoria.values());
		GridBagConstraints gbc_cbxcategoria = new GridBagConstraints();
		gbc_cbxcategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxcategoria.gridx = 0;
		gbc_cbxcategoria.gridy = 1;
		panel.add(cbxcategoria, gbc_cbxcategoria);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		radioMargemLucro = new JRadioButton("Margem de lucro");
		GridBagConstraints gbc_radioMargemLucro = new GridBagConstraints();
		gbc_radioMargemLucro.anchor = GridBagConstraints.WEST;
		gbc_radioMargemLucro.insets = new Insets(0, 0, 5, 0);
		gbc_radioMargemLucro.gridx = 0;
		gbc_radioMargemLucro.gridy = 0;
		panel_1.add(radioMargemLucro, gbc_radioMargemLucro);
		
		txtmargemlucro = new JTextField();
		GridBagConstraints gbc_txtmargemlucro = new GridBagConstraints();
		gbc_txtmargemlucro.anchor = GridBagConstraints.WEST;
		gbc_txtmargemlucro.gridx = 0;
		gbc_txtmargemlucro.gridy = 1;
		panel_1.add(txtmargemlucro, gbc_txtmargemlucro);
		txtmargemlucro.setColumns(10);
		

	}

	public Runnable setAcaoGerarRelatorio() {
		return () -> {
			String sql = "select * from produto where ";
			
			if (radioCategoria.isSelected()){
				Categoria c = (Categoria) cbxcategoria.getSelectedItem();
				
				sql += "categoria like \"%" + c.toString() + "%\" ";
			}
			
			if (radioMargemLucro.isSelected()){
				if (txtmargemlucro.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Informe uma margem de lucro!");
				else {
					sql += "margemlucro = " + new BigDecimal(txtmargemlucro.getText());
				
							//BigDecimal margem = ;
					
				}	 
				
			}
			
			JasperReportUtil.geraRelatorioEmPdfConsulta(sql, "/RelatorioProdutos.jasper", "RelatorioProdutos");
			
		};
	}

}
