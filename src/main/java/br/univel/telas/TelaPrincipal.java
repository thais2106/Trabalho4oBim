package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import br.univel.relatorio.TelaRelatorioCliente;
import br.univel.relatorio.TelaRelatorioProduto;
import br.univel.relatorio.TelaRelatorioVenda;
import java.awt.Frame;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;

/**
 * Tela Principal da aplicação com o menu de cadastros
 * @author tcrivelatti - 28/10/2015
 *
 */
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmCliente;
	private JTabbedPane tabbedPane;
	private JMenuItem mntmProduto;
	private JMenu mnRelatrios;
	private JMenu mnVenda;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProdutos;
	private JMenuItem mntmVendas;
	private JPanel panel_status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Sistema de Vendas");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 491);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaCliente();
			}
		});
		mnCadastro.add(mntmCliente);
		
		mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaProduto();
			}
		});
		mnCadastro.add(mntmProduto);
		
		mnVenda = new JMenu("Venda");
		mnVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				abrirTelaVenda();
			}
		});
		menuBar.add(mnVenda);
		
		mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaRelatorioCliente();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmClientes);
		
		mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaRelatorioProduto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmProdutos);
		
		mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaRelatorioVendas();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_status = new JPanel();
		panel_status.setForeground(Color.GRAY);
		panel_status.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		contentPane.add(panel_status, BorderLayout.SOUTH);
	}

	protected void abrirTelaVenda() {
		TelaCadVenda tcv = new TelaCadVenda();
		tcv.setCloseAction(e -> tabbedPane.remove(tcv));
		tabbedPane.addTab("Tela de Venda", tcv);
		
	}

	protected void abrirTelaProduto() {
		//Instancia uma nova TelaCadProduto
		TelaCadProduto tcp = new TelaCadProduto();
		
		//Configura a ação do botão fechar para remover a aba de cadastro de produto
		tcp.setCloseAction(e -> tabbedPane.remove(tcp));
		
		//Insere a aba de cadastro de produto
		tabbedPane.addTab("Cadastro de Produto", tcp);
		
	}

	protected void abrirTelaCliente() {
		TelaCadCliente tcc = new TelaCadCliente();
		tcc.setCloseAction(e -> tabbedPane.remove(tcc));
		tabbedPane.addTab("Cadastro de Cliente", tcc);
	}
	
	protected void abrirTelaRelatorioCliente() throws SQLException{
		TelaRelatorioCliente trc = new TelaRelatorioCliente();
		trc.setCloseAction(e -> tabbedPane.remove(trc));
		tabbedPane.addTab("Relatório de Clientes", trc);
	}
	
	protected void abrirTelaRelatorioProduto() throws SQLException {
		TelaRelatorioProduto trp = new TelaRelatorioProduto();
		trp.setCloseAction(e -> tabbedPane.remove(trp));
		tabbedPane.addTab("Relatório de Produtos", trp);
	}
	
	protected void abrirTelaRelatorioVendas() throws SQLException {
		TelaRelatorioVenda trv = new TelaRelatorioVenda();
		trv.setCloseAction(e -> tabbedPane.remove(trv));
		tabbedPane.addTab("Relatório de Vendas", trv);
	}

}
