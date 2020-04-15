package com.example.mixeddrinkapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RecipesPopulator implements CommandLineRunner {
	
	@Resource
	private RecipeRepository recipeRepo;

	//Liquors field
	private Liquor vodka;
	private Liquor burbon;
	private Liquor whiteRum;
	private Liquor gin;
	private Liquor coffeeLiqueur;
	//Mixers field
	private	Mixer orangeJuice;
	private Mixer bitters;
	private Mixer coconutCream;
	private Mixer pinappleJuice;
	private Mixer tonicWater;
	private Mixer halfAndHalf;
	//Recipe Liquor Mapping
	public Set<Liquor> liquorsScrewdriver = new HashSet<>(Arrays.asList(vodka));
	public Set<Liquor> liquorsOldFasioned = new HashSet<>(Arrays.asList(burbon));
	public Set<Liquor> liquorsColada = new HashSet<>(Arrays.asList(whiteRum));
	public Set<Liquor> liquorsGT = new HashSet<>(Arrays.asList(gin));
	public Set<Liquor> liquorsWhiteRussian = new HashSet<>(Arrays.asList(vodka, coffeeLiqueur));
	//Recipe Mixer Mapping
	public Set<Mixer> mixersScrewdriver = new HashSet<>(Arrays.asList(orangeJuice));
	public Set<Mixer> mixersOldFasioned = new HashSet<>(Arrays.asList(bitters));
	public Set<Mixer> mixersColada = new HashSet<>(Arrays.asList(coconutCream, pinappleJuice));
	public Set<Mixer> mixersGT = new HashSet<>(Arrays.asList(tonicWater));
	public Set<Mixer> mixersWhiteRussian = new HashSet<>(Arrays.asList(halfAndHalf));
	
	@Override
	public void run(String... args) throws Exception {
		
		Recipe screwdriver = new Recipe(liquorsScrewdriver, mixersScrewdriver, "ScrewDriver", "/images/screwdriver.jpg", "Add 1 1/2 oz of Vodka in a highball glass over ice, then top off with orange juice. Garnish orange slice is optional.");
		screwdriver = recipeRepo.save(screwdriver);
		
		Recipe oldFasioned = new Recipe(liquorsOldFasioned, mixersOldFasioned, "Old Fasioned", "/images/oldfasioned.jpg", "Place the sugar cube in an Old Fashioned glass. \n" + 
				"Wet it down with Angostura bitters and a short splash of club soda.\n" + 
				"Crush the sugar with a wooden muddler (or spoon if you don't have one, then rotate the glass so that the sugar grains and bitters give it a lining. \n" + 
				"Add a large ice cube. Pour in the whiskey. \n" + 
				"Garnish with an orange peel and cherry, and serve with a stirring rod if you're so inclined.");
		oldFasioned = recipeRepo.save(oldFasioned);
		
		Recipe pinaColada = new Recipe(liquorsColada, mixersColada, "Piña Colada", "/images/pinacolada.jpg", "Mix 3oz pineapple juice, 1oz white rum, and 1oz coconut cream into crushed ice. \n" +
				"Alternitavely a blender can be used, mix until smooth. Pour into a chilled glass and garnish with a slice of pinapple and a cherry");
		pinaColada = recipeRepo.save(pinaColada);
		
		Recipe ginAndTonic = new Recipe(liquorsGT, mixersGT, "Gin and Tonic", "/images/ginandtonic.jpg", "Take 1 to 3 parts gin (to taste), then 3 parts tonic water and pour over ice in either a rocks or highball glass. \n" + 
				"Garnish with a slice of lime.");
		ginAndTonic = recipeRepo.save(ginAndTonic);
		
		Recipe whiteRussian = new Recipe(liquorsWhiteRussian, mixersWhiteRussian, "White Russian", "/images/whiterussian.jpg", "Pour 2/3oz coffee liqueur into an Old Fashioned glass filled with ice, then add 1 and 2/3oz vodka into \n" + 
				"the glass, then fill the rest with half and half and stil slowly");
		whiteRussian = recipeRepo.save(whiteRussian);
//		Recipe tomCollins = new Recipe("Tom Collins", "Gin", "", "", "Soda Water", "Lemon Juice", "", "Lemon Slice", "", "", "/images/tomcollins.jpg", "Fill a highball glass with ice. Then mix 1oz lemon juice, 1 1/2oz gin, 2oz soda water, and 1/2oz sugar \n" + 
//				"syrup in the glass. Garnish with cherry and lemon slice.");
//		tomCollins = recipeRepo.save(tomCollins);
//		Recipe martini = new Recipe("Martini", "Gin", "Vermouth", "", "", "", "", "Olive", "", "", "/images/martini.jpg", "Pour 1/2oz dry vermouth and 3oz gin into a cocktail mixer with ice cubes. Stir, or for those who wear tuxes and say their last name \n" + 
//				"before giving their full name, shake well. Strain into chilled martini glass and garnish with olive.");
//		martini = recipeRepo.save(martini);
//		Recipe cosmopolitan = new Recipe("Cosmopolitan", "Vodka", "Triple Sec", "", "Cranberry Juice", "Lime Juice", "", "Lime Slice", "", "", "/images/cosmopolitan.jpg", "Add 1/2oz lime juice, 1oz cranberry juice, 1/2oz triple sec, and 1 1/2oz vodka in a \n" + 
//				"cocktail mixer with ice. Shake well and strain twice into a large chilled cocktail glass. Garnish with lime slice.");
//		cosmopolitan = recipeRepo.save(cosmopolitan);
//		Recipe sidecar = new Recipe("Sidecar", "Brandy", "Triple Sec", "", "Lemon Juice", "", "", "Lemon Slice", "", "", "/images/sidecar.jpg", "Pour 2oz brandy, 3/4 ounce triple sec, and 3/4oz lemon juice into a cocktail mixer. Shake well and strain into \n" +
//				"a cocktail glass. Garnish with lemon slice.");
//		sidecar = recipeRepo.save(sidecar);
//		Recipe pinaColada = new Recipe("Piña Colada", "White Rum", "", "", "Coconut Cream", "Pinapple Juice", "", "Pinapple Slice", "Cherry", "", "/images/pinacolada.jpg", "Mix 3oz pineapple juice, 1oz white rum, and 1oz coconut cream into crushed ice. \n" +
//				"Alternitavely a blender can be used, mix until smooth. Pour into a chilled glass and garnish with a slice of pinapple and a cherry");
//		pinaColada = recipeRepo.save(pinaColada);
//		Recipe bloodyMary = new Recipe("Bloody Mary", "Vodka", "", "", "Tomato Juice", "Hot Sauce", "Worcestershire Sauce", "Celery", "Salt", "Pepper", "/images/bloodymary.jpg", "Add dashes of worcestershire sauce, hot sauce (typically tobasco but falls \n" +
//				"to how you can handle the heat), salt and pepper into a a highball glass filled with ice. Then pour 1 1/2oz vodka and top off with tomato juice, stir gently and garnish with celery stalk.");
//		bloodyMary = recipeRepo.save(bloodyMary);
//		Recipe manhattan = new Recipe("Manhattan", "Rye Whisky", "Vermouth", "", "Angostura bitters", "", "", "Cherry", "", "", "/images/manhattan.jpg", "Pour 2oz rye whisky, 3/4oz red vermouth, a dash of Angostura bitters, and cherry into a cocktail mixer \n" +
//		"with ice and stir. Strain into a chilled cocktail glass.");
//		manhattan = recipeRepo.save(manhattan);
	}

}
