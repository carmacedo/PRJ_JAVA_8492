package Projeto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Stock {
	
	// Declaração da classe "Stock" com um campo privado do tipo "ArrayList" de produtos
    private ArrayList<Produto> produtos;

    // Campo "df" do tipo "DecimalFormat" para formatação de valores decimais
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    // Construtor da classe sem parâmetros
    public Stock() {
        produtos = new ArrayList<>();
    }

 // Método "adicionarProduto" para adicionar produtos à lista de produtos através de um for-each
    public boolean adicionarProduto(Produto produto) {
        //Declaração de uma variàvel boolean para retornar um certo valor para verificação de existência de produto
    	boolean produtoExiste = false;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                produtoExiste = true;
                break;
            }
        }

        if (!produtoExiste) {
            produtos.add(produto);
        }

        return !produtoExiste;
    }

    // Método "eliminarProduto" para remover produtos da lista de produtos através de um for-each
    public void eliminarProduto(String nome, JComboBox comboBox) {
        for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
                produtos.remove(p);
                break;
            }
        }
        comboBox.removeItem(nome);
    }
    
    // Método "preencherComboBox" para preencher um objeto "JComboBox" com os nomes dos produtos
    public void preencherComboBox(JComboBox<String> comboBox) {
    	comboBox.removeAllItems();
    	for (Produto p : produtos) {
    		if (comboBox.getSelectedItem() != p.getNome()) {
                comboBox.addItem(p.getNome());
    		}
        }
    }
    
    // Método "atualizaQuant" para atualizar a quantidade de um produto através o seu nome
    public void atualizaQuant(String nome, int novaQuantidade) {
    	for (Produto p : produtos) {
    		if (p.getNome().equalsIgnoreCase(nome)) {
    			p.setQuantidade(novaQuantidade);
    			break;
    		}
    	}
    }

    // Método "colocaQuant" para mostrar a quantidade, o preço e o total de um produto em campos de texto
    public void colocaQuant(String nome, JTextField txt, JTextField txt2, JTextField txt3) {
    	for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
            	//Atribuição de valores em campos de texto (utilização do df para limitar o número de casas decimais)
            	txt.setText(String.valueOf(p.getQuantidade()));
            	txt2.setText(String.valueOf(df.format(p.getPreco()) + "€"));
            	txt3.setText(String.valueOf(df.format(p.getQuantidade() * p.getPreco()) + "€"));
                break;
            }
        }
    }
    
    // Método "mudaQuant" para alterar a quantidade de um produto e atualizar os campos de texto
    public void mudaQuant(String nome, int novaQuantidade, JTextField txt, JTextField txt2, JTextField txt3) {
    	for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
            	//Mudar o valor da quantidade do produto escolhido para a nova quantidade
    			p.setQuantidade(novaQuantidade);
            	//Atribuição de valores em campos de texto (utilização do df para limitar o número de casas decimais)
    			txt.setText(String.valueOf(p.getQuantidade()));
            	txt2.setText(String.valueOf(df.format(p.getPreco() + "€")));
            	txt3.setText(String.valueOf(df.format(p.getQuantidade() * p.getPreco() + "€")));
                break;
            }
        }
    }
    
    // Método "alteraQuant" para alterar a quantidade e o preço de um produto e atualizar os campos de texto
    public void alteraQuant(String nome, int novaQuantidade, double preco, JTextField txt, JTextField txt2, JTextField txt3) {
    	for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
            	//Verificação de escolha do utilizador, onde o mesmo pode optar por atualizar o stock ou o preço do produto
            	if (preco == 0) {
	    			p.setQuantidade(p.getQuantidade() + novaQuantidade);
            	} else if (novaQuantidade == 0) {
	    			p.setPreco(preco);
            	}
            	//Atribuição de valores em campos de texto (utilização do df para limitar o número de casas decimais)
            	txt.setText(String.valueOf(p.getQuantidade()));
            	txt2.setText(String.valueOf(df.format(p.getPreco()) + "€"));
            	txt3.setText(String.valueOf(df.format(p.getQuantidade() * p.getPreco()) + "€"));
                break;
            }
        }
    }
    
    //Método "bucarProdutoPeloNome" para encontrar um produto existente na base de dados
    public Produto buscarProdutoPeloNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    //Método "venderProduto" utilizado para atualizar os valores de um determinado produto consuante a venda dos mesmos
    public void venderProduto(String nome, int quantidade, JTextField txt, JTextField txt2, JTextField txt3 ) {
        //Utilização do método "buscarProdutoPeloNome" para procura do produto na ArrayList
    	Produto produto = buscarProdutoPeloNome(nome);
        //Verificação da existencia do produto na dropbox
        if (produto == null) {
            JOptionPane.showMessageDialog(null, "O produto especificado não existe no stock!");
            return;
        } else {
            int stockAtual = produto.getQuantidade();
            //Verificação de Stock
            if(stockAtual == 0) {
            	JOptionPane.showMessageDialog(null, "Estamos atualmente sem stock de " + nome);
            }
            else if (stockAtual < quantidade) {
                JOptionPane.showMessageDialog(null, "A quantidade especificada é maior do que o stock atual do produto!");
            } else {
                produto.setQuantidade(stockAtual - quantidade);
                if (produto.getQuantidade() < 10 && produto.getQuantidade() > 0) {
                    JOptionPane.showMessageDialog(null, "O stock do produto " + nome + " tem que ser reposto!");
                    JOptionPane.showMessageDialog(null, "Obrigado por comprar na nossa loja!");
                } else if(produto.getQuantidade() <= 0) {
                	JOptionPane.showMessageDialog(null, nome + " entrou em rotura!");
                	JOptionPane.showMessageDialog(null, "Obrigado por comprar na nossa loja!");
                }
            }
        }
        //Atribuição de valores em campos de texto (utilização do df para limitar o número de casas decimais)
    	txt.setText(String.valueOf(produto.getQuantidade()));
    	txt2.setText(String.valueOf(df.format(produto.getPreco()) + "€"));
    	txt3.setText(String.valueOf(df.format(produto.getQuantidade() * produto.getPreco()) + "€"));
    }
    
    //Método "vendaTotal" onde mostra o valor da unidade e o valor total que o comprador pretende comprar
    public void vendaTotal(String nome, int quantidade, JTextField txt, JTextField txt2) {
    	for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
            	//Atribuição de valores em campos de texto (utilização do df para limitar o número de casas decimais)
            	txt.setText(String.valueOf(df.format(p.getPreco())) + "€");
            	txt2.setText(String.valueOf(df.format(quantidade * p.getPreco())) + "€");
                break;
            }
        }
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
