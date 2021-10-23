package com.unitario.teste.Contatos;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unitario.teste.Models.Contato;
import com.unitario.teste.Repository.ContatoRepository;


@RunWith(SpringRunner.class)
@DataJpaTest 
 public class ContatosRepositoryIntegrationTest {

	private Contato contato;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Before
	public void start() {
		contato = new Contato("Gabriel", "011y", "9xxxxxxx9");
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComTelNulo() throws Exception {
		
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComDddNulo() throws Exception {
		
		
		contato.setDdd(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComNomeNulo() throws Exception {
		
		contato.setNome(null);
		contatoRepository.save(contato);
	}

}
