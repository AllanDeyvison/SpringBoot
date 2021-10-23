package com.Loja.DeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Loja.DeGames.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByJogosContainingIgnoreCase(String jogos);

}
