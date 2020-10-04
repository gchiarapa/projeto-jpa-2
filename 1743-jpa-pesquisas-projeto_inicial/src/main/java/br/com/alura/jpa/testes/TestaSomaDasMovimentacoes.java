package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDAO movimentação = new MovimentacaoDAO(em);

		System.out.println("A soma das movimentações é " + movimentação.getSomaDasMovimentações());

	}

}
