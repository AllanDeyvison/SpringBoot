package com.Loja.DeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Loja.DeGames.models.Categoria;



public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
