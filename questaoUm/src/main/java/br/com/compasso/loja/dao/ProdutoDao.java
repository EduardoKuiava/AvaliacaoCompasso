package br.com.compasso.loja.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.compasso.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public Produto findId(int id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorReferencia(int id) {
		String jpql = "SELECT p FROM Produto p WHERE p.id <= :id";
		return em.createQuery(jpql, Produto.class)
				.setParameter("id", id)
				.getResultList();
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
}
