package Projeto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class GerenciadosDeStocks {
	
	private Stock stock = new Stock();
	private JFrame frmMerceariaJooLda;
	private JTextField txtAddNome;
	private JTextField txtAddQuantidade;
	private JTextField txtAddPreco;
	private JTextField txtQuantRemove;
	private JTextField txtPrecoURemove;
	private JTextField txtPrecoTotalRemove;
	private JTextField txtCompra;
	private JTextField txtNovaQ;
	private JTextField txtPU;
	private JTextField txtPFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciadosDeStocks window = new GerenciadosDeStocks();
					window.frmMerceariaJooLda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GerenciadosDeStocks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMerceariaJooLda = new JFrame();
		frmMerceariaJooLda.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Transferencias\\pngwing.com.png"));
		frmMerceariaJooLda.setTitle("Mercearia João, LDA");
		frmMerceariaJooLda.setResizable(false);
		frmMerceariaJooLda.setBounds(100, 100, 603, 326);
		frmMerceariaJooLda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMerceariaJooLda.getContentPane().setLayout(null);
		
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBounds(10, 94, 567, 185);
		frmMerceariaJooLda.getContentPane().add(mainTab);
		
		JPanel tabAdd = new JPanel();
		mainTab.addTab("Adicionar Produto", null, tabAdd, null);
		tabAdd.setLayout(null);
		
		JPanel tabRemove = new JPanel();
		mainTab.addTab("Verificar / Remover produto", null, tabRemove, null);
		tabRemove.setLayout(null);

		JPanel tabVenda = new JPanel();
		mainTab.addTab("Vender Produto", null, tabVenda, null);
		tabVenda.setLayout(null);
		
		JPanel tabAtualiza = new JPanel();
		mainTab.addTab("Atualizar Produto", null, tabAtualiza, null);
		tabAtualiza.setLayout(null);
		
		JComboBox comboSelect = new JComboBox();
		comboSelect.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboSelect.setModel(new DefaultComboBoxModel(new String[] {"ATUALIZAR PREÇO", "ATUALIZAR QUANTIDADE"}));
		comboSelect.setBounds(293, 71, 205, 22);
		tabAtualiza.add(comboSelect);
		
		JComboBox comboAtualiza = new JComboBox();
		comboAtualiza.setBounds(45, 71, 157, 22);
		tabAtualiza.add(comboAtualiza);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Chama o método "alteraQuant" da classe "Stock" com o nome do produto, 
				// a nova quantidade, o novo preço e os objetos "JTextField" como parâmetros 
				// para atualizar a quantidade e o preço do produto selecionado e exibir as alterações 
				// na interface gráfica
				
				// Se o campo de texto estiver vazio, exibe uma mensagem de erro
				if (txtNovaQ.getText().isBlank()) {
					JOptionPane.showMessageDialog(frmMerceariaJooLda, "Tem que introduzir um valor!");
				} else {
					String nome = (String) comboAtualiza.getSelectedItem();
					double preco;
					int quant;
					// Se o item selecionado no combo box for "ATUALIZAR QUANTIDADE", atualiza a quantidade do produto e exibe uma mensagem de bem sucedido
					if (comboSelect.getSelectedItem() == "ATUALIZAR QUANTIDADE") {
						preco = (double) 0;
						quant = Integer.parseInt(txtNovaQ.getText());
						stock.alteraQuant(nome, quant, preco, txtQuantRemove, txtPrecoURemove, txtPrecoTotalRemove);
						JOptionPane.showMessageDialog(frmMerceariaJooLda, "Quantidade atualizada com sucesso!");
						txtNovaQ.setText("");
					// Se o item selecionado no combo box for "ATUALIZAR PREÇO", atualiza o preço do produto e exibe uma mensagem de bem sucedido
					} else if (comboSelect.getSelectedItem() == "ATUALIZAR PREÇO") {
						quant = 0;
						preco = Double.parseDouble(txtNovaQ.getText());
						stock.alteraQuant(nome, quant, preco, txtQuantRemove, txtPrecoURemove, txtPrecoTotalRemove);
						JOptionPane.showMessageDialog(frmMerceariaJooLda, "Quantidade atualizada com sucesso!");
						txtNovaQ.setText("");
					// Se nenhum desses itens for selecionado, exibe uma mensagem de erro
					} else {
						JOptionPane.showMessageDialog(frmMerceariaJooLda, "Impossível atualizar quantidade!");
					}	
				}
			}
		});
		btnAtualiza.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualiza.setBounds(46, 111, 157, 23);
		tabAtualiza.add(btnAtualiza);
		
		txtNovaQ = new JTextField();
		txtNovaQ.setColumns(10);
		txtNovaQ.setBounds(293, 112, 205, 20);
		tabAtualiza.add(txtNovaQ);
		
		JLabel lblNewLabel_3 = new JLabel("ATUALIZAR PRODUTO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 542, 49);
		tabAtualiza.add(lblNewLabel_3);
		
		JLabel lblAdd1 = new JLabel("Nome do Produto:");
		lblAdd1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdd1.setBounds(30, 58, 154, 23);
		tabAdd.add(lblAdd1);
		
		JLabel lblAdd2 = new JLabel("Quantidade:");
		lblAdd2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdd2.setBounds(30, 89, 154, 23);
		tabAdd.add(lblAdd2);
		
		JLabel lblPreounidade = new JLabel("Preço (unidade):");
		lblPreounidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreounidade.setBounds(30, 123, 154, 23);
		tabAdd.add(lblPreounidade);
		
		txtAddNome = new JTextField();
		txtAddNome.setBounds(166, 60, 166, 20);
		tabAdd.add(txtAddNome);
		txtAddNome.setColumns(10);
		
		txtAddQuantidade = new JTextField();
		txtAddQuantidade.setColumns(10);
		txtAddQuantidade.setBounds(166, 91, 166, 20);
		tabAdd.add(txtAddQuantidade);
		
		JComboBox comboVenda = new JComboBox();
		comboVenda.setBounds(20, 65, 157, 22);
		tabVenda.add(comboVenda);
		
		txtAddPreco = new JTextField();
		txtAddPreco.setColumns(10);
		txtAddPreco.setBounds(166, 123, 166, 20);
		tabAdd.add(txtAddPreco);
		
		JComboBox comboRemove = new JComboBox();
		comboRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Converte o nome do produto a partir de um objeto "JComboBox" numa String
				String nome = (String) comboRemove.getSelectedItem();
				// Chama o método "colocaQuant" da classe "Stock" com o nome do produto e os objetos "JTextField" como parâmetros
				// que atualiza os campos de texto com as informações do produto selecionado
				stock.colocaQuant(nome, txtQuantRemove, txtPrecoURemove, txtPrecoTotalRemove);
			}
		});
		comboRemove.setBounds(71, 48, 157, 22);
		tabRemove.add(comboRemove);
		
		JButton btnAdd = new JButton("ADICIONAR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cria um novo objeto "Produto"
				Produto produto = new Produto();
				// Converte o nome do produto a partir de um campo de texto numa String
				String nome = txtAddNome.getText();
				// Converte a quantidade do produto para inteiro a partir de um campo de texto
				int quantidade = Integer.parseInt(txtAddQuantidade.getText());
				// Converte o preço do produto para double a partir de um campo de texto
				double preco = Double.parseDouble(txtAddPreco.getText());
				
				// Atribui o nome, quantidade e preço ao objeto "Produto" através dos Getters e Setters
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				
				// Chama o método "adicionarProduto" da classe "Stock" com o objeto "Produto" como parâmetro
				boolean adicionado = stock.adicionarProduto(produto);
				
				if (adicionado) {
					// Se o produto for adicionado com sucesso, mostra uma mensagem de bem sucedido numa caixa de diálogo e atualiza os objetos "JComboBox" com o novo produto
					JOptionPane.showMessageDialog(frmMerceariaJooLda, "Produto adicionado com sucesso!");
					stock.preencherComboBox(comboRemove);
					stock.preencherComboBox(comboVenda);
					stock.preencherComboBox(comboAtualiza);
				} else {
					// Se o produto não for adicionado, mostra uma mensagem de erro numa caixa de diálogo
					JOptionPane.showMessageDialog(frmMerceariaJooLda, "Erro: Nome do produto já existe no Stock!");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(366, 72, 154, 23);
		tabAdd.add(btnAdd);
		
		JButton btnAddClear = new JButton("LIMPAR CAMPOS");
		btnAddClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Limpa o conteúdo dos campos de texto para adicionar um novo produto
				txtAddNome.setText(null);
				txtAddQuantidade.setText(null);
				txtAddPreco.setText(null);
				// Mostra uma mensagem de sucesso numa caixa de diálogo
				JOptionPane.showMessageDialog(frmMerceariaJooLda, "Campos limpados com sucesso!");
			}
		});
		btnAddClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddClear.setBounds(366, 106, 154, 23);
		tabAdd.add(btnAddClear);
		
		JLabel lblNewLabel_1 = new JLabel("ADICIONAR PRODUTO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 542, 46);
		tabAdd.add(lblNewLabel_1);
		
		JLabel lbl1 = new JLabel("Quantidade: ");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl1.setBounds(266, 51, 103, 14);
		tabRemove.add(lbl1);
		
		txtQuantRemove = new JTextField();
		txtQuantRemove.setEditable(false);
		txtQuantRemove.setBounds(396, 48, 86, 20);
		tabRemove.add(txtQuantRemove);
		txtQuantRemove.setColumns(10);
		
		JLabel lbl2 = new JLabel("Preço (unidade):");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl2.setBounds(266, 88, 142, 14);
		tabRemove.add(lbl2);
		
		txtPrecoURemove = new JTextField();
		txtPrecoURemove.setEditable(false);
		txtPrecoURemove.setColumns(10);
		txtPrecoURemove.setBounds(396, 86, 86, 20);
		tabRemove.add(txtPrecoURemove);
		
		JLabel lbl3 = new JLabel("Preço (total):");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl3.setBounds(266, 126, 142, 14);
		tabRemove.add(lbl3);
		
		txtPrecoTotalRemove = new JTextField();
		txtPrecoTotalRemove.setEditable(false);
		txtPrecoTotalRemove.setColumns(10);
		txtPrecoTotalRemove.setBounds(396, 124, 86, 20);
		tabRemove.add(txtPrecoTotalRemove);
		
		JButton btnRemover = new JButton("Remover Produto");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Converte o nome do produto selecionado num objeto "JComboBox" numa String
				String nome = (String) comboRemove.getSelectedItem();
				// Mostra uma mensagem de bem sucedido numa caixa de diálogo
		        JOptionPane.showMessageDialog(frmMerceariaJooLda, "Produto removido com sucesso!");
		        // Chama o método "eliminarProduto" da classe "Stock" para remover o produto selecionado
		        stock.eliminarProduto(nome, comboRemove);
		        stock.eliminarProduto(nome, comboVenda);
		        stock.eliminarProduto(nome, comboAtualiza);
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemover.setBounds(71, 123, 157, 23);
		tabRemove.add(btnRemover);
		
		JLabel lblNewLabel_2 = new JLabel("VERIFICAR / REMOVER STOCK");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 542, 29);
		tabRemove.add(lblNewLabel_2);
		
		JLabel lblVenda = new JLabel("VENDA DE PRODUTO");
		lblVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenda.setBounds(10, 11, 542, 43);
		tabVenda.add(lblVenda);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lbl1_1 = new JLabel("Quantidade: ");
		lbl1_1.setBounds(20, 98, 103, 14);
		tabVenda.add(lbl1_1);
		lbl1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtCompra = new JTextField();
		txtCompra.setBounds(125, 96, 52, 20);
		tabVenda.add(txtCompra);
		txtCompra.setColumns(10);
		
		JButton btnComprar = new JButton("Vender");
		btnComprar.setBounds(304, 123, 157, 23);
		tabVenda.add(btnComprar);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o campo de texto está vazio
				if (txtCompra.getText().isEmpty()) {
					// Se sim, mostra uma mensagem de erro numa caixa de diálogo
					JOptionPane.showMessageDialog(frmMerceariaJooLda, "Tem que introduzir um valor a vender!");
				} else {
					// Se não, converte o nome do produto selecionado num objeto "JComboBox" numa String
					String nome = (String) comboVenda.getSelectedItem();
					// Converte a quantidade de um produto para inteiro a partir de um campo de texto
					int quant = Integer.parseInt(txtCompra.getText());
					// Verifica se a quantidade é maior ou igual a zero
					if (quant >= 0) {
						// Se sim, chama o método "venderProduto" da classe "Stock" com os parâmetros: nome, quantidade e três objetos "JTextField"
						stock.venderProduto(nome, quant, txtQuantRemove, txtPrecoURemove, txtPrecoTotalRemove);
						// Limpa o campo de texto da quantidade
						txtCompra.setText("");
					}
				}
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnCalcula = new JButton("Calcular Preço");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Converte o nome do produto selecionado num objeto "JComboBox" numa String
				String nome = (String) comboVenda.getSelectedItem();
				// Converte a quantidade de um produto para inteiro a partir de um campo de texto
				int quant = Integer.parseInt(txtCompra.getText());
				// Chama o método "vendaTotal" da classe "Stock" com os parâmetros: nome, quantidade e dois objetos "JTextField"
				stock.vendaTotal(nome, quant, txtPU, txtPFinal);
			}
		});
		btnCalcula.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalcula.setBounds(110, 123, 157, 23);
		tabVenda.add(btnCalcula);
		
		JLabel lbl2_1 = new JLabel("Preço (unidade):");
		lbl2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl2_1.setBounds(286, 68, 142, 14);
		tabVenda.add(lbl2_1);
		
		txtPU = new JTextField();
		txtPU.setEditable(false);
		txtPU.setColumns(10);
		txtPU.setBounds(404, 66, 86, 20);
		tabVenda.add(txtPU);
		
		JLabel lbl3_1 = new JLabel("Preço (total):");
		lbl3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl3_1.setBounds(286, 98, 142, 14);
		tabVenda.add(lbl3_1);
		
		txtPFinal = new JTextField();
		txtPFinal.setEditable(false);
		txtPFinal.setColumns(10);
		txtPFinal.setBounds(404, 96, 86, 20);
		tabVenda.add(txtPFinal);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\TPSI1022\\Java Programs\\Java\\Projeto-Rafael.Raimundo\\src\\Projeto\\JohnnyMerc.png"));
		lblNewLabel.setBounds(29, 11, 534, 78);
		frmMerceariaJooLda.getContentPane().add(lblNewLabel);
	}
}
