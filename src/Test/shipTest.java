package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Game.Food_and_Med_Command;
import Game.InputSetupException;
import Game.characters_Command;
import Game.ship;

class shipTest {

	@Test
	public void get_parts_missingTest() {
		ship testPartsMissing = new ship();
		int result = testPartsMissing.get_parts_missing(5);
		assertEquals(3, result);
	}
	
	@Test
    public void get_parts_missingExceptionTest() {
		boolean thrown = false;
		ship testPartsMissing = new ship();
		try {
			int result = testPartsMissing.get_parts_missing(20);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void add_pilotsTest() {
		boolean thrown = false;
		ship testAddPilots = new ship();
		characters_Command pilot = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		try {
			testAddPilots.add_pilots(pilot);
			testAddPilots.add_pilots(pilot);
			testAddPilots.add_pilots(pilot);
			testAddPilots.add_pilots(pilot);
			testAddPilots.add_pilots(pilot);
			testAddPilots.add_pilots(pilot);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test 
	public void add_foodsTest () {
		boolean thrown = false;
		ship test_add_food = new ship();
		Food_and_Med_Command foodOr_medicalItem = new Food_and_Med_Command(0, 0, 0, 0);
		foodOr_medicalItem.item_price = 10;
		test_add_food.crew_money = -10;
		try {
			test_add_food.add_foods(foodOr_medicalItem);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void sleepTest_onCharacter () {
		boolean thrown = false;
		ship test_character_action_counts = new ship();
		characters_Command character = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		character.actionCount = -1;
		try {
			test_character_action_counts.sleep(character);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test 
	public void flyTest_onCharacter() {
		boolean thrown = false;
		ship test_character_fly = new ship();
		characters_Command char_flyer1 = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		characters_Command char_flyer2 = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		char_flyer1.actionCount = -1;
		char_flyer1.actionCount = -2;
		try { 
			test_character_fly.fly(char_flyer1, char_flyer2);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test 
	public void eatTestonCharacter () {
		boolean thrown = false;
		ship test_character_eating = new ship();
		characters_Command character = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		Food_and_Med_Command foodOr_medicalItem = new Food_and_Med_Command(0, 0, 0, 0);
		character.actionCount = -1;
		try {
			test_character_eating.eat(foodOr_medicalItem, character);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test 
	public void repair_shieldTest () {
		boolean thrown = false;
		ship repair_shield_action_counts = new ship();
		characters_Command character = new characters_Command(null, 0, 0, 0, 0, 0, 0, thrown, thrown);
		character.actionCount = -1;
		try {
			repair_shield_action_counts.repair_shield(character);
		} catch (InputSetupException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}
