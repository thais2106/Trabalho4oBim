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
		contentPane.setLayout(null);
		
		JLabel lblCdigoDeBarras = new JLabel("Pesquisar");
		lblCdigoDeBarras.setBounds(5, 5, 82, 14);
		contentPane.add(lblCdigoDeBarras);
		
		txtpesquisa = new JTextField();
		txtpesquisa.setBounds(5, 25, 337, 20);
		contentPane.add(txtpesquisa);
		txtpesquisa.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnOk.setBounds(550, 24, 82, 23);
		contentPane.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 52, 627, 310);
		contentPane.add(scrollPane);
		
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
		
		radioCodBarras = new JRadioButton("C\u00F3digo de barras");
		buttonGroup.add(radioCodBarras);
		radioCodBarras.setBounds(348, 24, 109, 23);
		contentPane.add(radioCodBarras);
		
		radioDesc = new JRadioButton("Descri\u00E7\u00E3o");
		buttonGroup.add(radioDesc);
		radioDesc.setBounds(459, 24, 71, 23);
		contentPane.add(radioDesc);
		setModelTabela();

	}

	public void adicionarItem() {
		
		System.out.println("Adicionar item");
		
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
