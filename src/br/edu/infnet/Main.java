package br.edu.infnet;
import br.edu.infnet.produtos.Cotacao;
import br.edu.infnet.produtos.Produto;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

class Main {

    //ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    public static ArrayList<Cotacao> listaCotacoes = new ArrayList<Cotacao>();
    
    public static void main(String[] args) {
        System.out.println("\n----------------------------------------------------");      
        System.out.println("Sistema iniciado.");
        System.out.println("Mockando dados... ");
        Produto.listaProdutos.add(new Produto("Caneta preta", "Empresa X", 1.75));
        Produto.listaProdutos.add(new Produto("Caneta azul", "Empresa X", 1.75));
        Produto.listaProdutos.add(new Produto("Grampeador", "Empresa X", 5.5));
        Produto.listaProdutos.add(new Produto("Papel A4", "Empresa X", 4));   
        Produto.listaProdutos.add(new Produto("Caneta preta", "Outro Lugar", 1.75));
        Produto.listaProdutos.add(new Produto("Caneta azul", "Outro Lugar", 1.75));
        Produto.listaProdutos.add(new Produto("Papel A4", "Outro Lugar", 4));
        Produto.listaProdutos.add(new Produto("Porta copo", "Outro Lugar", 2.3));   
        Produto.listaProdutos.add(new Produto("Pacote café 1kg", "Loja Barata", 12));
        Produto.listaProdutos.add(new Produto("Grampeador", "Loja Barata", 3));
        Produto.listaProdutos.add(new Produto("Porta copo", "Loja Barata", 1.5));
        Produto.listaProdutos.add(new Produto("Leite condensado", "Declínio", 162));
        Produto.listaProdutos.add(new Produto("Cloroquina", "Declínio", 5));
        Produto.listaProdutos.add(new Produto("Gasolina", "Declínio", 6));
        String[] listaNomesCotacao = {"Cotação Janeiro 2021","Cotação Fevereiro 2021","Alguma outra Cotação 2021","Cotação Março 2021"};
        listaCotacoes.add(new Cotacao("Cotação Janeiro 2021"));
        listaCotacoes.add(new Cotacao("Cotação Fevereiro 2021"));
        listaCotacoes.add(new Cotacao("Alguma outra Cotação 2021"));
        listaCotacoes.add(new Cotacao("Cotação Março 2021"));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(1));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(1));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(7));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(4));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(11));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(3));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(3));
        listaCotacoes.get(0).addProdutoNaCotação(Produto.listaProdutos.get(2));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(1));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(2));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(6));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(11));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(11));
        listaCotacoes.get(1).addProdutoNaCotação(Produto.listaProdutos.get(11));
        listaCotacoes.get(2).addProdutoNaCotação(Produto.listaProdutos.get(12));
        listaCotacoes.get(2).addProdutoNaCotação(Produto.listaProdutos.get(12));
        listaCotacoes.get(3).addProdutoNaCotação(Produto.listaProdutos.get(4));
        listaCotacoes.get(3).addProdutoNaCotação(Produto.listaProdutos.get(4));
        listaCotacoes.get(3).addProdutoNaCotação(Produto.listaProdutos.get(8));

        
        boolean loop = true;
        do{
            try{
                Menu.menuInicial();
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (input == 6){
                    System.out.println("\n>> Programa Terminado...\n");
                    loop = false;
                }
                else if (input<1 || input>6){
                    throw new InputMismatchException();
                }
                else{
                    Menu.selecionarOpcao(input);
                }
            }
            catch(InputMismatchException e){
                System.err.printf("%n>> Somente numeros entre 1 e 4, tente novamente. %n>> (Exception: %s)%n%n", e);
            }
            catch(NoSuchElementException e){
                System.err.printf("%n>> (Exception: %s)%n%n", e);
            }
        }while(loop);
    }
}