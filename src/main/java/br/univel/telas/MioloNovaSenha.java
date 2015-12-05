package br.univel.telas;

import java.awt.BorderLayout;
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

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.tabelas.UsuarioModel;
import br.univel.usuario.Usuario;
import br.univel.usuario.UsuarioDAOImpl;
import br.univel.utilitarios.PasswordCellRenderer;
import br.univel.utilitarios.StatusBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MioloNovaSenha extends JPanel {
	private JTextField txtPesquisar;
	private JTable tabUsuarios;
	JTextField txtIdCliente;
	JTextField txtNomeCliente;
	private JPasswordField novaSenha;
	private JPasswordField novaSenha2;
	private UsuarioModel model;
	private PasswordCellRenderer renderer;
	private StatusBar statusBar = new StatusBar();
	private JPasswordField senhaAtual;

	/**
	 * Create the panel.
	 */

	public MioloNovaSenha() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0 };
		gridBagLayout.rowHeights = new int[] { 106, 190, 0, 33, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar nova senha",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel.add(lblCliente, gbc_lblCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				statusBar.setMessage("Digite o código do cliente e pressione ENTER "
						+ "ou selecione um cliente na tabela.");
			}
		});
		txtIdCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
				selecionarCliente();
			}
		});
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdCliente.gridx = 0;
		gbc_txtIdCliente.gridy = 1;
		panel.add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.gridwidth = 3;
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeCliente.gridx = 1;
		gbc_txtNomeCliente.gridy = 1;
		panel.add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblNewLabel = new JLabel("Digite  a senha atual");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Digite a nova senha");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nova senha novamente");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		senhaAtual = new JPasswordField();
		GridBagConstraints gbc_senhaAtual = new GridBagConstraints();
		gbc_senhaAtual.insets = new Insets(0, 0, 0, 5);
		gbc_senhaAtual.fill = GridBagConstraints.HORIZONTAL;
		gbc_senhaAtual.gridx = 0;
		gbc_senhaAtual.gridy = 3;
		panel.add(senhaAtual, gbc_senhaAtual);

		novaSenha = new JPasswordField();
		GridBagConstraints gbc_novaSenha = new GridBagConstraints();
		gbc_novaSenha.insets = new Insets(0, 0, 0, 5);
		gbc_novaSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_novaSenha.gridx = 1;
		gbc_novaSenha.gridy = 3;
		panel.add(novaSenha, gbc_novaSenha);

		novaSenha2 = new JPasswordField();
		GridBagConstraints gbc_novaSenha2 = new GridBagConstraints();
		gbc_novaSenha2.fill = GridBagConstraints.HORIZONTAL;
		gbc_novaSenha2.insets = new Insets(0, 0, 0, 5);
		gbc_novaSenha2.gridx = 2;
		gbc_novaSenha2.gridy = 3;
		panel.add(novaSenha2, gbc_novaSenha2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pesquisar",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 271, 66, 0 };
		gbl_panel_1.rowHeights = new int[] { 23, 139, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		GridBagConstraints gbc_txtPesquisar = new GridBagConstraints();
		gbc_txtPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesquisar.insets = new Insets(0, 5, 5, 5);
		gbc_txtPesquisar.gridx = 0;
		gbc_txtPesquisar.gridy = 0;
		panel_1.add(txtPesquisar, gbc_txtPesquisar);

		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		panel_1.add(btnOk, gbc_btnOk);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		renderer = new PasswordCellRenderer();
		tabUsuarios = new JTable(model) {
			public TableCellRenderer getCellRenderer(int row, int column) {
				if (column == 2)
					return renderer;
				return super.getCellRenderer(row, column);
			}
		};
		tabUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdCliente.setText(String.valueOf(tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0)));
				
				selecionarCliente();
			}
		});
		scrollPane.setViewportView(tabUsuarios);

		JPanel panel_status = new JPanel();
		panel_status.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_status = new GridBagConstraints();
		gbc_panel_status.anchor = GridBagConstraints.SOUTH;
		gbc_panel_status.fill = GridBagConstraints.BOTH;
		gbc_panel_status.gridx = 0;
		gbc_panel_status.gridy = 3;
		add(panel_status, gbc_panel_status);
		panel_status.setLayout(new BorderLayout(0, 0));
		panel_status.add(statusBar);
		statusBar.setMessage("Digite o código ou utilize a tabela para selecionar o cliente.");
		
		setModelTabela();

	}

	protected void selecionarCliente() {
		int id = Integer.parseInt(txtIdCliente.getText());

		ClienteDAOImpl dao = new ClienteDAOImpl();
		Cliente c = new Cliente();
		try {
			c = dao.buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtNomeCliente.setText(c.getNome());
	}

	public Runnable getAcaoSalvar() {
		return () -> {

			if (verificarCampos() && verificarSenhaAtual() && verificarNovaSenha()){
				
				UsuarioDAOImpl dao = new UsuarioDAOImpl();
				Usuario u = setarValores();

				dao.atualizar(u);

				JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!");
			}
		};
	}

	private boolean verificarCampos() {
		
		if (txtIdCliente.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Selecione um cliente!");
			return false;
		}
		
		try {
			int id = Integer.parseInt(txtIdCliente.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informe um código válido!");
			return false;
		}
		
		if (senhaAtual.getPassword().length==0){
			JOptionPane.showMessageDialog(null, "Informe a senha atual!");
			return false;
		}
		if (novaSenha.getPassword().length==0){
			JOptionPane.showMessageDialog(null, "Informe uma nova senha!");
			return false;
		}
		if (novaSenha2.getPassword().length==0){
			JOptionPane.showMessageDialog(null, "Digite novamente a nova senha!");
			return false;
		}
		
		return true;
	}

	public Runnable setAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
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
	
	private boolean verificarNovaSenha() {
		String senha1 = new String(novaSenha.getPassword());
		String senha2 = new String(novaSenha2.getPassword());

		System.out.println("senha 1 "+senha1 );
		System.out.println("senha 2 "+senha2 );
		if (senha1.equals(senha2))
			return true;
		else
			JOptionPane.showMessageDialog(null,
					"As senhas não coincidem! \n Digite novamente.");

		return false;
	}

	private boolean verificarSenhaAtual() {
		int id =  (int) tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0);
		//String senhaAtual = new String(senhaAtual.getPassword());
		
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		Usuario u = new Usuario();
		
		try {
			u = dao.buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(u.getSenha());
		System.out.println(new String(senhaAtual.getPassword()));
		
		if (new String(senhaAtual.getPassword()).equals(u.getSenha()))
			return true;
		else{
			JOptionPane.showMessageDialog(null, "A senha atual não coincide com a senha cadastrada!");
			return false;
		}
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

}
