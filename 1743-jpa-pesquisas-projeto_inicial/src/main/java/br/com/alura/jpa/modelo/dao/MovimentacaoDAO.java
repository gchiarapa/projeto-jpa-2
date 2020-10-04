package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDAO {

	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {

		// TODO chama uma query pelo nome(named query).
		TypedQuery<MediaComData> mediaQuery = em.createNamedQuery("mediaDiariaDasMovimentações", MediaComData.class);
		return mediaQuery.getResultList();

	}

	public BigDecimal getSomaDasMovimentações() {

		String jpql = "select sum(m.valor) from Movimentacao m";

		// TODO devolve um único resultado
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		return query.getSingleResult();

	}

	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer day, Integer month, Integer year) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);

		// TODO seta a classe de onde pega(from do select *)
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		//TODO cria um array de predicate
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (day != null) {
			//TODO day(m.data). Compara o dia q foi localizado no banco com o dia q foi passado no metodo
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), day);
			predicates.add(predicate);
		}
		if (month != null) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), month);
			predicates.add(predicate);
		}
		if (year != null) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), year);
			predicates.add(predicate);
		}
		
		
		query.where( (Predicate[]) predicates.toArray(new Predicate[0]) );

//		//TODO a função sum da query
//		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
//		query.select(sum);
//		
//		//TODO passa a query pro typedQuery
		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

		return typedQuery.getResultList();
	}

}
