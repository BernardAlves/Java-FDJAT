package br.edu.infnet.produtos;
import java.util.ArrayList;


public class Produto {
    //variáveis do obj
    private String produtoNome;
    private String produtoFornecedor;
    private double produtoPreco;
    //variáveis da classe
    private static int totalProdutos = 0;
    //guarda todos os produtos
    public static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    //construtor
    public Produto (String produtoNome, String produtoFornecedor, double produtoPreco){
        this.produtoNome=produtoNome;
        this.produtoFornecedor=produtoFornecedor;
        this.produtoPreco=produtoPreco;
        totalProdutos ++;
    }
    //getters
    public String getProdutoNome() {return produtoNome;}
    public String getProdutoFornecedor() {return produtoFornecedor;}
    public double getProdutoPreco() {return produtoPreco;}
    public static int getTotalProdutos() {return totalProdutos;}
    //setters
    public void setProdutoNome(String produtoNome) {this.produtoNome = produtoNome;}
    public void setProdutoFornecedor(String produtoFornecedor) {this.produtoFornecedor = produtoFornecedor;}
    public void setProdutoPreco(double produtoPreco) {this.produtoPreco = produtoPreco;}
    //tabela toString de todos os produtos
    public static void getTodosProdutos(){
        int contador = 1;
        System.out.println("\n----------------- ITEMS DISPONÍVEIS ----------------");
        System.out.println("-N---------ITEM--------FORNECEDOR------PREÇO(R$)----\n");
        for(Produto produtos : Produto.listaProdutos){
            System.out.printf("["+contador+"]: "+produtos);
            contador ++;
        }
        System.out.println("----------------------------------------------------");      
    }
    //representação toString do objeto Produto
    @Override 
    public String toString(){
        return String.format("%15s \t%s \t%.2f%n", 
        getProdutoNome(), getProdutoFornecedor(), getProdutoPreco());
    }
}