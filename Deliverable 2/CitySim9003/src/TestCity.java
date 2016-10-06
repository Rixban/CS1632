import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestCity {
	@Mock
	Location mockLoc = Mockito.mock(Location.class);
	Road mockRoad = Mockito.mock(Road.class);
	Random mockRandom = Mockito.mock(Random.class);
	@SuppressWarnings("unchecked")
	ArrayList<Road> mockList = Mockito.mock(ArrayList.class);
	
	@Test
	//Adds a road
	//Test to make sure that the location is added by an accurate count
	public void addLocationTest() {
		City c = new City();
		c.addLocation(mockLoc);
		assertEquals(c.getNumberOfLocations(),1);
	}
	
	@Test
	//Adds a location twice
	//Tests the avoidance of adding the same location twice
	//Which messes with true rng.
	public void addMultipleSameLocationTest(){
		City c = new City();
		c.addLocation(mockLoc);
		c.addLocation(mockLoc);
		assertEquals(c.getNumberOfLocations(),1);
	}
	
	@Test
	//Adds a road
	//Test to make sure that the road is added by an accurate count
	public void addRoadTest(){
		City c = new City();
		c.addRoad(mockRoad);
		assertEquals(c.getNumberOfRoads(),1);
		
	}
	
	@Test
	//Adds the same road twice
	//Tests the avoidance of adding the same road twice
	//Which messes with true rng.
	public void addMultipleSameRoadTest(){
		City c = new City();
		c.addRoad(mockRoad);
		c.addRoad(mockRoad);
		assertEquals(c.getNumberOfRoads(),1);
	}
	
	@Test
	//Adds a location, then attempts to check if the location already exists
	public void locationExistsTest(){
		City c = new City();
		c.addLocation(mockLoc);
		assertTrue(c.locationExists(mockLoc));
	}
	
	@Test
	//Doesn't add any location, then checks if location exists
	public void locationDoesntExistTest(){
		City c = new City();
		assertFalse(c.locationExists(mockLoc));
	}
	
	@Test
	//Adds a road, then attempts to check if road exists
	public void roadExistsTest(){
		City c = new City();
		c.addRoad(mockRoad);
		assertTrue(c.roadExists(mockRoad));
	}
	
	@Test
	//Doesn't add any roads, then checks if roads exist
	public void roadDoesntExistTest(){
		City c = new City();
		assertFalse(c.roadExists(mockRoad));
	}
	
	@Test
	//Adds two road, then checks to see how many roads exist.
	public void getNumberOfRoadsTest(){
		City c = new City();
		Road r1 = new Road ("Kappa", "KappaPride","KappaClaus");
		c.addRoad(mockRoad);
		c.addRoad(r1);
		assertEquals(c.getNumberOfRoads(),2);
	}
	
	@Test
	//Adds two locations, then checks to see how many locations exist
	public void getNumberOfLocationsTest(){
		City c = new City();
		Location l1 = new Location("Kappa");
		c.addLocation(l1);
		c.addLocation(mockLoc);
		assertEquals(c.getNumberOfLocations(),2);
	}
	
	@Test
	//Adds a mock road
	//Stubs the method getStart to always return the only road
	//Checks to assert lists are equal
	public void getNextDestinationTest(){
		City c = new City();
		c.addRoad(mockRoad);
		ArrayList<Road> list = new ArrayList<>();
		list.add(mockRoad);
		Mockito.when(mockRoad.getStart()).thenReturn("Kappa");
		assertEquals(c.getNextDestination("Kappa"),list);
	}
	
	@Test
	//Adds two locations to chance at failing
	//Stubs Random.nextInt to always return 0
	//Checks if first location is equal
	public void getRandomStartTest(){
		City c = new City();
		Location l1 = new Location("Kappa");
		Location l2 = new Location("Keepo");
		c.addLocation(l1);
		c.addLocation(l2);
		Mockito.when(mockRandom.nextInt()).thenReturn(0);
		assertEquals(c.getRandomStart(mockRandom),"Kappa");
	}

}
