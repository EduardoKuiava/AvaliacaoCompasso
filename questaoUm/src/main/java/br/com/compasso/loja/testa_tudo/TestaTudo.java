package br.com.compasso.loja.testa_tudo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import br.com.compasso.loja.dao.ProdutoDao;
import br.com.compasso.loja.modelo.Produto;
import br.com.compasso.loja.util.JpaUtil;

public class TestaTudo {

	public static void main(String[] args) {

		short opcao;
		Scanner leitor = new Scanner(System.in);

		do {

			exibirMenu();

			System.out.print("Opção escolhida: ");
			opcao = leitor.nextShort();

			switch (opcao) {
			case 11:
				cadastrarProduto();
				break;
			case 22:
				modificarProduto();
				break;
			case 33:
				deletarProduto();
				break;
			case 44:
				listarProdutos();
				break;
			case 99:
				break;
			default:
				System.out.println("+-------------------------------------------+");
				System.out.println("|             VALOR INVÁLIDO!               |");
				System.out.println("+-------------------------------------------+");
			}
		} while (opcao != 99);
		System.out.println("+-------------------------------------------+");
		System.out.println("|             SYSTEM CLOSED                 |");
		System.out.println("+-------------------------------------------+");
		leitor.close();
	}

	static void exibirMenu() {

		System.out.println("\n");
		System.out.println("+-------------------------------------------+");
		System.out.println("|             Menu de Opções                |");
		System.out.println("+-------------------------------------------+");
		System.out.println("| 11 - Cadastrar Produtos                   |");
		System.out.println("| 22 - Atualizar 1° Produto                 |");
		System.out.println("| 33 - Excluir 2° Produto                   |");
	    System.out.println("| 44 - Listar Produtos por nome             |");
		System.out.println("| 99 - Sair                                 |");
		System.out.println("+-------------------------------------------+");
	}

	private static void cadastrarProduto() {

		Produto primeiroProduto = new Produto("Celular", "xiaomi redmi", new BigDecimal("0.05"), LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 15));
		Produto segundoProduto = new Produto("Mouse", "Corsair wireless gamer", new BigDecimal("0.12"), LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 15));
		Produto terceiroProduto = new Produto("Memoria", "Memoria RAM 8Gb FURY HyperX", new BigDecimal("0.30"), LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 15));

		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		produtoDao.cadastrar(primeiroProduto);
		produtoDao.cadastrar(segundoProduto);
		produtoDao.cadastrar(terceiroProduto);

		em.getTransaction().commit();
		em.close();

		System.out.println("+-------------------------------------------+");
		System.out.println("|             11 FINALIZADO                 |");
		System.out.println("+-------------------------------------------+");
	}

	private static void modificarProduto() {

		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		Produto produto = produtoDao.findId(1);

		produto.setNome("Monitor");
		produto.setDescricao("Dell 144Ghz");
		produto.setDesconto(new BigDecimal("0.17"));
		produto.setDataInicio(LocalDate.of(2021, 4, 21));
		produto.setDataFim(LocalDate.of(2021, 5, 21));

		em.getTransaction().commit();
		em.close();

		System.out.println("+-------------------------------------------+");
		System.out.println("|             22 FINALIZADO                 |");
		System.out.println("+-------------------------------------------+");
	}

	private static void deletarProduto() {
		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		Produto produto = produtoDao.findId(2);

		em.remove(produto);

		em.getTransaction().commit();
		em.close();

		System.out.println("+-------------------------------------------+");
		System.out.println("|             33 FINALIZADO                 |");
		System.out.println("+-------------------------------------------+");
	}
	
	  private static void listarProdutos() { 
		  EntityManager em = JpaUtil.getEntityManager();
		  ProdutoDao produtoDao = new ProdutoDao(em);
		  
		  List<Produto> todos = produtoDao.buscarTodos();
		  todos.forEach(p -> System.out.println(p.getNome()));
		  
	  }
	  

	
//	  private static void listarProdutos() { EntityManager em =
//	  JpaUtil.getEntityManager();
//	  
//	  ProdutoDao produtoDao = new ProdutoDao(em);
//	  
//	  em.getTransaction().begin();
//	
//	  Scanner scanner = new Scanner(System.in);
//	  System.out.print("quantidade de produtos listados: ");
//	  short ids = scanner.nextShort();
//	  
//	  
//	  List<Produto> todos = produtoDao.buscarPorReferencia(ids);
//	  todos.forEach(p2 -> System.out.println(p.getId()));
//	  
//	  System.out.println("+-------------------------------------------+");
//	  System.out.println("|             44 FINALIZADO                 |");
//	  System.out.println("+-------------------------------------------+"); }
	 
}
