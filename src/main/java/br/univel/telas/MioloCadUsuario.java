package br.univel.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;

import br.univel.tabelas.UsuarioModel;
import br.univel.usuario.Usuario;
import br.univel.usuario.UsuarioDAOImpl;
import br.univel.utilitarios.PasswordCellRenderer;

public class MioloCadUsuario extends JPanel {
	protected JTextField txtNomeCliente;
	protected JTextField txtIdCliente;
	private JTextField txtPesquisar;
	private JTable tabUsuarios;
	private JPasswordField SenhaField;
	private static MioloCadUsuario instance;
	private UsuarioModel model;

	/**
	 * Create the panel.
	 */
	public synchronized static MioloCadUsuario getInstance(){
		if (instance==null){
			instance = new MioloCadUsuario();
		}
		
		return instance;
	}
	
	private MioloCadUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{359, 0};
		gridBagLayout.rowHeights = new int[]{137, 197, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_cadastro = new JPanel();
		panel_cadastro.setBorder(new TitledBorder(null, "Cadastrar Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_cadastro = new GridBagConstraints();
		gbc_panel_cadastro.fill = GridBagConstraints.BOTH;
		gbc_panel_cadastro.insets = new Insets(20, 10, 5, 10);
		gbc_panel_cadastro.gridx = 0;
		gbc_panel_cadastro.gridy = 0;
		add(panel_cadastro, gbc_panel_cadastro);
		GridBagLayout gbl_panel_cadastro = new GridBagLayout();
		gbl_panel_cadastro.columnWidths = new int[]{68, 190, 63, 0};
		gbl_panel_cadastro.rowHeights = new int[]{14, 23, 14, 22, 0};
		gbl_panel_cadastro.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_cadastro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_cadastro.setLayout(gbl_panel_cadastro);
		
		JLabel lblCliente = new JLabel("ID Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.NORTH;
		gbc_lblCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCliente.insets = new Insets(0, 5, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel_cadastro.add(lblCliente, gbc_lblCliente);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		GridBagConstraints gbc_lblNomeDoCliente = new GridBagConstraints();
		gbc_lblNomeDoCliente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeDoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoCliente.gridx = 1;
		gbc_lblNomeDoCliente.gridy = 0;
		panel_cadastro.add(lblNomeDoCliente, gbc_lblNomeDoCliente);
		
		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.anchor = GridBagConstraints.SOUTH;
		gbc_txtIdCliente.insets = new Insets(0, 5, 5, 5);
		gbc_txtIdCliente.gridx = 0;
		gbc_txtIdCliente.gridy = 1;
		panel_cadastro.add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtNomeCliente = new JTextField();
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.anchor = GridBagConstraints.SOUTH;
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeCliente.gridx = 1;
		gbc_txtNomeCliente.gridy = 1;
		panel_cadastro.add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JButton btnProcurar = new JButton("");
		btnProcurar.setIcon(new ImageIcon("src/main/resources/procura.png"));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcuraCliente tpc = new TelaProcuraCliente();
				tpc.setVisible(true);
				tpc.selectClienteCadUsuario();
			}
		});
		GridBagConstraints gbc_btnProcurar = new GridBagConstraints();
		gbc_btnProcurar.fill = GridBagConstraints.BOTH;
		gbc_btnProcurar.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcurar.gridx = 2;
		gbc_btnProcurar.gridy = 1;
		panel_cadastro.add(btnProcurar, gbc_btnProcurar);
		
		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenha.insets = new Insets(0, 5, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		panel_cadastro.add(lblSenha, gbc_lblSenha);
		
		SenhaField = new JPasswordField();
		GridBagConstraints gbc_SenhaField = new GridBagConstraints();
		gbc_SenhaField.insets = new Insets(0, 5, 0, 0);
		gbc_SenhaField.fill = GridBagConstraints.BOTH;
		gbc_SenhaField.gridwidth = 3;
		gbc_SenhaField.gridx = 0;
		gbc_SenhaField.gridy = 3;
		panel_cadastro.add(SenhaField, gbc_SenhaField);
		
		JPanel panel_pesquisar = new JPanel();
		panel_pesquisar.setBorder(new TitledBorder(null, "Pesquisar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_pesquisar = new GridBagConstraints();
		gbc_panel_pesquisar.insets = new Insets(10, 10, 0, 10);
		gbc_panel_pesquisar.fill = GridBagConstraints.BOTH;
		gbc_panel_pesquisar.gridx = 0;
		gbc_panel_pesquisar.gridy = 1;
		add(panel_pesquisar, gbc_panel_pesquisar);
		GridBagLayout gbl_panel_pesquisar = new GridBagLayout();
		gbl_panel_pesquisar.columnWidths = new int[]{271, 66, 0};
		gbl_panel_pesquisar.rowHeights = new int[]{23, 139, 0};
		gbl_panel_pesquisar.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_pesquisar.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_pesquisar.setLayout(gbl_panel_pesquisar);
		
		txtPesquisar = new JTextField();
		GridBagConstraints gbc_txtPesquisar = new GridBagConstraints();
		gbc_txtPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesquisar.insets = new Insets(0, 5, 5, 5);
		gbc_txtPesquisar.gridx = 0;
		gbc_txtPesquisar.gridy = 0;
		panel_pesquisar.add(txtPesquisar, gbc_txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		panel_pesquisar.add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 5, 0, 5);
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

	public Runnable getAcaoSalvar() {
		return () -> {
			UsuarioDAOImpl dao = new UsuarioDAOImpl();
			Usuario u = new Usuario();
			
			if (verificarCampos())
				u = setarValores();
			
			try {
				dao.inserir(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.incluir(u);
			limparCampos();
			
		};
	}

	private void limparCampos() {
		txtIdCliente.setText("");
		txtNomeCliente.setText("");
		SenhaField.setText("");
		
	}

	private Usuario setarValores() {
		verificarCampos();
		
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		int id = 0;
		
		try {
			id = dao.buscarID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int idCliente = Integer.parseInt(txtIdCliente.getText());
		String senha = new String(SenhaField.getPassword());
				
		Usuario u = new Usuario();
		u.setId(id);
		u.setClienteId(idCliente);
		u.setSenha(senha);
		
		return u;
	}

	private boolean verificarCampos() {
		if (txtIdCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um código para o cliente!");
			return false;
		}
		
		try {
			int id = Integer.parseInt(txtIdCliente.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um código válido!");
		}
		
		if (SenhaField.getPassword().length==0){
			JOptionPane.showMessageDialog(null, "Insira uma senha!");
			return false;
		}
		
		return true;
	}

	public Runnable setAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}
}
