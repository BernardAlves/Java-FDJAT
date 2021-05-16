package br.edu.infnet.produtos;
import java.util.ArrayList;

public class Cotacao {
    private String cotacaoNome;
    private ArrayList<Produto> listaProdutosDessaCotação = new ArrayList<Produto>();
    private static int totalCotacoes = 0;
    //construtor
    public Cotacao(String cotacaoNome){
        this.cotacaoNome=cotacaoNome;
        totalCotacoes ++;
    }
    //get e set
    public String getCotacaoNome() {return cotacaoNome;}
    public void setCotacaoNome(String cotacaoNome) {this.cotacaoNome = cotacaoNome;}
    public static int getTotalCotacoes() {return totalCotacoes;}

    // ADICIONA um obj PRODUTO na listaProdutosDessaCotação
    public void addProdutoNaCotação(Produto p){
        listaProdutosDessaCotação.add(p);
    }
    // REMOVE produto da lista
    public void removerProduto(int n){
        listaProdutosDessaCotação.remove(n);
    }
    //retorna QUANTIDADE de produtos nessa cotacao
    public int getQtdProdutosCotacao(){
        return listaProdutosDessaCotação.size();
    }
    //retorna PRODUTOS DESSA COTACAO
    public void getProdutosCotacao(){
        int contador = 1;
        System.out.println("\n----------------Cotação: "+getCotacaoNome()+"---------------------\n");
        for(Produto produtos : listaProdutosDessaCotação){
            System.out.printf("["+contador+"]: "+produtos);
            contador ++;
        }
        System.out.println("\ntotal ------------------------------ R$ "+getPrecoCotacao()+" -----");
    }
    //retorna PREÇO TOTAL dessa cotacao
    public double getPrecoCotacao(){
        double precoTotal = 0;
        for(Produto produtos : listaProdutosDessaCotação){
            precoTotal = precoTotal + produtos.getProdutoPreco();
        }
        return precoTotal;
    }
    
    @Override 
    public String toString(){
        return String.format("%s : %s produtos , total R$ %.2f%n", getCotacaoNome(), getQtdProdutosCotacao(), getPrecoCotacao());
    }
}