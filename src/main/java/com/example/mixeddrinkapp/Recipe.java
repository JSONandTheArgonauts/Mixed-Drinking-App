package com.example.mixeddrinkapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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






//Old Code Below. Probably bad.

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//
//@Entity
//public class Recipe {
//
//	@Id
//	@GeneratedValue
//	private Long id;
//	private String drinkName;
//	private String liquor1;
//	private String liquor2;
//	private String liquor3;
//	private String mixer1;
//	private String mixer2;
//	private String mixer3;
//	private String garnish1;
//	private String garnish2;
//	private String garnish3;
//	private String image;
//	@Lob
//	private String instructions;
//
////	@ManyToMany
////	private Collection<Recipe> liquors;
//
//	public Recipe() {
//	}
//
//	public Recipe(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
//			String mixer3, String garnish1, String garnish2, String garnish3, String image, String instructions) {
//		this.drinkName = drinkName;
//		this.liquor1 = liquor1;
//		this.liquor2 = liquor2;
//		this.liquor3 = liquor3;
//		this.mixer1 = mixer1;
//		this.mixer2 = mixer2;
//		this.mixer3 = mixer3;
//		this.garnish1 = garnish1;
//		this.garnish2 = garnish2;
//		this.garnish3 = garnish3;
//		this.image = image;
//		this.instructions = instructions;
//	}
//
//	public Long getId() {
//
//		return id;
//	}
//	
//	public String getName() {
//		return drinkName;
//	}
//
//	public String getLiquor1() {
//		return liquor1;
//	}
//
//	public String getLiquor2() {
//		return liquor2;
//	}
//
//	public String getLiquor3() {
//		return liquor3;
//	}
//
//	public String getMixer1() {
//		return mixer1;
//	}
//
//	public String getMixer2() {
//		return mixer2;
//	}
//
//	public String getMixer3() {
//		return mixer3;
//	}
//
//	public String getGarnish1() {
//		return garnish1;
//	}
//
//	public String getGarnish2() {
//		return garnish2;
//	}
//
//	public String getGarnish3() {
//		return garnish3;
//	}
//	
//	public String getImage() {
//		return image;		
//	}
//
//	public String getInstructions() {
//		return instructions;
//	}
//
//
//
////	public Collection<Recipe> getLiquors() {
////
////		return liquors;
////	}
//
//}
