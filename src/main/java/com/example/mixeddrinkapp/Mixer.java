package com.example.mixeddrinkapp;

import java.util.HashSet;
import java.util.Set;
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
	private Set<Recipe> recipes;

//	default constructor
	public Mixer() {
	}

	public Mixer(String name, boolean inStock) {
		this.name = name;
		this.inStock = inStock;
		recipes = new HashSet<>();
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

	public Set<Recipe> getDrinks() {
		
		return recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
