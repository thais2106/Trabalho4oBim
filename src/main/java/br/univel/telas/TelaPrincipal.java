package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import br.univel.cadastro.cliente.Cliente;
import br.univel.cadastro.cliente.ClienteDAO;
import br.univel.cadastro.cliente.ClienteDAOH2Imp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Tela Principal da aplicação com o menu de cadastros
 * @author tcrivelatti - 28/10/2015
 *
 */
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmCliente;
	private JTabbedPane tabbedPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void abrirTelaCliente() {
		TelaCadastroCliente tcc = new TelaCadastroCliente();
		tcc.setCloseAction(e -> tabbedPane.remove(tcc));
		tabbedPane.addTab("Cadastro de Cliente", tcc);
	}

}
