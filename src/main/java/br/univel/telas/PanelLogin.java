package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
/**
 * Tela de Login
 * @author Thaís - 05/12/2015 - 12:56:51
 *
 */
public class PanelLogin extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField SenhaField;
	private JButton btnEntrar;
	private Runnable acaoLogar;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.WEST;
		gbc_lblUsurio.insets = new Insets(20, 20, 0, 0);
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 0;
		add(lblUsurio, gbc_lblUsurio);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 20, 0, 20);
		gbc_txtUsuario.gridx = 0;
		gbc_txtUsuario.gridy = 1;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(20, 20, 5, 20);
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		add(lblSenha, gbc_lblSenha);
		
		SenhaField = new JPasswordField();
		GridBagConstraints gbc_SenhaField = new GridBagConstraints();
		gbc_SenhaField.insets = new Insets(0, 20, 0, 20);
		gbc_SenhaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SenhaField.gridx = 0;
		gbc_SenhaField.gridy = 3;
		add(SenhaField, gbc_SenhaField);
		
		btnEntrar = new JButton("Entrar");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(20, 0, 20, 20);
		gbc_btnEntrar.anchor = GridBagConstraints.EAST;
		gbc_btnEntrar.gridx = 0;
		gbc_btnEntrar.gridy = 4;
		add(btnEntrar, gbc_btnEntrar);
		
		configuraListeners();

	}
	
	public PanelLogin(Runnable acaoLogar){
		this();
		
		this.acaoLogar = acaoLogar;
		
		btnEntrar.addActionListener(e -> {
			logar();
		});
	}

	private void configuraListeners() {
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
					txtUsuario.transferFocus();
			}
		});
		
		SenhaField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
					logar();
			}
		});
		
	}

	private void logar() {
		if (txtUsuario.getText().trim().equals("1") && new String(SenhaField.getPassword()).equals("1")){
			acaoLogar.run();
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
		}
	}
	
	

}
