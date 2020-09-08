package br.com.caelum;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Component
public class CriadorDeProdutos {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private JpaTransactionManager transactionManager;
	
	@PostConstruct
	public void init() {
		TransactionTemplate template = new TransactionTemplate(transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				Loja casaDoCodigo = new Loja();
				casaDoCodigo.setNome("Casa do Codigo");
				
				em.persist(casaDoCodigo);
				//\\\w
				Loja musicalAlegre = new Loja();
				musicalAlegre.setNome("Musical Alegre");
				
				em.persist(musicalAlegre);
				
				Categoria tecnologia = new Categoria("Tecnologia");
				em.persist(tecnologia);
				
				Categoria musica = new Categoria("Musica");
				em.persist(musica);
				
				Produto cursoDeViolao = new Produto();
				cursoDeViolao.setNome("Curso de Violão");
				cursoDeViolao.setLoja(musicalAlegre);
				cursoDeViolao.setPreco(49.0);
				cursoDeViolao.setDescricao("Estude com os melhores professores e aprenda no seu ritmo, sem sair de casa.");
				cursoDeViolao.adicionarCategorias(tecnologia, musica);
				cursoDeViolao.setLinkDaFoto("https://4.bp.blogspot.com/-nJWfpRWOB1c/XGG2iQBA6HI/AAAAAAABQfc/gxWdHnx27bsccyIx4lM2WMUhXHtGPRpUACLcBGAs/s1600/Screenshot%2B2019-02-11%2B15.52.53.png");
				
				em.persist(cursoDeViolao);
				
				Produto livroDeArquitetura = new Produto();
				livroDeArquitetura.setNome("Introdução a Arquitetura Java e Design de projetos com Java");
				livroDeArquitetura.setLoja(casaDoCodigo);
				livroDeArquitetura.setPreco(30.0);
				livroDeArquitetura.adicionarCategorias(tecnologia);
				livroDeArquitetura.setDescricao("Neste livro, os autores, conhecidos especialistas da "
											   + " Área, apresentam muitos tópicos que aparecem com frequência"
											   + " na plataforma Java, incluindo desde modelagem e design das "
											   + "classes, até detalhes importantes das tecnologias mais utilizadas."
											   + "  Sempre com uma visão técnica e prática capaz de elucidar muitas "
											   + "questões enfrentadas tanto pelo profissional iniciante quanto por "
											   + "aquele que está adquirindo mais experiência na plataforma.");
				
				livroDeArquitetura.setLinkDaFoto("https://www.alura.com.br/especial/assets/arquitetura/arquitetura-java.png");
				
				em.persist(livroDeArquitetura);
				
				Produto livroDeSpring = new Produto();
				livroDeSpring.setNome("Vire o jogo com Spring Framework");
				livroDeSpring.setLoja(casaDoCodigo);
				livroDeSpring.setPreco(30.0);
				livroDeSpring.adicionarCategorias(tecnologia);
				livroDeSpring.setDescricao("Criado para simplificar o desenvolvimento de aplicações Java, "
						+ "o Spring se tornou um dos frameworks de mais destaque dentro desse grande ambiente.  "
						+ "Aprenda muito mais que o básico do Spring, desde o tradicional Container de Inversão "
						+ "de Controle e Injeção de Dependências, passando pelos robustos módulos de segurança, "
						+ "transações, programação orientada a aspectos e também o fantástico módulo MVC, o SpringMVC.");
				
				livroDeSpring.setLinkDaFoto("http://cdn.shopify.com/s/files/1/0155/7645/products/spring-framework-featured_large.png?v=1411567960");
				
				em.persist(livroDeSpring);
				
			}
		});		
	}
	
}
