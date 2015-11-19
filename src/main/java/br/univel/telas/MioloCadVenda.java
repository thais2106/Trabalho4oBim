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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{77, 66, 124, 35, 132, 0};
		gridBagLayout.rowHeights = new int[]{14, 20, 14, 20, 232, 14, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblVenda = new JLabel("Venda");
		GridBagConstraints gbc_lblVenda = new GridBagConstraints();
		gbc_lblVenda.anchor = GridBagConstraints.NORTH;
		gbc_lblVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenda.gridwidth = 2;
		gbc_lblVenda.gridx = 0;
		gbc_lblVenda.gridy = 0;
		add(lblVenda, gbc_lblVenda);
		
		txtidvenda = new JTextField();
		txtidvenda.setEditable(false);
		GridBagConstraints gbc_txtidvenda = new GridBagConstraints();
		gbc_txtidvenda.anchor = GridBagConstraints.NORTH;
		gbc_txtidvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidvenda.insets = new Insets(0, 0, 5, 5);
		gbc_txtidvenda.gridwidth = 2;
		gbc_txtidvenda.gridx = 0;
		gbc_txtidvenda.gridy = 1;
		add(txtidvenda, gbc_txtidvenda);
		txtidvenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.NORTH;
		gbc_lblCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
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
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 5;
		add(lblTotal, gbc_lblTotal);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		GridBagConstraints gbc_lblPagamento = new GridBagConstraints();
		gbc_lblPagamento.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagamento.gridx = 2;
		gbc_lblPagamento.gridy = 5;
		add(lblPagamento, gbc_lblPagamento);
		
		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 0);
		gbc_lblTroco.gridx = 4;
		gbc_lblTroco.gridy = 5;
		add(lblTroco, gbc_lblTroco);
		
		txtvaltotal = new JTextField();
		GridBagConstraints gbc_txtvaltotal = new GridBagConstraints();
		gbc_txtvaltotal.anchor = GridBagConstraints.NORTH;
		gbc_txtvaltotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvaltotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtvaltotal.gridwidth = 2;
		gbc_txtvaltotal.gridx = 0;
		gbc_txtvaltotal.gridy = 6;
		add(txtvaltotal, gbc_txtvaltotal);
		txtvaltotal.setColumns(10);
		
		txtpagamento = new JTextField();
		GridBagConstraints gbc_txtpagamento = new GridBagConstraints();
		gbc_txtpagamento.anchor = GridBagConstraints.NORTH;
		gbc_txtpagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpagamento.insets = new Insets(0, 0, 0, 5);
		gbc_txtpagamento.gridx = 2;
		gbc_txtpagamento.gridy = 6;
		add(txtpagamento, gbc_txtpagamento);
		txtpagamento.setColumns(10);
		
		txttroco = new JTextField();
		txttroco.setEditable(false);
		GridBagConstraints gbc_txttroco = new GridBagConstraints();
		gbc_txttroco.anchor = GridBagConstraints.NORTH;
		gbc_txttroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttroco.gridx = 4;
		gbc_txttroco.gridy = 6;
		add(txttroco, gbc_txttroco);
		txttroco.setColumns(10);
		
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

