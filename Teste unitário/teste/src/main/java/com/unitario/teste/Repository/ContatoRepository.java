package com.unitario.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitario.teste.Models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
