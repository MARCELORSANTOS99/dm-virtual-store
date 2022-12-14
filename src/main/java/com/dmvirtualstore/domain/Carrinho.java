package com.dmvirtualstore.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrinho implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	

	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	
		
	@OneToMany(mappedBy="id.carrinho")
	private Set<Carrinhoitem> items = new HashSet<>();
	
	private	Double frete;
	

	public Carrinho() {

	}
	
	public Carrinho(Integer id, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}
	

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Set<Carrinhoitem> getItems() {
		return items;
	}

	public void setItems(Set<Carrinhoitem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
