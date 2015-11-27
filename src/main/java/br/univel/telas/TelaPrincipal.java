package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import br.univel.relatorio.TelaRelatorio;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
				abrirTelaRelatorioCliente();
			}
		});
		mnRelatrios.add(mntmClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
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
	
	protected void abrirTelaRelatorioCliente(){
		TelaRelatorio trc = new TelaRelatorio();
		trc.setCloseAction(e -> tabbedPane.remove(trc));
		tabbedPane.addTab("Cadastro de Cliente", trc);
	}

}
