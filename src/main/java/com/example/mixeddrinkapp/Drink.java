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
	private Long drinkId;

	private String drinkName;

	private Long liquor1;

	private Long liquor2;

	private Long liquor3;

	private Long mixer1;

	private Long mixer2;

	private Long mixer3;

	private Long garnish1;

	private Long garnish2;

	private Long garnish3;

	@ManyToMany
	private Collection<Liquor> liquors;

	public Collection<Liquor> getLiquors() {

		return liquors;
	}

	public void setLiquors(Collection<Liquor> liquors) {
		this.liquors = liquors;
	}

	// default constructor
	public Drink() {
	}

	public Drink(String drinkName, Long liquor1, Long liquor2, Long liquor3, Long mixer1, Long mixer2, Long mixer3,
			Long garnish1, Long garnish2, Long garnish3) {
		this.drinkName = drinkName;
		this.liquor1 = liquor1;
		this.liquor2 = liquor2;
		this.liquor3 = liquor3;
		this.mixer1 = mixer1;
		this.mixer2 = mixer2;
		this.mixer3 = mixer3;
		this.garnish1 = garnish1;
		this.garnish2 = garnish2;
		this.garnish3 = garnish3;
	}

	public long getId() {
		return drinkId;
	}

	public String getName() {
		return drinkName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (drinkId ^ (drinkId >>> 32));
		result = prime * result + ((drinkName == null) ? 0 : drinkName.hashCode());
		result = prime * result + (int) (garnish1 ^ (garnish1 >>> 32));
		result = prime * result + (int) (garnish2 ^ (garnish2 >>> 32));
		result = prime * result + (int) (garnish3 ^ (garnish3 >>> 32));
		result = prime * result + (int) (liquor1 ^ (liquor1 >>> 32));
		result = prime * result + (int) (liquor2 ^ (liquor2 >>> 32));
		result = prime * result + (int) (liquor3 ^ (liquor3 >>> 32));
		result = prime * result + ((liquors == null) ? 0 : liquors.hashCode());
		result = prime * result + (int) (mixer1 ^ (mixer1 >>> 32));
		result = prime * result + (int) (mixer2 ^ (mixer2 >>> 32));
		result = prime * result + (int) (mixer3 ^ (mixer3 >>> 32));
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
		if (drinkId != other.drinkId)
			return false;
		if (drinkName == null) {
			if (other.drinkName != null)
				return false;
		} else if (!drinkName.equals(other.drinkName))
			return false;
		if (garnish1 != other.garnish1)
			return false;
		if (garnish2 != other.garnish2)
			return false;
		if (garnish3 != other.garnish3)
			return false;
		if (liquor1 != other.liquor1)
			return false;
		if (liquor2 != other.liquor2)
			return false;
		if (liquor3 != other.liquor3)
			return false;
		if (liquors == null) {
			if (other.liquors != null)
				return false;
		} else if (!liquors.equals(other.liquors))
			return false;
		if (mixer1 != other.mixer1)
			return false;
		if (mixer2 != other.mixer2)
			return false;
		if (mixer3 != other.mixer3)
			return false;
		return true;
	}

}