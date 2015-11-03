package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Insets;
import java.sql.SQLException;
/**
 * Tela moldura onde aparecerá os campos para preencher 
 * @author tcrivelatti - 28/10/2015
 *
 */

public abstract class MolduraAbstrata extends JPanel {
	private JPanel panel;
	private JButton btnFechar;
	private JButton btnSalvar;
	private JButton btnAtualizar;
	private JButton btnExcluir;

	protected abstract void configuraMiolo() throws SQLException;
	
	public void setCloseAction(ActionListener action){
		btnFechar.addActionListener(action);
	}
	
	
	/**
	 * Create the panel.
	 */
	
	public MolduraAbstrata() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblSistemaDeVendas = new JLabel("Sistema de Vendas");
		panel.add(lblSistemaDeVendas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnNewButton);
		
		btnAtualizar = new JButton("Atualizar");
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtualizar.gridx = 1;
		gbc_btnAtualizar.gridy = 0;
		panel_1.add(btnAtualizar, gbc_btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel_1.add(btnExcluir, gbc_btnExcluir);
		
		btnFechar = new JButton("Fechar");
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 3;
		gbc_btnFechar.gridy = 0;
		panel_1.add(btnFechar, gbc_btnFechar);

		try {
			configuraMiolo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAcaoSalvar(Runnable acaoSalvar) {
		btnSalvar.addActionListener(e -> acaoSalvar.run());
	}

	public void setAcaoExcluir(Runnable acaoExcluir) {
		btnExcluir.addActionListener(e -> acaoExcluir.run());
	}

}
