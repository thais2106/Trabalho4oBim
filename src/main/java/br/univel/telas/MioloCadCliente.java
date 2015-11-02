package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.cadastro.cliente.Cliente;
import br.univel.cadastro.cliente.ClienteDAOH2Imp;
import br.univel.cadastro.cliente.Genero;
import br.univel.cadastro.cliente.UF;
/**
 * Tela "miolo" com os campos do cadastro de cliente
 * @author tcrivelatti - 28/10/2015 - 19:04
 *
 */

public class MioloCadCliente extends JPanel {
	protected JTextField txtid;
	protected JTextField txtnome;
	protected JTextField txtendereco;
	protected JTextField txtcidade;
	protected JTextField txtemail;
	protected JTextField txttelefone;
	private JComboBox cbxuf;
	private JComboBox cbxgenero;

	/**
	 * Create the panel.
	 */
	public MioloCadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 6;
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 1;
		gbc_txtnome.gridy = 1;
		add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 2;
		add(lblEndereo, gbc_lblEndereo);
		
		txtendereco = new JTextField();
		GridBagConstraints gbc_txtendereco = new GridBagConstraints();
		gbc_txtendereco.gridwidth = 6;
		gbc_txtendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtendereco.gridx = 1;
		gbc_txtendereco.gridy = 2;
		add(txtendereco, gbc_txtendereco);
		txtendereco.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.gridwidth = 3;
		gbc_txtcidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcidade.gridx = 1;
		gbc_txtcidade.gridy = 3;
		add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 4;
		gbc_lblEstado.gridy = 3;
		add(lblEstado, gbc_lblEstado);
		
		cbxuf = new JComboBox(UF.values());
		GridBagConstraints gbc_cbxuf = new GridBagConstraints();
		gbc_cbxuf.insets = new Insets(0, 0, 5, 0);
		gbc_cbxuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxuf.gridx = 5;
		gbc_cbxuf.gridy = 3;
		add(cbxuf, gbc_cbxuf);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.gridwidth = 3;
		gbc_txtemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.gridx = 1;
		gbc_txtemail.gridy = 4;
		add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 4;
		gbc_lblTelefone.gridy = 4;
		add(lblTelefone, gbc_lblTelefone);
		
		txttelefone = new JTextField();
		GridBagConstraints gbc_txttelfone = new GridBagConstraints();
		gbc_txttelfone.insets = new Insets(0, 0, 5, 5);
		gbc_txttelfone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttelfone.gridx = 5;
		gbc_txttelfone.gridy = 4;
		add(txttelefone, gbc_txttelfone);
		txttelefone.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.EAST;
		gbc_lblGnero.insets = new Insets(0, 0, 0, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 5;
		add(lblGnero, gbc_lblGnero);
		
		//Adicionado valores da Enum Genero no JComboBox
		cbxgenero = new JComboBox(Genero.values());
		GridBagConstraints gbc_cbxgenero = new GridBagConstraints();
		gbc_cbxgenero.insets = new Insets(0, 0, 0, 5);
		gbc_cbxgenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxgenero.gridx = 1;
		gbc_cbxgenero.gridy = 5;
		add(cbxgenero, gbc_cbxgenero);
		
	}

	public Runnable getAcaoSalvar() throws SQLException {
		return () -> {
			ClienteDAOH2Imp dao = new ClienteDAOH2Imp();
			Cliente c = new Cliente();
			
			c.setId(Integer.parseInt(txtid.getText()));
			c.setNome(txtnome.getText());
			c.setTelefone(txttelefone.getText());
			c.setEndereco(txtendereco.getText());
			c.setCidade(txtcidade.getText());
			c.setUf((UF)cbxuf.getSelectedItem());
			c.setEmail(txtemail.getText());
			c.setGenero((Genero)cbxgenero.getSelectedItem());
			
			try {
				dao.inserir(c);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Salvando");
		};	
	}

}
