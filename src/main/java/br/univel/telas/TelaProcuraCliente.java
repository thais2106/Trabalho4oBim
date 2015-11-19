package br.univel.telas;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cliente.ClienteDAOImpl;
import br.univel.cliente.Cliente;
import br.univel.tabelas.ClienteModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaProcuraCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtpesquisa;
	private JTable tabClientes;
	MioloCadVenda mcv = MioloCadVenda.getInstance();
	private ClienteModel clienteModel;

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
	public TelaProcuraCliente() {
		setTitle("Procura de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(10, 11, 132, 14);
		contentPane.add(lblPesquisar);
		
		txtpesquisa = new JTextField();
		txtpesquisa.setBounds(10, 28, 439, 20);
		contentPane.add(txtpesquisa);
		txtpesquisa.setColumns(10);
		
		JButton btnProcurar = new JButton("OK");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarCliente();
			}
		});
		btnProcurar.setBounds(459, 27, 91, 23);
		contentPane.add(btnProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 540, 259);
		contentPane.add(scrollPane);
		
		tabClientes = new JTable();
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					mcv.txtidcliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0)));
					mcv.txtnomecliente.setText(String.valueOf(tabClientes.getValueAt(tabClientes.getSelectedRow(), 1)));
				}
			}
		});
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
}
