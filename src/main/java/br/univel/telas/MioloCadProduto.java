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

import br.univel.cadastros.Categoria;
import br.univel.cadastros.Produto;
import br.univel.cadastros.ProdutoDAOImpl;
import br.univel.cadastros.Unidade;
import br.univel.tabelas.ClienteModel;
import br.univel.tabelas.ProdutoModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 0;
		gbc_txtid.gridy = 1;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 2;
		add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.WEST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 3;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		txtcodbarras = new JTextField();
		GridBagConstraints gbc_txtcodbarras = new GridBagConstraints();
		gbc_txtcodbarras.gridwidth = 2;
		gbc_txtcodbarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtcodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodbarras.gridx = 0;
		gbc_txtcodbarras.gridy = 3;
		add(txtcodbarras, gbc_txtcodbarras);
		txtcodbarras.setColumns(10);
		
		cbxcategoria = new JComboBox(Categoria.values());
		GridBagConstraints gbc_cbxcategoria = new GridBagConstraints();
		gbc_cbxcategoria.gridwidth = 2;
		gbc_cbxcategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cbxcategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxcategoria.gridx = 3;
		gbc_cbxcategoria.gridy = 3;
		add(cbxcategoria, gbc_cbxcategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.WEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 4;
		add(lblDescrio, gbc_lblDescrio);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.gridwidth = 5;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 0;
		gbc_txtdescricao.gridy = 5;
		add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.WEST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 6;
		add(lblUnidade, gbc_lblUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.WEST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 3;
		gbc_lblCusto.gridy = 6;
		add(lblCusto, gbc_lblCusto);
		
		cbxunidade = new JComboBox(Unidade.values());
		GridBagConstraints gbc_cbxunidade = new GridBagConstraints();
		gbc_cbxunidade.gridwidth = 2;
		gbc_cbxunidade.insets = new Insets(0, 0, 5, 5);
		gbc_cbxunidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxunidade.gridx = 0;
		gbc_cbxunidade.gridy = 7;
		add(cbxunidade, gbc_cbxunidade);
		
		txtcusto = new JTextField();
		GridBagConstraints gbc_txtcusto = new GridBagConstraints();
		gbc_txtcusto.gridwidth = 2;
		gbc_txtcusto.insets = new Insets(0, 0, 5, 0);
		gbc_txtcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcusto.gridx = 3;
		gbc_txtcusto.gridy = 7;
		add(txtcusto, gbc_txtcusto);
		txtcusto.setColumns(10);
		
		JLabel lblMargemDeLucor = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucor = new GridBagConstraints();
		gbc_lblMargemDeLucor.anchor = GridBagConstraints.WEST;
		gbc_lblMargemDeLucor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucor.gridx = 0;
		gbc_lblMargemDeLucor.gridy = 8;
		add(lblMargemDeLucor, gbc_lblMargemDeLucor);
		
		txtmargem = new JTextField();
		GridBagConstraints gbc_txtmargem = new GridBagConstraints();
		gbc_txtmargem.gridwidth = 2;
		gbc_txtmargem.insets = new Insets(0, 0, 5, 5);
		gbc_txtmargem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmargem.gridx = 0;
		gbc_txtmargem.gridy = 9;
		add(txtmargem, gbc_txtmargem);
		txtmargem.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		add(scrollPane, gbc_scrollPane);
		
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
