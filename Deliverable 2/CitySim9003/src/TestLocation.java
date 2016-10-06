import static org.junit.Assert.*;

import org.junit.Test;

public class TestLocation {

	@Test
	//Test for setting location via setLocation() method.
	public void setLocationTest() {
		Location a = new Location("KappaPride");
		a.setLocation("Laboon's Class");
		String location = a.getLocation();
		assertEquals(location,"Laboon's Class");
	}
	
	@Test
	//Test for getting location via getLocation() method.
	public void getLocationTest() {
		Location a = new Location("/r/Kappa");
		assertEquals(a.getLocation(),"/r/Kappa");
	}

}
