package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;

import br.univel.tabelas.UsuarioModel;
import br.univel.usuario.Usuario;
import br.univel.usuario.UsuarioDAOImpl;
import br.univel.utilitarios.PasswordCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaNovaSenha extends JFrame {

	private JPanel contentPane;
	protected JTextField txtIdCliente;
	private JPasswordField senhaAtual;
	private JPasswordField novaSenha;
	private JPasswordField novaSenha2;
	protected JTextField txtNomeCliente;
	private JPanel panel_botao;
	private JButton btnAlterar;
	private JTextField txtPesquisar;
	private JTable tabUsuarios;
	private UsuarioModel model;
	private static TelaNovaSenha instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaSenha frame = new TelaNovaSenha();
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
	public static synchronized TelaNovaSenha getInstance() {
		if (instance==null)
			instance = new TelaNovaSenha();
		return instance;
	}
	
	private TelaNovaSenha() {
		setTitle("Sistema de Vendas - Modificar senha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{194, 190, 23, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_dados = new JPanel();
		panel_dados.setBorder(new TitledBorder(null, "Cadastrar nova senha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_dados = new GridBagConstraints();
		gbc_panel_dados.anchor = GridBagConstraints.NORTH;
		gbc_panel_dados.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_dados.insets = new Insets(0, 0, 5, 0);
		gbc_panel_dados.gridx = 0;
		gbc_panel_dados.gridy = 0;
		contentPane.add(panel_dados, gbc_panel_dados);
		GridBagLayout gbl_panel_dados = new GridBagLayout();
		gbl_panel_dados.columnWidths = new int[]{0, 0, 0, 0, 33, 0};
		gbl_panel_dados.rowHeights = new int[]{14, 20, 14, 20, 14, 20, 14, 20, 0};
		gbl_panel_dados.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_dados.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_dados.setLayout(gbl_panel_dados);
		
		JLabel label = new JLabel("Cliente");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_dados.add(label, gbc_label);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdCliente.gridx = 0;
		gbc_txtIdCliente.gridy = 1;
		panel_dados.add(txtIdCliente, gbc_txtIdCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.gridwidth = 3;
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeCliente.gridx = 1;
		gbc_txtNomeCliente.gridy = 1;
		panel_dados.add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JButton btnProcurar = new JButton("");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcuraCliente tpc = TelaProcuraCliente.getInstance();
				tpc.setVisible(true);
				tpc.selectClienteSenha();
			}
		});
		btnProcurar.setIcon(new ImageIcon("src/main/resources/procura.png"));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.fill = GridBagConstraints.VERTICAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 1;
		panel_dados.add(btnProcurar, gbc_button);
		
		JLabel label_1 = new JLabel("Senha atual");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel_dados.add(label_1, gbc_label_1);
		
		senhaAtual = new JPasswordField();
		GridBagConstraints gbc_senhaAtual = new GridBagConstraints();
		gbc_senhaAtual.gridwidth = 2;
		gbc_senhaAtual.fill = GridBagConstraints.HORIZONTAL;
		gbc_senhaAtual.anchor = GridBagConstraints.NORTH;
		gbc_senhaAtual.insets = new Insets(0, 0, 5, 5);
		gbc_senhaAtual.gridx = 0;
		gbc_senhaAtual.gridy = 3;
		panel_dados.add(senhaAtual, gbc_senhaAtual);
		
		JLabel label_2 = new JLabel("Nova senha");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		panel_dados.add(label_2, gbc_label_2);
		
		novaSenha = new JPasswordField();
		GridBagConstraints gbc_novaSenha = new GridBagConstraints();
		gbc_novaSenha.gridwidth = 2;
		gbc_novaSenha.anchor = GridBagConstraints.NORTH;
		gbc_novaSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_novaSenha.insets = new Insets(0, 0, 5, 5);
		gbc_novaSenha.gridx = 0;
		gbc_novaSenha.gridy = 5;
		panel_dados.add(novaSenha, gbc_novaSenha);
		
		JLabel label_3 = new JLabel("Nova senha novamente");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		panel_dados.add(label_3, gbc_label_3);
		
		novaSenha2 = new JPasswordField();
		GridBagConstraints gbc_novaSenha2 = new GridBagConstraints();
		gbc_novaSenha2.gridwidth = 2;
		gbc_novaSenha2.fill = GridBagConstraints.HORIZONTAL;
		gbc_novaSenha2.anchor = GridBagConstraints.NORTH;
		gbc_novaSenha2.insets = new Insets(0, 0, 0, 5);
		gbc_novaSenha2.gridx = 0;
		gbc_novaSenha2.gridy = 7;
		panel_dados.add(novaSenha2, gbc_novaSenha2);
		
		JPanel panel_pesquisar = new JPanel();
		panel_pesquisar.setBorder(new TitledBorder(null, "Pesquisar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_pesquisar = new GridBagConstraints();
		gbc_panel_pesquisar.anchor = GridBagConstraints.NORTH;
		gbc_panel_pesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_pesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_panel_pesquisar.gridx = 0;
		gbc_panel_pesquisar.gridy = 1;
		contentPane.add(panel_pesquisar, gbc_panel_pesquisar);
		GridBagLayout gbl_panel_pesquisar = new GridBagLayout();
		gbl_panel_pesquisar.columnWidths = new int[]{271, 66, 0};
		gbl_panel_pesquisar.rowHeights = new int[]{23, 139, 0, 0};
		gbl_panel_pesquisar.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_pesquisar.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_pesquisar.setLayout(gbl_panel_pesquisar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		GridBagConstraints gbc_txtPesquisar = new GridBagConstraints();
		gbc_txtPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesquisar.insets = new Insets(0, 5, 5, 5);
		gbc_txtPesquisar.gridx = 0;
		gbc_txtPesquisar.gridy = 0;
		panel_pesquisar.add(txtPesquisar, gbc_txtPesquisar);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		panel_pesquisar.add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_pesquisar.add(scrollPane, gbc_scrollPane);
		
		final PasswordCellRenderer renderer = new PasswordCellRenderer();		
		tabUsuarios = new JTable(model){
			public TableCellRenderer getCellRenderer(int row, int column){
				if (column==2) return renderer;
				return super.getCellRenderer(row, column);
			}
		};
		scrollPane.setViewportView(tabUsuarios);
		setModelTabela();
		
		tabUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2)
					carregarCampos();
			}
		});
		scrollPane.setViewportView(tabUsuarios);
		
		panel_botao = new JPanel();
		GridBagConstraints gbc_panel_botao = new GridBagConstraints();
		gbc_panel_botao.anchor = GridBagConstraints.NORTH;
		gbc_panel_botao.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_botao.gridx = 0;
		gbc_panel_botao.gridy = 2;
		contentPane.add(panel_botao, gbc_panel_botao);
		GridBagLayout gbl_panel_botao = new GridBagLayout();
		gbl_panel_botao.columnWidths = new int[]{167, 89, 0};
		gbl_panel_botao.rowHeights = new int[]{23, 0};
		gbl_panel_botao.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_botao.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_botao.setLayout(gbl_panel_botao);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
		});
		btnAlterar.setIcon(new ImageIcon("src/main/resources/salvar.png"));
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.fill = GridBagConstraints.BOTH;
		gbc_btnAlterar.gridx = 1;
		gbc_btnAlterar.gridy = 0;
		panel_botao.add(btnAlterar, gbc_btnAlterar);
	}

	protected void carregarCampos() {
		txtIdCliente.setText(String.valueOf(tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 1)));
		txtNomeCliente.setText(String.valueOf(tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 2)));
		
	}

	private void setModelTabela() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		
		try {
			model = new UsuarioModel(dao.listar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabUsuarios.setModel(model);
	}

	protected void alterarUsuario() {
		
		if (verificarSenhas()){
			UsuarioDAOImpl dao = new UsuarioDAOImpl();
			
			if (verificarSenhas()) {
				Usuario u = setarValores();
				
				dao.atualizar(u);
			}
		}
		
	}

	private Usuario setarValores() {	
		int id = (int) tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0);
		int idCliente = Integer.parseInt(txtIdCliente.getText());
		String senha = new String(novaSenha.getPassword().toString());
		
		Usuario u = new Usuario();	
		u.setId(id);
		u.setClienteId(idCliente);
		u.setSenha(senha);
		
		return u;
	}

	private boolean verificarSenhas() {
		String senha1 = new String(novaSenha.getPassword().toString());
		String senha2 = new String(novaSenha2.getPassword().toString());
		
		if (senha1.equals(senha2))
			return true;
		else
			JOptionPane.showMessageDialog(null, "As senhas não coincidem! \n Digite novamente.");
		return false;
	}
}
