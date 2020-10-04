package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TestaMovimentacoesFiltradasPorCriteria {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDAO.getMovimentacoesFiltradasPorData(null, null, null);
		
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("===========================");
		}
	}

}
