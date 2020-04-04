package com.example.mixeddrinkapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Mixer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private boolean inStock;

	@ManyToMany(mappedBy = "mixers")
	private Collection<Drink> drinks;

	public Collection<Drink> getDrinks() {
		return drinks;
	}

//	default constructor
	public Mixer() {
	}

	public Mixer(String name, boolean inStock) {
		this.name = name;
		this.inStock = inStock;
	}

	public String getName() {

		return name;
	}

	public boolean inStock() {

		return inStock;
	}

	public Long getId() {

		return id;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (inStock ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Mixer other = (Mixer) obj;
		if (drinks == null) {
			if (other.drinks != null)
				return false;
		} else if (!drinks.equals(other.drinks))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inStock != other.inStock)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
