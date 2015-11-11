package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cadastros.Produto;
import br.univel.cadastros.ProdutoDAOImpl;
import br.univel.tabelas.ProdutoModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * Tela de Procura de Produtos
 * @author tcrivelatti - 10/11/2015 - 20:47:58
 *
 */

public class TelaProcura extends JFrame {

	private JPanel contentPane;
	private JTextField txtpesquisa;
	private JTable tabProdutos;
	private ProdutoModel model;
	ProdutoDAOImpl dao = new ProdutoDAOImpl();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioCodBarras;
	private JRadioButton radioDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcura frame = new TelaProcura();
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
	public TelaProcura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDeBarras = new JLabel("Pesquisar");
		lblCdigoDeBarras.setBounds(5, 5, 82, 14);
		contentPane.add(lblCdigoDeBarras);
		
		txtpesquisa = new JTextField();
		txtpesquisa.setBounds(5, 25, 190, 20);
		contentPane.add(txtpesquisa);
		txtpesquisa.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnOk.setBounds(389, 24, 47, 23);
		contentPane.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 52, 426, 216);
		contentPane.add(scrollPane);
		
		tabProdutos = new JTable();
		scrollPane.setViewportView(tabProdutos);
		
		radioCodBarras = new JRadioButton("C\u00F3digo de barras");
		buttonGroup.add(radioCodBarras);
		radioCodBarras.setBounds(201, 24, 109, 23);
		contentPane.add(radioCodBarras);
		
		radioDesc = new JRadioButton("Descri\u00E7\u00E3o");
		buttonGroup.add(radioDesc);
		radioDesc.setBounds(312, 24, 71, 23);
		contentPane.add(radioDesc);
		setModelTabela();
		
	}

	protected void procurar() {
		List<Produto> lista = new ArrayList<Produto>();
		
		if (txtpesquisa.getText().isEmpty())
			setModelTabela();
		
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (lista.isEmpty())
			JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
		else {
			model = new ProdutoModel(lista);
			tabProdutos.setModel(model);
		}
		
	}

	private void setModelTabela() {
		
		List<Produto> lista;
		try {
			lista = dao.listar();
			model = new ProdutoModel(lista);
			tabProdutos.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
