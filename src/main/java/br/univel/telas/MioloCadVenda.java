package br.univel.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.univel.tabelas.ItemModel;
import br.univel.venda.Item;
import br.univel.venda.Venda;
import br.univel.venda.VendaDAOImpl;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import java.awt.Color;

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
		setLayout(null);
		
		JPanel panel_codigo = new JPanel();
		panel_codigo.setBounds(10, 0, 485, 28);
		add(panel_codigo);
		panel_codigo.setLayout(null);
		
		txtidvenda = new JTextField();
		txtidvenda.setBounds(112, 6, 86, 20);
		panel_codigo.add(txtidvenda);
		txtidvenda.setEditable(false);
		txtidvenda.setColumns(10);
		
		JLabel lblVendaNmero = new JLabel("Venda n\u00FAmero");
		lblVendaNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVendaNmero.setBounds(10, 8, 102, 14);
		panel_codigo.add(lblVendaNmero);
		
		JPanel panel_cliente = new JPanel();
		panel_cliente.setBounds(10, 33, 614, 47);
		panel_cliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_cliente);
		panel_cliente.setLayout(null);
		
		txtidcliente = new JTextField();
		txtidcliente.setBounds(7, 16, 120, 20);
		panel_cliente.add(txtidcliente);
		txtidcliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_INSERT){
					TelaProcuraCliente tpc = new TelaProcuraCliente();
					tpc.setVisible(true);
				}
			}
		});
		txtidcliente.setColumns(10);
		
		txtnomecliente = new JTextField();
		txtnomecliente.setBounds(137, 16, 406, 20);
		panel_cliente.add(txtnomecliente);
		txtnomecliente.setColumns(10);
		
		JButton btnProcura = new JButton("");
		btnProcura.setBounds(553, 11, 50, 25);
		btnProcura.setIcon(new ImageIcon(MioloCadVenda.class.getResource("/br/univel/icones/procura.png")));
		panel_cliente.add(btnProcura);
		
		JPanel panel_produto = new JPanel();
		panel_produto.setBounds(10, 91, 614, 122);
		panel_produto.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_produto);
		panel_produto.setLayout(null);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3d. produto");
		lblCdigoDeBarras.setBounds(10, 23, 74, 14);
		panel_produto.add(lblCdigoDeBarras);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(94, 23, 265, 14);
		panel_produto.add(lblDescrio);
		
		txtidproduto = new JTextField();
		txtidproduto.setBounds(10, 48, 75, 20);
		panel_produto.add(txtidproduto);
		txtidproduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_INSERT){
					TelaProcuraProduto tpp = new TelaProcuraProduto();
					tpp.setVisible(true);
				}
			}
		});
		txtidproduto.setColumns(10);
		
		txtdescricao = new JTextField();
		txtdescricao.setBounds(94, 48, 265, 20);
		panel_produto.add(txtdescricao);
		txtdescricao.setColumns(10);
		
		JButton button = new JButton("");
		button.setBounds(369, 43, 55, 25);
		button.setIcon(new ImageIcon(MioloCadVenda.class.getResource("/br/univel/icones/procura.png")));
		panel_produto.add(button);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(434, 23, 66, 14);
		panel_produto.add(lblQuantidade);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o unit\u00E1rio");
		lblPreo.setBounds(510, 24, 94, 14);
		panel_produto.add(lblPreo);
		
		txtquantidade = new JTextField();
		txtquantidade.setBounds(434, 48, 68, 20);
		panel_produto.add(txtquantidade);
		txtquantidade.setColumns(10);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(510, 48, 94, 20);
		panel_produto.add(txtpreco);
		txtpreco.setColumns(10);
		
		JButton btnOk = new JButton("Adicionar");
		btnOk.setBounds(377, 78, 110, 33);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOk.setIcon(new ImageIcon(MioloCadVenda.class.getResource("/br/univel/icones/add.png")));
		panel_produto.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarItem();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(494, 78, 110, 33);
		btnExcluir.setIcon(new ImageIcon(MioloCadVenda.class.getResource("/br/univel/icones/delete.png")));
		panel_produto.add(btnExcluir);
		
		JPanel panel_venda = new JPanel();
		panel_venda.setBounds(10, 224, 614, 206);
		panel_venda.setBorder(new TitledBorder(null, "Itens da Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_venda);
		panel_venda.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 598, 145);
		panel_venda.add(scrollPane);
		
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
		
		txtvaltotal = new JTextField();
		txtvaltotal.setForeground(new Color(255, 0, 0));
		txtvaltotal.setText("Teste");
		txtvaltotal.setBounds(432, 172, 166, 23);
		panel_venda.add(txtvaltotal);
		txtvaltotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtvaltotal.setEditable(false);
		txtvaltotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(348, 176, 74, 14);
		panel_venda.add(lblTotal);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_pagamento = new JPanel();
		panel_pagamento.setBounds(10, 441, 614, 90);
		panel_pagamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel_pagamento);
		panel_pagamento.setLayout(null);
		
		JLabel lblPagamento = new JLabel("Valor ");
		lblPagamento.setBounds(10, 28, 54, 14);
		panel_pagamento.add(lblPagamento);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setBounds(140, 29, 54, 14);
		panel_pagamento.add(lblTroco);
		
		txtpagamento = new JTextField();
		txtpagamento.setBounds(10, 47, 120, 20);
		panel_pagamento.add(txtpagamento);
		txtpagamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_ENTER)
					calcularTroco();
			}
		});
		txtpagamento.setColumns(10);
		
		txttroco = new JTextField();
		txttroco.setBounds(140, 48, 120, 20);
		panel_pagamento.add(txttroco);
		txttroco.setEditable(false);
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
		
		//Multiplicando o preco unitário pela quantidade
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
			Venda v = new Venda();
			
			
			if (verificarValores()){
				v = setarValores();
				try {
					dao.inserir(v);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*
				if (v.getIdVenda() != 0){
					v = setarValores();
					
					
				}
				*/
				
				
			}
					
		};
	}

	private boolean verificarValores() {
		int id=0;
		
		if (txtidcliente.getText().isEmpty() || txtnomecliente.getText().isEmpty() ||
				txtidproduto.getText().isEmpty() || txtdescricao.getText().isEmpty()
				|| txtquantidade.getText().isEmpty() || txtvaltotal.getText().isEmpty() || txtpagamento.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha todos os campos para salvar!");
			return false;
		}
		
		if (model.retornarItens().isEmpty()){
			JOptionPane.showMessageDialog(null, "Não é possível salvar uma venda sem produtos!");
			return false;
		}
		
		
		try {
			 id = Integer.parseInt(txtidcliente.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código do cliente inválido! \n Informe um valor numérico.");
			//return false;
		}
		
		try {
			id = Integer.parseInt(txtidproduto.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Código do produto inválido! \n Informe um valor numérico.");
		}
		
		try {
			id = Integer.parseInt(txtquantidade.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Quantidade inválida! \n Informe um valor numérico.");
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

	private Venda setarValores(){
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:h");
		//Date hora = Calendar.getInstance().getTime();
		
		//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy");
		//Date data = new Date(System.currentTimeMillis());
		
		Venda v = new Venda();
		
		v.setIdVenda(Integer.parseInt(txtidvenda.getText()));
		v.setIdCliente(Integer.parseInt(txtidcliente.getText()));
		v.setNomeCliente(txtnomecliente.getText());
		v.setValorPagamento(new BigDecimal(txtpagamento.getText()));
		v.setValorTotal(new BigDecimal(txtvaltotal.getText()));
		v.setItens(model.retornarItens());
		v.setData(new Date());
		v.setHora(System.currentTimeMillis());
		
		return v;
	}
	
}

