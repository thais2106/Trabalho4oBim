package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cadastros.Item;
import br.univel.cadastros.Venda;
import br.univel.cadastros.VendaDAOImpl;
import br.univel.tabelas.ItemModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MioloCadVenda extends JPanel {
	private static MioloCadVenda instance;
	protected JTextField txtidvenda;
	protected JTextField txtpreco;
	protected JTextField txtquantidade;
	protected JTextField txtdescricao;
	protected JTextField txtidproduto;
	protected JTable tabitens;
	protected JTextField txtpagamento;
	protected JTextField txtvaltotal;
	protected JTextField txttroco;
	protected ItemModel model;
	private List<Item> itens;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	
	public synchronized static MioloCadVenda getInstance() {  
        if(instance == null ) {  
          instance = new MioloCadVenda();  
        }  
        return instance;  
      }  
	
	private MioloCadVenda() {
		setLayout(null);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setBounds(0, 0, 153, 14);
		add(lblVenda);
		
		txtidvenda = new JTextField();
		txtidvenda.setBounds(0, 19, 153, 20);
		txtidvenda.setEditable(false);
		add(txtidvenda);
		txtidvenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(0, 44, 77, 14);
		add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(0, 64, 77, 20);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 90, 449, 232);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo produto");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		panel.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.WEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 0;
		panel.add(lblDescrio, gbc_lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.WEST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 7;
		gbc_lblQuantidade.gridy = 0;
		panel.add(lblQuantidade, gbc_lblQuantidade);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o unit\u00E1rio");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.gridwidth = 2;
		gbc_lblPreo.anchor = GridBagConstraints.WEST;
		gbc_lblPreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreo.gridx = 8;
		gbc_lblPreo.gridy = 0;
		panel.add(lblPreo, gbc_lblPreo);
		
		txtidproduto = new JTextField();
		txtidproduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_INSERT){
					TelaProcuraProduto tpp = new TelaProcuraProduto();
					tpp.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_txtidproduto = new GridBagConstraints();
		gbc_txtidproduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtidproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidproduto.gridx = 0;
		gbc_txtidproduto.gridy = 1;
		panel.add(txtidproduto, gbc_txtidproduto);
		txtidproduto.setColumns(10);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.gridwidth = 6;
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 1;
		gbc_txtdescricao.gridy = 1;
		panel.add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);
		
		txtquantidade = new JTextField();
		GridBagConstraints gbc_txtquantidade = new GridBagConstraints();
		gbc_txtquantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtquantidade.gridx = 7;
		gbc_txtquantidade.gridy = 1;
		panel.add(txtquantidade, gbc_txtquantidade);
		txtquantidade.setColumns(10);
		
		txtpreco = new JTextField();
		GridBagConstraints gbc_txtpreco = new GridBagConstraints();
		gbc_txtpreco.gridwidth = 2;
		gbc_txtpreco.insets = new Insets(0, 0, 5, 5);
		gbc_txtpreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpreco.gridx = 8;
		gbc_txtpreco.gridy = 1;
		panel.add(txtpreco, gbc_txtpreco);
		txtpreco.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarItem();
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 10;
		gbc_btnOk.gridy = 1;
		panel.add(btnOk, gbc_btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		tabitens = new JTable();
		tabitens.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_DELETE){
					model.excluirItem(tabitens.getSelectedRow());
				}
			}
		});
		scrollPane.setViewportView(tabitens);
		
		JLabel lblTotal = new JLabel("Valor Total");
		lblTotal.setBounds(0, 327, 51, 14);
		add(lblTotal);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setBounds(158, 327, 54, 14);
		add(lblPagamento);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setBounds(317, 327, 27, 14);
		add(lblTroco);
		
		txtvaltotal = new JTextField();
		txtvaltotal.setBounds(0, 346, 153, 20);
		add(txtvaltotal);
		txtvaltotal.setColumns(10);
		
		txtpagamento = new JTextField();
		txtpagamento.setBounds(158, 346, 124, 20);
		add(txtpagamento);
		txtpagamento.setColumns(10);
		
		txttroco = new JTextField();
		txttroco.setBounds(317, 346, 132, 20);
		txttroco.setEditable(false);
		add(txttroco);
		txttroco.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 64, 353, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		setModelTabela();

	}

	protected void adicionarItem() {
		itens = new ArrayList<Item>();
		Item i = new Item();
		
		i.setIdproduto(Integer.parseInt(txtidproduto.getText()));
		i.setDescricao(txtdescricao.getText());
		i.setQuantidade(Integer.parseInt(txtquantidade.getText()));
		
		//int qtd = Integer.parseInt(txtquantidade.getText());
		
		i.setPrecounitario(BigDecimal.valueOf(Double.parseDouble(txtpreco.getText())));

		model.incluirItem(i);
		
	}

	private void setModelTabela() {
		model = new ItemModel();
		tabitens.setModel(model);
		
	}

	public Runnable getAcaoSalvar() {
		return () -> {
			VendaDAOImpl dao = new VendaDAOImpl();
			Venda v = new Venda();
			
			
			
					
			
		};
	}

	public Runnable getAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setarValores(){
		Venda v = new Venda();
		
		
	}
	
}

