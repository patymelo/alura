package br.com.caelum.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class testaCache {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		EntityManagerFactory ef = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = ef.createEntityManager();
		Produto p = em.find(Produto.class, 10);
		Produto p1 = em.find(Produto.class, 10);
		
		System.out.println("Produto: "+p.getNome());
		System.out.println("Produto2: "+p1.getNome());
		
		em.close();
	}

}
