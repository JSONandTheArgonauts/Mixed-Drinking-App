package com.example.mixeddrinkapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private RecipeRepository drinkRepo;

	@Resource
	private LiquorRepository liquorRepo;

	@Resource
	private MixerRepository mixerRepo;

	@Resource
	private GarnishRepository garnishRepo;

	@Test
	public void shouldSaveAndLoadMixer() {
		Mixer mixer = mixerRepo.save(new Mixer("mixer", true));
		Long mixerId = mixer.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Mixer> result = mixerRepo.findById(mixerId);
		mixer = result.get();
		assertThat(mixer.getName(), is("mixer"));
	}

	@Test
	public void shouldGenerateMixerId() {
		Mixer mixer = mixerRepo.save(new Mixer("mixer", true));
		Long mixerId = mixer.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(mixerId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadLiquors() {
		Liquor liquor = liquorRepo.save(new Liquor("liquor", "flavor", true));
		Long liquorId = liquor.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Liquor> result = liquorRepo.findById(liquorId);
		liquor = result.get();
		assertThat(liquor.getName(), is("liquor"));
	}

	@Test
	public void shouldSaveAndLoadGarnishes() {
		Garnish garnish = garnishRepo.save(new Garnish("garnish", true));
		Long garnishId = garnish.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Garnish> result = garnishRepo.findById(garnishId);
		garnish = result.get();
		assertThat(garnish.getName(), is("garnish"));
	}

	@Test
	public void shouldSaveAndLoadDrinks() {
		Recipe drink = new Recipe("drink", null, null, null, null, null, null, null, null, null);
		drink = drinkRepo.save(drink);
		Long drinkId = drink.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Recipe> result = drinkRepo.findById(drinkId);
		drink = result.get();
		assertThat(drink.getName(), is("drink"));
	}

	@Test
	public void shouldEstablishDrinktoLiquorRelationship() {
		Liquor liquor = liquorRepo.save(new Liquor("liquor", "flavor", true));
		Liquor anotherLiquor = liquorRepo.save(new Liquor("anotherLiquor", "flavor", true));

		Recipe recipe = new Recipe("name", "liquor", "anotherLiquor", "", "", "", "", "", "", "");
		recipe = drinkRepo.save(recipe);
		Long recipeId = recipe.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Recipe> result = drinkRepo.findById(recipeId);
		recipe = result.get();

		assertThat(recipe.getLiquors(), containsInAnyOrder(liquor, anotherLiquor));
	}

//	@Test
//	public void shouldFindDrinksForLiquors() {
//		Liquor liquor = liquorRepo.save(new Liquor("liquor", true));
//
//		Drink drink = new Drink("drink", "mixer", "garnish", null, null, null, null, null, null, null);
//		Drink anotherDrink = drinkRepo.save(new Drink("anotherDrink", "mixer", "garnish", null, null, null, null, null, null, null));
//
//		entityManager.flush();
//		Collection<Drink> drinksForLiquors = drinkRepo.findByLiquorsContains(liquor);
//
//		assertThat(drinksForLiquors, contains(drink, anotherDrink));
//		entityManager.clear();
//
//	}

//	@Test
//	public void shouldSaveMixerToDrinkRelationship() {
//		Drink drink = new Drink("drink", "mixer", "garnish", null, null, null, null, null, null, null);
//		Mixer mixer = new Mixer("mixer", true);
//		Mixer anotherMixer = new Mixer("anotherMixer", true);
//
//		drinkRepo.save(drink);
//		mixerRepo.save(mixer);
//		mixerRepo.save(anotherMixer);
//
//		long drinkId = drink.getId();
//		
//		entityManager.flush();
//		Optional<Drink> result = drinkRepo.findById(drinkId);
//		drink = result.get();
//		assertThat(drink.getMixers(), contains(mixer, anotherMixer));
//		entityManager.clear();
//
//	}

}
