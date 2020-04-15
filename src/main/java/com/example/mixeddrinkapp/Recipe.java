package com.example.mixeddrinkapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String drinkName;
	private String image;
	@Lob
	private String instructions;
	@ManyToMany
	private Set<Liquor> liquors;
	@ManyToMany
	private Set<Mixer> mixers;

	public Recipe() {
	}

	public Recipe(String drinkName, String image, String instructions) {
		this.drinkName = drinkName;
		this.image = image;
		this.instructions = instructions;
		liquors = new HashSet<>();
		mixers = new HashSet<>();
	}

	public Long getId() {

		return id;
	}

	public String getName() {
		return drinkName;
	}

	public String getImage() {
		return image;
	}

	public String getInstructions() {
		return instructions;
	}

	public void addLiquor(Liquor liquor) {
		liquors.add(liquor);
	}

	public void addMixer(Mixer mixer) {
		mixers.add(mixer);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinkName == null) ? 0 : drinkName.hashCode());
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
		Recipe other = (Recipe) obj;
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
		return true;
	}

}
