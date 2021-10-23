package com.Loja.DeGames.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class Produto {

	 private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	 
	 private @NotNull String jogos;
	 
	 private @NotNull String console;
	 
	 private @NotNull double preco;
	 
	 @ManyToOne(fetch =FetchType.EAGER)
	 @JoinColumn (name = "categoria_id")
	 @JsonIgnoreProperties ("produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJogos() {
		return jogos;
	}

	public void setJogos(String jogos) {
		this.jogos = jogos;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	 
	
	
}
