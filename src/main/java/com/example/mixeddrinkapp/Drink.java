package com.example.mixeddrinkapp;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Drink {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToMany
	private Collection<Liquor> liquors;

	@ManyToMany
	private Collection<Mixer> mixers;

	private String garnish;

//	default constructor
	public Drink() {
	}

	public Drink(String name, String mixers, String garnish, Liquor... liquors) {
		this.name = name;
		this.liquors = new HashSet<Liquor>(Arrays.asList(liquors));
		this.garnish = garnish;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Mixer> getMixers() {
		return mixers;
	}

	public String getGarnish() {
		return garnish;
	}

	public Collection<Liquor> getLiquors() {
		return liquors;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", mixers=" + mixers + ", garnish=" + garnish + ", liquors="
				+ liquors + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((garnish == null) ? 0 : garnish.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((liquors == null) ? 0 : liquors.hashCode());
		result = prime * result + ((mixers == null) ? 0 : mixers.hashCode());
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
		Drink other = (Drink) obj;
		if (garnish == null) {
			if (other.garnish != null)
				return false;
		} else if (!garnish.equals(other.garnish))
			return false;
		if (id != other.id)
			return false;
		if (liquors == null) {
			if (other.liquors != null)
				return false;
		} else if (!liquors.equals(other.liquors))
			return false;
		if (mixers == null) {
			if (other.mixers != null)
				return false;
		} else if (!mixers.equals(other.mixers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}