package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.tabelas.ItemModel;
import br.univel.venda.Item;
import br.univel.venda.Venda;
import br.univel.venda.VendaDAOImpl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MioloCadVenda extends JPanel {
	private static MioloCadVenda instance;
	protected JTextField txtidvenda;
	protected JTextField txtidcliente;
	protected JTextField txtnomecliente;
	protected JTextField txtpreco;
	protected JTextField txtquantidade;
	protected JTextField txtdescricao;
	protected JTextField txtidproduto;
	protected JTable tabitens;
	protected JTextField txtpagamento;
	protected JTextField txtvaltotal;
	protected JTextField txttroco;
	protected ItemModel model;
	
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
		
		txtidcliente = new JTextField();
		txtidcliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_INSERT){
					TelaProcuraCliente tpc = new TelaProcuraCliente();
					tpc.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_txtidcliente = new GridBagConstraints();
		gbc_txtidcliente.anchor = GridBagConstraints.NORTH;
		gbc_txtidcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidcliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtidcliente.gridx = 0;
		gbc_txtidcliente.gridy = 3;
		add(txtidcliente, gbc_txtidcliente);
		txtidcliente.setColumns(10);
		
		txtnomecliente = new JTextField();
		GridBagConstraints gbc_txtnomecliente = new GridBagConstraints();
		gbc_txtnomecliente.anchor = GridBagConstraints.NORTH;
		gbc_txtnomecliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnomecliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtnomecliente.gridwidth = 4;
		gbc_txtnomecliente.gridx = 1;
		gbc_txtnomecliente.gridy = 3;
		add(txtnomecliente, gbc_txtnomecliente);
		txtnomecliente.setColumns(10);
		
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
		tabitens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount()==2){
					alterarItem();
				}
			}
		});
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
		txtpagamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_ENTER)
					calcularTroco();
			}
		});
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

	protected void calcularTroco() {
		BigDecimal troco = new BigDecimal(0);
		BigDecimal pagamento = new BigDecimal(txtpagamento.getText());
		
		troco = pagamento.subtract(new BigDecimal(txtvaltotal.getText()));
		
		txttroco.setText(String.valueOf(troco));
	}

	protected void alterarItem() {
		txtidproduto.setText(String.valueOf(tabitens.getValueAt(tabitens.getSelectedRow(), 0)));
		txtdescricao.setText(String.valueOf(tabitens.getValueAt(tabitens.getSelectedRow(), 1)));
		txtquantidade.setText(String.valueOf(tabitens.getValueAt(tabitens.getSelectedRow(), 2)));
		txtpreco.setText(String.valueOf(tabitens.getValueAt(tabitens.getSelectedRow(), 3)));
		
	}

	protected void adicionarItem() {
		
		List<Item> itens = model.retornarItens();
		Item i = new Item();
		
		i.setIdproduto(Integer.parseInt(txtidproduto.getText()));
		i.setDescricao(txtdescricao.getText());
		i.setQuantidade(Integer.parseInt(txtquantidade.getText()));
		i.setPrecounitario(new BigDecimal(Double.parseDouble(txtpreco.getText())));
		
		int qtd = Integer.parseInt(txtquantidade.getText());
		BigDecimal preco = new BigDecimal(txtpreco.getText());
		
		//Multiplicando o preco unit�rio pela quantidade
		preco = preco.multiply(new BigDecimal(qtd));
		i.setTotalProduto(preco);
		
		//Adicionando na tabela de Itens
		model.incluirItem(i);
		
		BigDecimal total = calcularTotal(itens);
		txtvaltotal.setText(String.valueOf(total));
		
	}

	private void setModelTabela() {
		model = new ItemModel();
		tabitens.setModel(model);	
	}

	public Runnable getAcaoSalvar() {
		return () -> {
			VendaDAOImpl dao = new VendaDAOImpl();
			setarValores();
			
			if (verificarValores()){
				
				
			}
			
			

					
		};
	}

	private boolean verificarValores() {
		int id;
		
		if (txtidcliente.getText().isEmpty() || txtnomecliente.getText().isEmpty() ||
				txtidproduto.getText().isEmpty() || txtdescricao.getText().isEmpty()
				|| txtquantidade.getText().isEmpty() || txtvaltotal.getText().isEmpty() || txtpagamento.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha todos os campos para salvar!");
			return false;
		}
		
		if (model.retornarItens().isEmpty()){
			JOptionPane.showMessageDialog(null, "N�o � poss�vel salvar uma venda sem produtos!");
			return false;
		}
		
		
		try {
			 id = Integer.parseInt(txtidcliente.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "C�digo do cliente inv�lido! \n Informe um valor num�rico.");
			//return false;
		}
		
		try {
			id = Integer.parseInt(txtidproduto.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "C�digo do produto inv�lido! \n Informe um valor num�rico.");
		}
		
		try {
			id = Integer.parseInt(txtquantidade.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Quantidade inv�lida! \n Informe um valor num�rico.");
		}
		
		
		
		return true;
		
	}

	private void salvarItens(List<Item> itens) {
		// TODO Auto-generated method stub
		
	}

	private BigDecimal calcularTotal(List<Item> itens) {
		BigDecimal total = new BigDecimal(0);
		
		for (Item item : itens) {
			total = total.add(item.getTotalProduto());
		}
		
		return total;
	}

	public Runnable getAcaoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setarValores(){
		BigDecimal total = new BigDecimal(0);
		Venda v = new Venda();
		
	}
	
}

