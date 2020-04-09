package com.example.mixeddrinkapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Liquor {

	@Id
	@GeneratedValue
	private Long liquorId;

	private String name;
	private String flavor;
	private boolean inStock;

	public Liquor(String name, String flavor, boolean inStock) {
		this.name = name;
		this.flavor = flavor;
		this.inStock = inStock;
	}

//	@ManyToMany(mappedBy = "liquors")
//	private Collection<Drink> drinks;
//
//	public Collection<Drink> getDrinks() {
//		return drinks;
//	}
//
//	public void setDrinks(Collection<Drink> drinks) {
//		this.drinks = drinks;
//	}

	// default constructor
	public Liquor() {
	}

	public String getName() {

		return name;
	}

	public String getFlavor() {

		return flavor;
	}

	public boolean getInStock() {

		return inStock;
	}

	public Long getId() {

		return liquorId;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
//		result = prime * result + (inStock ? 1231 : 1237);
//		result = prime * result + ((liquorId == null) ? 0 : liquorId.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Liquor other = (Liquor) obj;
//		if (drinks == null) {
//			if (other.drinks != null)
//				return false;
//		} else if (!drinks.equals(other.drinks))
//			return false;
//		if (inStock != other.inStock)
//			return false;
//		if (liquorId == null) {
//			if (other.liquorId != null)
//				return false;
//		} else if (!liquorId.equals(other.liquorId))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

}
