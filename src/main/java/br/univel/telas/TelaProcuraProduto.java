package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.Utilities;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.produto.Produto;
import br.univel.produto.ProdutoDAOImpl;
import br.univel.tabelas.ClienteModel;
import br.univel.tabelas.ItemModel;
import br.univel.tabelas.ProdutoModel;
import br.univel.venda.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Tela de Procura de Produtos
 * @author tcrivelatti - 10/11/2015 - 20:47:58
 *
 */

public class TelaProcuraProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtpesquisa;
	private JTable tabProdutos;
	private ProdutoModel produtomodel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioCodBarras;
	private JRadioButton radioDesc;
	private List<Produto> lista;
	ProdutoDAOImpl dao = new ProdutoDAOImpl();
	MioloCadVenda mcv = MioloCadVenda.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcuraProduto frame = new TelaProcuraProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProcuraProduto() {
		setTitle("Procura de Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{337, 109, 71, 82, 0};
		gbl_contentPane.rowHeights = new int[]{14, 23, 310, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCdigoDeBarras = new JLabel("Pesquisar");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		contentPane.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		txtpesquisa = new JTextField();
		GridBagConstraints gbc_txtpesquisa = new GridBagConstraints();
		gbc_txtpesquisa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpesquisa.insets = new Insets(0, 0, 5, 5);
		gbc_txtpesquisa.gridx = 0;
		gbc_txtpesquisa.gridy = 1;
		contentPane.add(txtpesquisa, gbc_txtpesquisa);
		txtpesquisa.setColumns(10);
		
		radioCodBarras = new JRadioButton("C\u00F3digo de barras");
		buttonGroup.add(radioCodBarras);
		GridBagConstraints gbc_radioCodBarras = new GridBagConstraints();
		gbc_radioCodBarras.anchor = GridBagConstraints.NORTH;
		gbc_radioCodBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioCodBarras.insets = new Insets(0, 0, 5, 5);
		gbc_radioCodBarras.gridx = 1;
		gbc_radioCodBarras.gridy = 1;
		contentPane.add(radioCodBarras, gbc_radioCodBarras);
		
		radioDesc = new JRadioButton("Descri\u00E7\u00E3o");
		buttonGroup.add(radioDesc);
		GridBagConstraints gbc_radioDesc = new GridBagConstraints();
		gbc_radioDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_radioDesc.insets = new Insets(0, 0, 5, 5);
		gbc_radioDesc.gridx = 2;
		gbc_radioDesc.gridy = 1;
		contentPane.add(radioDesc, gbc_radioDesc);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 1;
		contentPane.add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tabProdutos = new JTable();
		tabProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2){
					adicionarItem();
				}
			}
		});
		scrollPane.setViewportView(tabProdutos);
		setModelTabela();

	}

	public void adicionarItem() {
		
		Item i = new Item();

		i.setIdproduto((int) tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 0));
		i.setDescricao(String.valueOf(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 2)));
		i.setQuantidade(1);
		
		BigDecimal preco = new BigDecimal(String.valueOf(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 5)));
		i.setPrecounitario(preco);
		
		mcv.txtidproduto.setText(String.valueOf(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 0)));
		mcv.txtdescricao.setText(String.valueOf(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 3)));
		mcv.txtquantidade.setText(String.valueOf(1));
		mcv.txtpreco.setText(String.valueOf(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 5)));
		
		//mcv.model.incluirItem(i);
		
	}

	protected void procurar() {
		lista = new ArrayList<Produto>();
		
		if (radioCodBarras.isSelected()){
			try {
				lista = dao.listarCodBarras(txtpesquisa.getText());
			} catch (SQLException e) {
				System.out.println("Erro ao pesquisar produtos pelo codigo de barras");
				e.printStackTrace();
			}
		}
		
		if (radioDesc.isSelected()){
			try {
				lista = dao.listarDescricao(txtpesquisa.getText());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (txtpesquisa.getText().isEmpty())
			setModelTabela();
		
		if (lista.isEmpty())
			JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
		else {
			produtomodel = new ProdutoModel(lista);
			tabProdutos.setModel(produtomodel);
		}
		
	}

	private void setModelTabela() {
		
		lista = new ArrayList<>();
		try {
			lista = dao.listar();
			produtomodel = new ProdutoModel(lista);
			tabProdutos.setModel(produtomodel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
