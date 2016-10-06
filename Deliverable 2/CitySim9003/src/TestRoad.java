import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoad {
//Class is all getter/setters, not much to test.

	@Test
	//Creates road, changes the start Location, then checks if equal
	public void setStartTest() {
		Road road = new Road("Prison","Trump Manor","White House");
		road.setStart("Laboon's Office");
		assertEquals(road.getStart(),"Laboon's Office");
	}

	@Test
	//Creates road, changes the street Location, then checks if equal
	public void setStreetTest(){
		Road road = new Road("Prison","Trump Manor","White House");
		road.setStreet("Laboon's Office");
		assertEquals(road.getStreet(), "Laboon's Office");
	}
	
	@Test
	//Creates road, changes the end Location, then checks if equal
	public void setEndTest(){
		Road road = new Road("Prison","Trump Manor","White House");
		road.setEnd("Laboon's Office");
		assertEquals(road.getEnd(),"Laboon's Office");
	}
	
	@Test
	//Creates road, gets start location and checks if equal
	public void getStartTest(){
		Road road = new Road("Prison","Trump Manor","White House");
		assertEquals(road.getStart(),"Prison");
	}
	
	@Test
	//Creates road, gets street location and checks if equal
	public void getStreetTest(){
		Road road = new Road("Prison","Trump Manor","White House");
		assertEquals(road.getStreet(),"Trump Manor");
	}
	
	@Test
	//Creates road, gets end location and checks if equal
	public void getEndTest(){
		Road road = new Road("Prison","Trump Manor","White House");
		assertEquals(road.getEnd(),"White House");
	}
}
