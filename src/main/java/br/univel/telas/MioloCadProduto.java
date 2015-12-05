package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.produto.Categoria;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoDAOImpl;
import br.univel.produto.Unidade;
import br.univel.tabelas.ClienteModel;
import br.univel.tabelas.ProdutoModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
/**
 * Classe com os campos do Produto para preencher
 * @author Thaís - 02/11/2015 - 16:01:49
 *
 */
public class MioloCadProduto extends JPanel {
	protected JTextField txtid;
	protected JTextField txtcodbarras;
	protected JTextField txtdescricao;
	protected JTextField txtcusto;
	protected JTextField txtmargem;
	private JComboBox cbxunidade;
	private JComboBox cbxcategoria;
	private JScrollPane scrollPane;
	private JTable table;
	private ProdutoModel model;
	private JPanel panel_codigo;
	private JPanel panel_dados;
	private JPanel panel_tabela;
	private JButton btnNovoProduto;

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{35, 166, 144, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel_codigo = new JPanel();
		GridBagConstraints gbc_panel_codigo = new GridBagConstraints();
		gbc_panel_codigo.fill = GridBagConstraints.BOTH;
		gbc_panel_codigo.insets = new Insets(20, 10, 5, 10);
		gbc_panel_codigo.gridx = 0;
		gbc_panel_codigo.gridy = 0;
		add(panel_codigo, gbc_panel_codigo);
		GridBagLayout gbl_panel_codigo = new GridBagLayout();
		gbl_panel_codigo.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_codigo.rowHeights = new int[] {20, 0};
		gbl_panel_codigo.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_codigo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_codigo.setLayout(gbl_panel_codigo);
		
		JLabel lblId = new JLabel("C\u00F3digo Produto:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblId.insets = new Insets(10, 0, 0, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_codigo.add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(10, 0, 0, 5);
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		panel_codigo.add(txtid, gbc_txtid);
		txtid.setEditable(false);
		txtid.setColumns(10);
		
		btnNovoProduto = new JButton("Novo");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNovoProduto.setIcon(new ImageIcon("src/main/resources/add.png"));
		GridBagConstraints gbc_btnNovoProduto = new GridBagConstraints();
		gbc_btnNovoProduto.insets = new Insets(10, 0, 0, 0);
		gbc_btnNovoProduto.fill = GridBagConstraints.BOTH;
		gbc_btnNovoProduto.gridx = 2;
		gbc_btnNovoProduto.gridy = 0;
		panel_codigo.add(btnNovoProduto, gbc_btnNovoProduto);
		
		panel_dados = new JPanel();
		panel_dados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_dados = new GridBagConstraints();
		gbc_panel_dados.fill = GridBagConstraints.BOTH;
		gbc_panel_dados.insets = new Insets(5, 10, 5, 10);
		gbc_panel_dados.gridx = 0;
		gbc_panel_dados.gridy = 1;
		add(panel_dados, gbc_panel_dados);
		GridBagLayout gbl_panel_dados = new GridBagLayout();
		gbl_panel_dados.columnWidths = new int[]{0, 0, 105, 0, 0};
		gbl_panel_dados.rowHeights = new int[]{14, 20, 14, 20, 14, 20, 0};
		gbl_panel_dados.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_dados.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_dados.setLayout(gbl_panel_dados);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		panel_dados.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 1;
		gbc_lblCategoria.gridy = 0;
		panel_dados.add(lblCategoria, gbc_lblCategoria);
		
		txtcodbarras = new JTextField();
		GridBagConstraints gbc_txtcodbarras = new GridBagConstraints();
		gbc_txtcodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodbarras.anchor = GridBagConstraints.NORTH;
		gbc_txtcodbarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtcodbarras.gridx = 0;
		gbc_txtcodbarras.gridy = 1;
		panel_dados.add(txtcodbarras, gbc_txtcodbarras);
		txtcodbarras.setColumns(10);
		
		cbxcategoria = new JComboBox();
		GridBagConstraints gbc_cbxcategoria = new GridBagConstraints();
		gbc_cbxcategoria.anchor = GridBagConstraints.NORTH;
		gbc_cbxcategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxcategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cbxcategoria.gridwidth = 3;
		gbc_cbxcategoria.gridx = 1;
		gbc_cbxcategoria.gridy = 1;
		panel_dados.add(cbxcategoria, gbc_cbxcategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 2;
		panel_dados.add(lblDescrio, gbc_lblDescrio);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnidade.gridx = 3;
		gbc_lblUnidade.gridy = 2;
		panel_dados.add(lblUnidade, gbc_lblUnidade);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtdescricao.gridwidth = 3;
		gbc_txtdescricao.gridx = 0;
		gbc_txtdescricao.gridy = 3;
		panel_dados.add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);
		
		cbxunidade = new JComboBox();
		GridBagConstraints gbc_cbxunidade = new GridBagConstraints();
		gbc_cbxunidade.anchor = GridBagConstraints.NORTH;
		gbc_cbxunidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxunidade.insets = new Insets(0, 0, 5, 0);
		gbc_cbxunidade.gridx = 3;
		gbc_cbxunidade.gridy = 3;
		panel_dados.add(cbxunidade, gbc_cbxunidade);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 4;
		panel_dados.add(lblCusto, gbc_lblCusto);
		
		JLabel lblMargemDeLucor = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucor = new GridBagConstraints();
		gbc_lblMargemDeLucor.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMargemDeLucor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucor.gridx = 1;
		gbc_lblMargemDeLucor.gridy = 4;
		panel_dados.add(lblMargemDeLucor, gbc_lblMargemDeLucor);
		
		txtcusto = new JTextField();
		GridBagConstraints gbc_txtcusto = new GridBagConstraints();
		gbc_txtcusto.anchor = GridBagConstraints.NORTH;
		gbc_txtcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcusto.insets = new Insets(0, 0, 0, 5);
		gbc_txtcusto.gridx = 0;
		gbc_txtcusto.gridy = 5;
		panel_dados.add(txtcusto, gbc_txtcusto);
		txtcusto.setColumns(10);
		
		txtmargem = new JTextField();
		GridBagConstraints gbc_txtmargem = new GridBagConstraints();
		gbc_txtmargem.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtmargem.insets = new Insets(0, 0, 0, 5);
		gbc_txtmargem.gridwidth = 2;
		gbc_txtmargem.gridx = 1;
		gbc_txtmargem.gridy = 5;
		panel_dados.add(txtmargem, gbc_txtmargem);
		txtmargem.setColumns(10);
		Categoria.comboboxCategoria(cbxcategoria);
		Unidade.comboboxUnidade(cbxunidade);
		
		panel_tabela = new JPanel();
		panel_tabela.setBorder(new TitledBorder(null, "Produtos Cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_tabela = new GridBagConstraints();
		gbc_panel_tabela.insets = new Insets(5, 10, 5, 10);
		gbc_panel_tabela.fill = GridBagConstraints.BOTH;
		gbc_panel_tabela.gridx = 0;
		gbc_panel_tabela.gridy = 2;
		add(panel_tabela, gbc_panel_tabela);
		panel_tabela.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_tabela.add(scrollPane, BorderLayout.CENTER);
		
		// Declarações de tabela, setando Model.
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtid.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
				txtcodbarras.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
				cbxcategoria.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2));
				txtdescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
				cbxunidade.setSelectedItem(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
				txtcusto.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 5)));
				txtmargem.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 6)));
			}
		});
		scrollPane.setViewportView(table);
		setModelTabela();

	}

	protected void limparCampos() {
		 txtid.setText(String.valueOf(buscarID()));
		 txtcodbarras.setText("");
		 txtdescricao.setText("");
		 txtcusto.setText("");
		 txtmargem.setText("");
		 cbxcategoria.setSelectedIndex(0);
		 cbxcategoria.setSelectedIndex(0);
		 txtcodbarras.requestFocus();
	}

	private int buscarID() {
		ProdutoDAOImpl dao = new ProdutoDAOImpl();
		int id = 0;
		
		try {
			id = dao.buscarID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}

	private void setModelTabela() {
		ProdutoDAOImpl dao = new ProdutoDAOImpl();
		
		List<Produto> lista;
		try {
			lista = dao.listar();
			model = new ProdutoModel(lista);
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Runnable getAcaoSalvar() throws SQLException {
		return () -> {
			ProdutoDAOImpl dao = new ProdutoDAOImpl();
			Produto p = new Produto();
			
			int id = Integer.parseInt(txtid.getText());
			
			try {
				p = dao.buscar(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (verificaValores()){
				if (p.getId() != 0){
					p = setarValores();
					
					try {
						dao.atualizar(p);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					p = setarValores();
					try {
						dao.inserir(p);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			((ProdutoModel) model).incluir(p);
		};
	}

	private Produto setarValores() {
		Produto p = new Produto();
		
		p.setId(Integer.parseInt(txtid.getText()));
		p.setCodBarras(txtcodbarras.getText());
		p.setDescricao(txtdescricao.getText());
		p.setCategoria((Categoria)cbxcategoria.getSelectedItem());
		p.setDescricao(txtdescricao.getText());
		p.setUnidade((Unidade)cbxunidade.getSelectedItem());
		p.setCusto(BigDecimal.valueOf(Double.parseDouble(txtcusto.getText())));
		p.setMargemLucro((BigDecimal.valueOf(Double.parseDouble(txtmargem.getText()))));
		
		return p;
	}

	private boolean verificaValores() {
		
		if (txtdescricao.getText().isEmpty() || txtcodbarras.getText().isEmpty()
				|| txtdescricao.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return false;
		}
		
		try{
			BigDecimal custo = new BigDecimal(txtcusto.getText());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Custo inválido! Digite um valor numérico.");
			return false;
		}
		
		try{
			BigDecimal margem = new BigDecimal(txtmargem.getText());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Margem de lucro inválida! Digite um valor numérico.");
			return false;
		}
		
		
		return true;
		
	}

	public Runnable getAcaoExcluir() throws NumberFormatException, SQLException {
		return () -> {
			ProdutoDAOImpl dao = new ProdutoDAOImpl();
			
			Produto p = new Produto();
			
			try {
				p = dao.buscar(Integer.parseInt(txtid.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				dao.excluir(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}

}
