package com.pharmacy.farmacia.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author user
 *
 */
@Entity
@Table (name = "tb_produto")
public class Produto {
	
    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	
	private @NotNull @Size (min = 5, max =15 )String titulo;
	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getId_categoria() {
		return id;
	}

	public void setId_categoria(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
