//package br.com.compasso.loja.testes;
//
//import java.math.BigDecimal;
//
//import javax.persistence.EntityManager;
//
//import br.com.compasso.loja.dao.ProdutoDao;
//import br.com.compasso.loja.modelo.Produto;
//import br.com.compasso.loja.util.JpaUtil;
//
//public class CadastroDeProduto {
//
//	public static void main(String[] args) {
//
//		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"));
//       
//        
//        EntityManager em = JpaUtil.getEntityManager();
//        
//        ProdutoDao dao = new ProdutoDao(em);
//        
//        em.getTransaction().begin();
//        dao.cadastrar(celular);
//        em.getTransaction().commit();
//        em.close();
//
//        
//	}
//
//}
