package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.cliente.Genero;
import br.univel.cliente.UF;
import br.univel.tabelas.ClienteModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnNovo;

	/**
	 * Create the panel.
	 */

	public MioloCadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 46, 150, 62, 190, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_codigo = new JPanel();
		GridBagConstraints gbc_panel_codigo = new GridBagConstraints();
		gbc_panel_codigo.fill = GridBagConstraints.BOTH;
		gbc_panel_codigo.insets = new Insets(20, 10, 5, 10);
		gbc_panel_codigo.gridx = 0;
		gbc_panel_codigo.gridy = 0;
		add(panel_codigo, gbc_panel_codigo);
		GridBagLayout gbl_panel_codigo = new GridBagLayout();
		gbl_panel_codigo.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_codigo.rowHeights = new int[] { 30, 0 };
		gbl_panel_codigo.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_codigo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_codigo.setLayout(gbl_panel_codigo);

		JLabel lblId = new JLabel("Cliente n\u00FAmero:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblId.insets = new Insets(10, 0, 0, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_codigo.add(lblId, gbc_lblId);

		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(10, 0, 0, 5);
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		panel_codigo.add(txtid, gbc_txtid);
		txtid.setEditable(false);
		txtid.setColumns(10);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNovo.setIcon(new ImageIcon("src/main/resources/add.png"));
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNovo.insets = new Insets(10, 0, 0, 5);
		gbc_btnNovo.gridx = 2;
		gbc_btnNovo.gridy = 0;
		panel_codigo.add(btnNovo, gbc_btnNovo);

		JPanel panel_dados = new JPanel();
		panel_dados.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Dados Pessoais",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_dados = new GridBagConstraints();
		gbc_panel_dados.anchor = GridBagConstraints.NORTH;
		gbc_panel_dados.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_dados.insets = new Insets(5, 10, 5, 10);
		gbc_panel_dados.gridx = 0;
		gbc_panel_dados.gridy = 1;
		add(panel_dados, gbc_panel_dados);
		GridBagLayout gbl_panel_dados = new GridBagLayout();
		gbl_panel_dados.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_dados.rowHeights = new int[] { 14, 20, 14, 20, 14, 20, 0 };
		gbl_panel_dados.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_dados.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_dados.setLayout(gbl_panel_dados);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.fill = GridBagConstraints.BOTH;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_dados.add(lblNome, gbc_lblNome);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.fill = GridBagConstraints.BOTH;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 0);
		gbc_lblGnero.gridx = 2;
		gbc_lblGnero.gridy = 0;
		panel_dados.add(lblGnero, gbc_lblGnero);

		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 2;
		gbc_txtnome.fill = GridBagConstraints.BOTH;
		gbc_txtnome.insets = new Insets(0, 0, 5, 5);
		gbc_txtnome.gridx = 0;
		gbc_txtnome.gridy = 1;
		panel_dados.add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);

		cbxgenero = new JComboBox();
		GridBagConstraints gbc_cbxgenero = new GridBagConstraints();
		gbc_cbxgenero.fill = GridBagConstraints.BOTH;
		gbc_cbxgenero.insets = new Insets(0, 0, 5, 0);
		gbc_cbxgenero.gridx = 2;
		gbc_cbxgenero.gridy = 1;
		panel_dados.add(cbxgenero, gbc_cbxgenero);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.fill = GridBagConstraints.BOTH;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 2;
		panel_dados.add(lblEndereo, gbc_lblEndereo);

		txtendereco = new JTextField();
		GridBagConstraints gbc_txtendereco = new GridBagConstraints();
		gbc_txtendereco.fill = GridBagConstraints.BOTH;
		gbc_txtendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtendereco.gridwidth = 3;
		gbc_txtendereco.gridx = 0;
		gbc_txtendereco.gridy = 3;
		panel_dados.add(txtendereco, gbc_txtendereco);
		txtendereco.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.fill = GridBagConstraints.BOTH;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		panel_dados.add(lblCidade, gbc_lblCidade);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.fill = GridBagConstraints.BOTH;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 4;
		panel_dados.add(lblEstado, gbc_lblEstado);

		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.fill = GridBagConstraints.BOTH;
		gbc_txtcidade.insets = new Insets(0, 0, 0, 5);
		gbc_txtcidade.gridwidth = 2;
		gbc_txtcidade.gridx = 0;
		gbc_txtcidade.gridy = 5;
		panel_dados.add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);

		cbxuf = new JComboBox();
		GridBagConstraints gbc_cbxuf = new GridBagConstraints();
		gbc_cbxuf.fill = GridBagConstraints.BOTH;
		gbc_cbxuf.gridx = 2;
		gbc_cbxuf.gridy = 5;
		panel_dados.add(cbxuf, gbc_cbxuf);
		Genero.comboboxGenero(cbxgenero);
		UF.comboboxUf(cbxuf);

		JPanel panel_contato = new JPanel();
		panel_contato.setBorder(new TitledBorder(null, "Contato",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_contato = new GridBagConstraints();
		gbc_panel_contato.anchor = GridBagConstraints.NORTH;
		gbc_panel_contato.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_contato.insets = new Insets(5, 10, 5, 10);
		gbc_panel_contato.gridx = 0;
		gbc_panel_contato.gridy = 2;
		add(panel_contato, gbc_panel_contato);
		GridBagLayout gbl_panel_contato = new GridBagLayout();
		gbl_panel_contato.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_contato.rowHeights = new int[] { 14, 20, 0 };
		gbl_panel_contato.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_contato.rowWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		panel_contato.setLayout(gbl_panel_contato);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 0;
		panel_contato.add(lblEmail, gbc_lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 0;
		panel_contato.add(lblTelefone, gbc_lblTelefone);

		txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.anchor = GridBagConstraints.NORTH;
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.insets = new Insets(0, 0, 0, 5);
		gbc_txtemail.gridx = 0;
		gbc_txtemail.gridy = 1;
		panel_contato.add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);

		txttelefone = new JTextField();
		GridBagConstraints gbc_txttelefone = new GridBagConstraints();
		gbc_txttelefone.anchor = GridBagConstraints.NORTH;
		gbc_txttelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttelefone.gridx = 1;
		gbc_txttelefone.gridy = 1;
		panel_contato.add(txttelefone, gbc_txttelefone);
		txttelefone.setColumns(10);

		JPanel panel_tabela = new JPanel();
		panel_tabela.setBorder(new TitledBorder(null, "Clientes Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_tabela = new GridBagConstraints();
		gbc_panel_tabela.insets = new Insets(5, 10, 5, 10);
		gbc_panel_tabela.fill = GridBagConstraints.BOTH;
		gbc_panel_tabela.gridx = 0;
		gbc_panel_tabela.gridy = 3;
		add(panel_tabela, gbc_panel_tabela);
		panel_tabela.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_tabela.add(scrollPane, BorderLayout.CENTER);

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

	private int buscarID() {
		ClienteDAOImpl dao = new ClienteDAOImpl();
		int id = 0;

		try {
			id = dao.buscarID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
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

				// Ver se tem como mudar isso
				((ClienteModel) model).incluir(c);

				limparCampos();
			}

		};
	}

	private void limparCampos() {
		txtid.setText(String.valueOf(buscarID()));
		txtnome.setText("");
		txtcidade.setText("");
		txtemail.setText("");
		txtendereco.setText("");
		txttelefone.setText("");
		cbxgenero.setSelectedIndex(0);
		txtnome.requestFocus();
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

		if (txtnome.getText().isEmpty() || txtcidade.getText().isEmpty()
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
