package com.example.mixeddrinkapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAMappingTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private LiquorRepository liquorRepo;

	@Autowired
	private MixerRepository mixerRepo;

	@Autowired
	private GarnishRepository garnishRepo;

	@Autowired
	private RecipeRepository recipeRepo;

	@Test
	public void drinksShouldHaveLiquorsMixersAndGarnishes() {
		Liquor testLiquor1 = new Liquor("liquor name", "flavor", true);
		testLiquor1 = liquorRepo.save(testLiquor1);
		Liquor testLiquor2 = new Liquor("liquor name 2", "flavor", true);
		testLiquor2 = liquorRepo.save(testLiquor2);

		Mixer testMixer1 = new Mixer("mixer name", true);
		testMixer1 = mixerRepo.save(testMixer1);
		Mixer testMixer2 = new Mixer("mixer name 2", true);
		testMixer2 = mixerRepo.save(testMixer2);

		Garnish testGarnish = new Garnish("garnish name", true);
		testGarnish = garnishRepo.save(testGarnish);
		Garnish testGarnish2 = new Garnish("garnish name 2", true);
		testGarnish2 = garnishRepo.save(testGarnish2);

		Recipe testDrink1 = new Recipe("drink name", null, null);
		testDrink1.addLiquor(testLiquor1);
		testDrink1.addLiquor(testLiquor2);
		testDrink1.addMixer(testMixer1);
		recipeRepo.save(testDrink1);

		Recipe testDrink2 = new Recipe("drink name 2", null, null);
		testDrink2.addLiquor(testLiquor1);
		testDrink2.addMixer(testMixer1);
		testDrink2.addMixer(testMixer2);
		recipeRepo.save(testDrink2);

		entityManager.flush();
		entityManager.clear();
		
		Liquor retrievedLiquor = liquorRepo.findById(testLiquor1.getId()).get();
		Liquor retrievedLiquor2 = liquorRepo.findById(testLiquor2.getId()).get();
		
		Mixer retrievedMixer = mixerRepo.findById(testMixer1.getId()).get();
		Mixer retrievedMixer2 = mixerRepo.findById(testMixer2.getId()).get();
		
		assertThat(retrievedLiquor.getDrinks()).containsExactlyInAnyOrder(testDrink1, testDrink2);
		assertThat(retrievedLiquor2.getDrinks()).containsExactlyInAnyOrder(testDrink1);
		
		assertThat(retrievedMixer.getDrinks()).containsExactlyInAnyOrder(testDrink1, testDrink2);
		assertThat(retrievedMixer2.getDrinks()).containsExactlyInAnyOrder(testDrink2);
	}
	
	@Test
	public void searchByLiquorNameAndMixerName() {
		Liquor testLiquor = new Liquor("test liquor", "flavor", true);
		liquorRepo.save(testLiquor);
		Liquor testLiquor2 = new Liquor("test liquor 2", "flavor", true);
		liquorRepo.save(testLiquor2);
		
		Mixer testMixer = new Mixer("test mixer", true);
		mixerRepo.save(testMixer);
		Mixer testMixer2 = new Mixer("test mixer 2", true);
		mixerRepo.save(testMixer2);
		
		Recipe testDrink = new Recipe("test drink", null, null);
		testDrink.addLiquor(testLiquor);
		testDrink.addLiquor(testLiquor2);
		testDrink.addMixer(testMixer);
		recipeRepo.save(testDrink);
		
		Recipe testDrink2 = new Recipe("test drink 2", "", "");
		testDrink2.addLiquor(testLiquor);
		testDrink2.addMixer(testMixer);
		testDrink2.addMixer(testMixer2);
		recipeRepo.save(testDrink2);
		
		entityManager.flush();
		entityManager.clear();
		
		Set<Recipe> retrievedDrinks = recipeRepo.findAllByLiquorsContainsAndMixersContains(testLiquor, testMixer);
		assertThat(retrievedDrinks).containsExactlyInAnyOrder(testDrink, testDrink2);
	}

}
