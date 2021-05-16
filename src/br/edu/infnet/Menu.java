package br.edu.infnet;

import br.edu.infnet.produtos.Cotacao;
import br.edu.infnet.produtos.Produto;

import java.util.Scanner;
import java.util.*;
//import java.util.regex.Pattern;

public class Menu{
    //imprime o menu inicial
    public static void menuInicial(){
        System.out.println("\n----------------------------------------------------");      
        System.out.println("[1] Cadastrar produto");
        System.out.println("[2] Cadastrar cotação");
        System.out.println("[3] Consultar todos os produtos");
        System.out.println("[4] Consultar cotaçãoes por produto");
        System.out.println("[5] Consultar cotações");
        System.out.println("[6] Sair");
        System.out.println("----------------------------------------------------");      
        System.out.print("Escolha uma das opções acima: ");   
    }
    //escolheu uma das opções
    public static void selecionarOpcao(int i){
        System.out.println("----------------------------------------------------\n");      
        if (i==1){ cadastrarProduto(); }
        else if (i==2){ cadastrarCotacao(); }
        else if (i==3){ consultarProduto(); }
        else if (i==4){ buscarProduto(); }
        else if (i==5){ consultarCotacao(); }
    }
    //opcao 1
    public static void cadastrarProduto(){
        try{
            System.out.println("----- Cadastrar produto ---- (total: "+ Produto.getTotalProdutos()+") -----------");
            //cadastro input : produto nome + validação 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nome do produto:");
            String produtoNome = scanner.nextLine();
            if(produtoNome.length()<2 ||produtoNome.length()>20){
                //System.out.println("if entrou");
                throw new InputMismatchException("(Nome do produto deve ser entre 2 ~ 20 letras.)");
            }
        //cadastro input : produto nome + validação
        System.out.print("Fornecedor: "); 
        String produtoFornecedor = scanner.nextLine();
        if(produtoFornecedor.length()<3 ||produtoFornecedor.length()>20){
            throw new InputMismatchException("(Fornecedor deve ser entre 3 ~ 20 letras.)");
        }
        //cadastro input : produto preço + validação
        System.out.print("Preco: "); 
        double produtoPreco = scanner.nextInt();
        if(produtoPreco < 0){
            throw new InputMismatchException("(Preço dever um número positivo.)");
        }
        //passando para o construtor e realizando cadastro
        Produto produto = new Produto (produtoNome,produtoFornecedor,produtoPreco);
        Produto.listaProdutos.add(produto);
        System.out.println(">> Produto cadastrado!");

    
    }
    catch(InputMismatchException e){ //pegando os throws dos inputs
        System.err.printf("%n>> (Exception: %s)%n", e);
    }
    catch(NoSuchElementException e){
        System.err.printf("%n>> (Exception: %s)%n%n", e);
    }
    finally{
        System.out.println(">> Retornando ao menu inicial...");
    }
  }
    //opcao 2 
    public static void cadastrarCotacao(){
        try{ 
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------- Cadastrar Cotação ------------------");
            System.out.println("    | informe  um  nome  para  sua cotação e|\n    |depois adicione os produtos disponíveis|\n");
            System.out.print("Nome da cotação: ");
            String cotacaoNome = scanner.nextLine();
            if(cotacaoNome.length()<5 ||cotacaoNome.length()>20){
                throw new InputMismatchException("(Nome da Cotação deve ser entre 5 ~ 20 letras.)");
            }
            Cotacao cotacao = new Cotacao(cotacaoNome);
            Main.listaCotacoes.add(cotacao);
            boolean loop=true;
            do{
                try{
                    Produto.getTodosProdutos();
                    System.out.print("Adicione um produto(N) à cotação \""+cotacaoNome+"\" : ");
                    //int N = scanner.nextInt();
                    //scanner.nextLine();
                    int N = Integer.parseInt(scanner.nextLine());
                    cotacao.addProdutoNaCotação(Produto.listaProdutos.get(N-1));     
                    System.out.println("Produto ["+N+"] adicionado à Cotação \""+cotacaoNome+"\"!");       
                    System.out.print("Deseja adicionar mais produtos? \n[S]Sim / [N]Não : ");   
                    String SN = scanner.nextLine();
                    if("n".equalsIgnoreCase(SN)){
                        loop=false;
                    }else{
                        throw new InputMismatchException();
                    }                   
                }
                catch(InputMismatchException e){
                    System.err.printf("%n>> (Exception: %s)%n", e);
                }
                catch(NumberFormatException e){
                    System.err.printf("%n>> (Exception: %s)%n", e);
                }
                catch(IndexOutOfBoundsException e){
                    System.err.printf("%n>> (Exception: %s)%n", e);
                }
            }while(loop);



        }
        catch(InputMismatchException e){
        System.err.printf("%n>> (Exception: %s)%n", e);
        }
    }  
    //opcao 3
    public static void consultarProduto(){
        Produto.getTodosProdutos(); 
  }
    //opcao 4 
    public static void buscarProduto(){
        try{
            System.out.println("----------------------------------------------------");      
            System.out.println("--------- Consultar cotaçãoes por produto ----------");
            System.out.print("Informe o nome do produto: ");
            Scanner scanner = new Scanner(System.in);
            String consultaProduto = scanner.nextLine();
            for(Produto produtos : Produto.listaProdutos){
                //System.out.println("Entrou for...");
                //System.out.println(produtos.getProdutoNome());
                if(consultaProduto.equalsIgnoreCase(produtos.getProdutoNome())){
                    System.out.println(produtos);
                }
            }

        }
        catch(InputMismatchException e){
            System.err.printf("%n>> (Exception: %s)%n", e);
        }
    }
    //opcao 5
    public static void consultarCotacao(){       
        try{
            System.out.println("----------------------------------------------------");      
            System.out.println("-------------- Consultar Cotações ------------------");
            System.out.println("Cotações criadas: "+Cotacao.getTotalCotacoes()+"\n");
            int contador = 0;
            for(Cotacao cotacoes : Main.listaCotacoes){
                System.out.printf("["+contador+"] "+cotacoes);
                contador ++;
            }
            if(Cotacao.getTotalCotacoes() != 0){
                boolean loop = true;
                System.out.println("----------------------------------------------------");      
                System.out.print("Informe o [N]úmero da cotação: ");
                Scanner scanner = new Scanner(System.in);
                int consultaCotacao = Integer.parseInt(scanner.nextLine());
                do{
                    Cotacao lista = Main.listaCotacoes.get(consultaCotacao); //aponta para uma objeto Cotacao, na lista de cotações do Main
                    lista.getProdutosCotacao(); //teste, info gerais da cotacao 
                    System.out.println("\n[R] Remover produto");      
                    System.out.println("[A] Adicionar produto");      
                    System.out.println("[X] Excluir cotação");      
                    System.out.println("[M] Menu inicial");      
                    System.out.print("Escolha uma opção: ");      
                    String edit = scanner.nextLine(); 
                    if(edit.equalsIgnoreCase("r")){
                        System.out.print("Informe o [N] Produto a remover: ");             
                        int n = Integer.parseInt(scanner.nextLine());
                        lista.removerProduto(n-1); 
                    }
                    if(edit.equalsIgnoreCase("a")){
                        System.out.println("entrou adicionar"); 
                        Produto.getTodosProdutos();
                        System.out.print("Adicionar Produto: ");             
                        int n = Integer.parseInt(scanner.nextLine());
                        lista.addProdutoNaCotação(Produto.listaProdutos.get(n-1));             
                    }
                    if(edit.equalsIgnoreCase("x")){
                        lista = null ;
                        //System.out.println(lista.getQtdProdutosCotacao());   
                        //dá um throw NullPointerException , estou apagando apenas a referencia 'lista' ? 
                        //ou meus objetos Produtos ainda fazem referencia à lista ? <
                        //Main.listaCotacoes.get(consultaCotacao) = null ;
                        System.out.println(">>Cotação excluída..."); 
                        System.out.println(">>Voltando ao menu inicial...");      
                        loop=false;           
                    }                   
                    if(edit.equalsIgnoreCase("m")){
                        System.out.println(">>Voltando ao menu inicial...");      
                        loop=false;       
                    }                   
                }while(loop); 
            }
        }
        catch(InputMismatchException e){
            System.err.printf("%n>> (Exception: %s)%n", e);
        }
        catch(NumberFormatException e){
            System.err.printf("%n>> (Exception: %s)%n", e);
        }
        catch(IndexOutOfBoundsException e){
            System.err.printf("%n>> (Exception: %s)%n", e);
        }
        
    }
}
