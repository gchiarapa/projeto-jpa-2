package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TesteMediaDiariaDasMovimentacoes {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoesGroupBy = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoesGroupBy) {
			System.out.println("A média das movimentações das movimentações do dia: "+ resultado.getDay() + "/" +resultado.getMonth() + " é " + resultado.getValor());
		}
		
		
	}

}
