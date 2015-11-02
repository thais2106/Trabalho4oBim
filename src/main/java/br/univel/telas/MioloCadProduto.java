package br.univel.telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
/**
 * Classe com os campos do Produto para preencher
 * @author Thaís - 02/11/2015 - 16:01:49
 *
 */
public class MioloCadProduto extends JPanel {
	private JTextField txtid;
	private JTextField txtcodbarras;
	private JTextField txtdescricao;
	private JTextField txtcusto;
	private JTextField txtmargem;
	private JComboBox cbxunidade;
	private JComboBox cbxcategoria;

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 0;
		gbc_txtid.gridy = 2;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 3;
		add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 3;
		add(lblCategoria, gbc_lblCategoria);
		
		txtcodbarras = new JTextField();
		GridBagConstraints gbc_txtcodbarras = new GridBagConstraints();
		gbc_txtcodbarras.gridwidth = 2;
		gbc_txtcodbarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtcodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodbarras.gridx = 0;
		gbc_txtcodbarras.gridy = 4;
		add(txtcodbarras, gbc_txtcodbarras);
		txtcodbarras.setColumns(10);
		
		cbxcategoria = new JComboBox();
		GridBagConstraints gbc_cbxcategoria = new GridBagConstraints();
		gbc_cbxcategoria.gridwidth = 2;
		gbc_cbxcategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cbxcategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxcategoria.gridx = 2;
		gbc_cbxcategoria.gridy = 4;
		add(cbxcategoria, gbc_cbxcategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.WEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 5;
		add(lblDescrio, gbc_lblDescrio);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.gridwidth = 4;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 0;
		gbc_txtdescricao.gridy = 6;
		add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.WEST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 7;
		add(lblUnidade, gbc_lblUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.WEST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 1;
		gbc_lblCusto.gridy = 7;
		add(lblCusto, gbc_lblCusto);
		
		JLabel lblMargemDeLucor = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucor = new GridBagConstraints();
		gbc_lblMargemDeLucor.anchor = GridBagConstraints.WEST;
		gbc_lblMargemDeLucor.insets = new Insets(0, 0, 5, 0);
		gbc_lblMargemDeLucor.gridx = 3;
		gbc_lblMargemDeLucor.gridy = 7;
		add(lblMargemDeLucor, gbc_lblMargemDeLucor);
		
		cbxunidade = new JComboBox();
		GridBagConstraints gbc_cbxunidade = new GridBagConstraints();
		gbc_cbxunidade.insets = new Insets(0, 0, 5, 5);
		gbc_cbxunidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxunidade.gridx = 0;
		gbc_cbxunidade.gridy = 8;
		add(cbxunidade, gbc_cbxunidade);
		
		txtcusto = new JTextField();
		GridBagConstraints gbc_txtcusto = new GridBagConstraints();
		gbc_txtcusto.gridwidth = 2;
		gbc_txtcusto.insets = new Insets(0, 0, 5, 5);
		gbc_txtcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcusto.gridx = 1;
		gbc_txtcusto.gridy = 8;
		add(txtcusto, gbc_txtcusto);
		txtcusto.setColumns(10);
		
		txtmargem = new JTextField();
		GridBagConstraints gbc_txtmargem = new GridBagConstraints();
		gbc_txtmargem.insets = new Insets(0, 0, 5, 0);
		gbc_txtmargem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmargem.gridx = 3;
		gbc_txtmargem.gridy = 8;
		add(txtmargem, gbc_txtmargem);
		txtmargem.setColumns(10);

	}

}
