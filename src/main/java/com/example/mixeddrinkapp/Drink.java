package com.example.mixeddrinkapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Drink {

	@Id
	@GeneratedValue
	private Long id;
	private String drinkName;

	@ManyToMany
	private Collection<Liquor> liquors;

//	default constructor
	public Drink() {
	}

	public Drink(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
			String mixer3, String garnish1, String garnish2, String garnish3) {
		this.drinkName = drinkName;
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return drinkName;
	}

	public Collection<Liquor> getLiquors() {

		return liquors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinkName == null) ? 0 : drinkName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((liquors == null) ? 0 : liquors.hashCode());
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
		Drink other = (Drink) obj;
		if (drinkName == null) {
			if (other.drinkName != null)
				return false;
		} else if (!drinkName.equals(other.drinkName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (liquors == null) {
			if (other.liquors != null)
				return false;
		} else if (!liquors.equals(other.liquors))
			return false;
		return true;
	}

}
