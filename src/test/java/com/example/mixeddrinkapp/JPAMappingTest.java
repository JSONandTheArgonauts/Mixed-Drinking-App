package com.example.mixeddrinkapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;
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
	private DrinkRepository drinkRepo;

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
		Liquor liquor = liquorRepo.save(new Liquor("liquor", true));
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
		Drink drink = new Drink("drink", "mixer", "garnish");
		drink = drinkRepo.save(drink);
		long drinkId = drink.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Drink> result = drinkRepo.findById(drinkId);
		drink = result.get();
		assertThat(drink.getName(), is("drink"));
	}
	
	@Test
	public void shouldEstablishDrinktoLiquorRelationship() {
		Liquor liquor = liquorRepo.save(new Liquor("liquor", true));
		Liquor anotherLiquor = liquorRepo.save(new Liquor("anotherLiquor", true));
		
		Drink drink = new Drink("name", "mixer", "garnish", liquor, anotherLiquor);
		drink = drinkRepo.save(drink);
		long drinkId = drink.getId();
		
		Optional<Drink> result = drinkRepo.findById(drinkId);
		drink = result.get();
		
		assertThat(drink.getLiquors(), containsInAnyOrder(liquor, anotherLiquor));
	}
	
//	@Test
//	public void shouldFindDrinksForLiquors() {
//		Liquor liquor = liquorRepo.save(new Liquor("liquor", true));
//		
//		Drink drink = drinkRepo.save(new Drink("drink", "mixer", "garnish", liquor));
//		Drink anotherDrink = drinkRepo.save(new Drink("anotherDrink", "mixer", "garnish", liquor));
//		
//		entityManager.flush();
//		entityManager.clear();
//		
//		Collection<Drink> drinksForLiquors = drinkRepo.findByLiquorContains(liquor);
//		
//		assertThat(drinksForLiquors, containsInAnyOrder(drink, anotherDrink));
//	}

}
