package com.produto.produto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@JsonFormat(pattern="yyyyMMdd")
	@Column(name="data_do_registro")    
	private Date data;
	
	@Column(name="detalhes")
	private String detalhes;
	
	

	public Produto() {
		super();
		
	}

	public Produto(Long id, String nome, Date data, String detalhes) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.detalhes = detalhes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}	
	
	

}
