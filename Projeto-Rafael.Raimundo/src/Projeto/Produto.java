package Projeto;

public class Produto {
	// Declaração da classe "Produto" com três campos privados: nome, quantidade e preço
    private String nome;
    private int quantidade;
    private double preco;

    // Construtor da classe sem parâmetros
    public Produto() {
    }

    // Métodos "get" e "set" para cada um dos campos da classe
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
