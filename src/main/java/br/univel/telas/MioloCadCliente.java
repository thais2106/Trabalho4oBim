package br.univel.telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.cliente.Genero;
import br.univel.cliente.UF;
import br.univel.tabelas.ClienteModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Tela "miolo" com os campos do cadastro de cliente
 * 
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
	private JTable table;
	private TableModel model;

	/**
	 * Create the panel.
	 */
	public MioloCadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 252, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);

		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridx = 0;
		gbc_txtid.gridy = 1;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 4;
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 0;
		gbc_txtnome.gridy = 3;
		add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.WEST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 4;
		add(lblEndereo, gbc_lblEndereo);

		txtendereco = new JTextField();
		GridBagConstraints gbc_txtendereco = new GridBagConstraints();
		gbc_txtendereco.gridwidth = 4;
		gbc_txtendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtendereco.gridx = 0;
		gbc_txtendereco.gridy = 5;
		add(txtendereco, gbc_txtendereco);
		txtendereco.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 6;
		add(lblCidade, gbc_lblCidade);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 6;
		add(lblEstado, gbc_lblEstado);

		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.gridwidth = 2;
		gbc_txtcidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcidade.gridx = 0;
		gbc_txtcidade.gridy = 7;
		add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);

		cbxuf = new JComboBox(UF.values());
		GridBagConstraints gbc_cbxuf = new GridBagConstraints();
		gbc_cbxuf.gridwidth = 2;
		gbc_cbxuf.insets = new Insets(0, 0, 5, 0);
		gbc_cbxuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxuf.gridx = 2;
		gbc_cbxuf.gridy = 7;
		add(cbxuf, gbc_cbxuf);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		add(lblEmail, gbc_lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.WEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 8;
		add(lblTelefone, gbc_lblTelefone);

		txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.gridx = 0;
		gbc_txtemail.gridy = 9;
		add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);

		txttelefone = new JTextField();
		GridBagConstraints gbc_txttelfone = new GridBagConstraints();
		gbc_txttelfone.gridwidth = 3;
		gbc_txttelfone.insets = new Insets(0, 0, 5, 0);
		gbc_txttelfone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttelfone.gridx = 1;
		gbc_txttelfone.gridy = 9;
		add(txttelefone, gbc_txttelfone);
		txttelefone.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.WEST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 10;
		add(lblGnero, gbc_lblGnero);

		// Adicionado valores da Enum Genero no JComboBox
		cbxgenero = new JComboBox(Genero.values());
		GridBagConstraints gbc_cbxgenero = new GridBagConstraints();
		gbc_cbxgenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbxgenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxgenero.gridx = 0;
		gbc_cbxgenero.gridy = 11;
		add(cbxgenero, gbc_cbxgenero);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 12;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtid.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 0)));
				txtnome.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 1)));
				txtendereco.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 2)));
				txtcidade.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 3)));
				cbxuf.setSelectedItem(table.getValueAt(table.getSelectedRow(),
						4));
				txtemail.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 5)));
				txttelefone.setText(String.valueOf(table.getValueAt(
						table.getSelectedRow(), 6)));
				cbxgenero.setSelectedItem(table.getValueAt(
						table.getSelectedRow(), 7));
			}
		});
		scrollPane.setViewportView(table);
		setModelTabela();

	}

	private void setModelTabela() {
		ClienteDAOImpl dao = new ClienteDAOImpl();

		List<Cliente> lista;
		try {
			lista = dao.listar();
			model = new ClienteModel(lista);
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Runnable getAcaoSalvar() throws SQLException {
		return () -> {
			ClienteDAOImpl dao = new ClienteDAOImpl();
			Cliente c = new Cliente();

			int id = Integer.parseInt(txtid.getText());

			try {
				c = dao.buscar(id);
			} catch (Exception e1) {
				System.out.println("Erro ao buscar código do cliente!");
				e1.printStackTrace();
			}

			if (verificaValores()) {
				if (c.getId() != 0) {
					c = setarValores();

					try {
						dao.atualizar(c);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					c = setarValores();

					try {
						dao.inserir(c);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				//Ver se tem como mudar isso
				((ClienteModel) model).incluir(c);

			}

		};
	}

	public Runnable getAcaoExcluir() {
		return () -> {
			ClienteDAOImpl dao = new ClienteDAOImpl();

			int opcao = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o registro?", "Aviso",
					JOptionPane.YES_NO_OPTION);

			if (opcao == 0) {
				Cliente c = new Cliente();
				c = setarValores();

				try {
					dao.excluir(c);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}

	public boolean verificaValores() {

		if (txtnome.getText().isEmpty() 
				|| txtcidade.getText().isEmpty()
				|| txtendereco.getText().isEmpty()
				|| txtemail.getText().isEmpty()
				|| txttelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return false;
		}

		return true;

	}

	public Cliente setarValores() {

		Cliente c = new Cliente();

		c.setId(Integer.parseInt(txtid.getText()));
		c.setNome(txtnome.getText());
		c.setTelefone(txttelefone.getText());
		c.setEndereco(txtendereco.getText());
		c.setCidade(txtcidade.getText());
		c.setUf((UF) cbxuf.getSelectedItem());
		c.setEmail(txtemail.getText());
		c.setGenero((Genero) cbxgenero.getSelectedItem());

		return c;
	}

}
