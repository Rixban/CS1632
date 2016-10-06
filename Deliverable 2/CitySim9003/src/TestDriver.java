import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestDriver {
	//Set mock classes
	@Mock
	Random mockRandom = Mockito.mock(Random.class);
	Road mockRoad = Mockito.mock(Road.class);
	Location mockLoc = Mockito.mock(Location.class);
	City mockCity = Mockito.mock(City.class);

	
	
	
	@Test
	//Creates an array list to read from
	//Uses the mock random class to always get 0
	//Fakes the getNextDestination() method used to get
	//An ArrayList<Road> object with just a created road list.
	//Then grabs the only element of that list and asserts that it's equal to the object.
	//Stubs all the methods to ensure we get the correct road everytime
	public void driveAroundTest() {
		Driver driver = new Driver(mockCity, mockLoc);
		ArrayList<Road> list = new ArrayList<>();
		Road road = new Road("Kappa","Kappa St","Bill's Office");
		list.add(road);
		Mockito.when(mockCity.getNextDestination(mockLoc.getLocation())).thenReturn(list);
		Mockito.when(mockRandom.nextInt()).thenReturn(0);
		assertEquals(driver.driveAround(mockRandom),road);
	}
	
	@Test(expected=Exception.class)
	//Sometimes it is possible to null out if there is no list available.
	//Uses mock random class to always get 0
	//Fakes the getNextDestination to ensure null
	//Stubs everything for assumed behavior.
	public void driveAroundFailTest() {
		Driver driver = new Driver(mockCity, mockLoc);
		Mockito.when(mockCity.getNextDestination(mockLoc.getLocation())).thenReturn(null);
		Mockito.when(mockRandom.nextInt()).thenReturn(0);
		driver.driveAround(mockRandom);
	}
	
	@Test
	//Tests the getter for location
	//Mock's city since it's never needed.
	//Asserts original location set is correct
	public void getLocationTest() {
		Location a = new Location("porque");
		Driver driver = new Driver(mockCity, a);
		assertEquals(driver.getLocation(),"porque");	
	}
	
	@Test
	//Test the setter for location
	//Sets a location and changes it, asserts it's equal.
	public void setLocationTest(){
		Location a = new Location("porque");
		Driver driver = new Driver(mockCity, a);
		driver.setLocation("Laboon's Office");
		assertEquals(driver.getLocation(),"Laboon's Office");
		
	}

}
