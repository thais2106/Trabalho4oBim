package br.univel.telas;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.relatorio.MioloRelatorioVenda;
import br.univel.tabelas.ClienteModel;

public class TelaProcuraCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtpesquisa;
	private JTable tabClientes;
	private ClienteModel clienteModel;
	private static TelaProcuraCliente instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcuraCliente frame = new TelaProcuraCliente();
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
	public synchronized static TelaProcuraCliente getInstance() {
		if (instance == null) {
			instance = new TelaProcuraCliente();
		}
		return instance;
	}
	
	private TelaProcuraCliente() {
		setTitle("Sistema de Vendas - Procura de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{439, 91, 0};
		gbl_contentPane.rowHeights = new int[]{14, 23, 259, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		GridBagConstraints gbc_lblPesquisar = new GridBagConstraints();
		gbc_lblPesquisar.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesquisar.gridx = 0;
		gbc_lblPesquisar.gridy = 0;
		contentPane.add(lblPesquisar, gbc_lblPesquisar);
		
		txtpesquisa = new JTextField();
		GridBagConstraints gbc_txtpesquisa = new GridBagConstraints();
		gbc_txtpesquisa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpesquisa.insets = new Insets(0, 0, 5, 5);
		gbc_txtpesquisa.gridx = 0;
		gbc_txtpesquisa.gridy = 1;
		contentPane.add(txtpesquisa, gbc_txtpesquisa);
		txtpesquisa.setColumns(10);
		
		JButton btnProcurar = new JButton("OK");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarCliente();
			}
		});
		GridBagConstraints gbc_btnProcurar = new GridBagConstraints();
		gbc_btnProcurar.anchor = GridBagConstraints.NORTH;
		gbc_btnProcurar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProcurar.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcurar.gridx = 1;
		gbc_btnProcurar.gridy = 1;
		contentPane.add(btnProcurar, gbc_btnProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tabClientes = new JTable();
		scrollPane.setViewportView(tabClientes);
		
		setModelTabela();
	}

	protected void pesquisarCliente() {
		ClienteDAOImpl clientedao = new ClienteDAOImpl();
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			clientes = clientedao.listarNome(txtpesquisa.getText());
		} catch (SQLException e) {
			System.out.println("Pesquisa de nome de cliente falhou!");
			e.printStackTrace();
		}
		
		if (txtpesquisa.getText().isEmpty())
			setModelTabela();
		
		if (clientes.isEmpty())
			JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado!");
		else {
			ClienteModel clienteModel = new ClienteModel(clientes);
			tabClientes.setModel(clienteModel);
		}
		
	}

	private void setModelTabela() {
		ClienteDAOImpl clientedao = new ClienteDAOImpl();
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			clientes = clientedao.listar();
		} catch (SQLException e) {
			System.out.println("Listagem de clientes falhou!");
			e.printStackTrace();
		}
		
		clienteModel = new ClienteModel(clientes);
		tabClientes.setModel(clienteModel);
	}
	
	public void selectClienteTelaVenda(){
		MioloCadVenda mcv = MioloCadVenda.getInstance();
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					mcv.txtidcliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0)));
					mcv.txtnomecliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 1)));
				}
			}
		});
	}

	public void selectClienteRelatorioVenda() {
		MioloRelatorioVenda mrv = MioloRelatorioVenda.getRelatorioVenda();
		
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					mrv.txtcliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 1)));
				}
			}
		});
	}
	
	public void selectClienteCadUsuario(){
		MioloCadUsuario mcu = MioloCadUsuario.getInstance();
		
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					mcu.txtIdCliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0)));
					mcu.txtNomeCliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 1)));
				}
			}
		});
	}
	
	public void selectClienteSenha(){
		TelaNovaSenha tns = TelaNovaSenha.getInstance();
		
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					tns.txtIdCliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0)));
					tns.txtNomeCliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 1)));
				}
			}
		});
	}
}
