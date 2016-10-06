import java.util.*;

public class Driver {
	private City city;
	private Location currentLocation;
	public Driver(City c, Location l){
		this.city = c;
		this.currentLocation = l;
	}
	
	public Road driveAround(Random random){
		ArrayList<Road> legitRoads = city.getNextDestination(currentLocation.getLocation());
		Road r = legitRoads.get(random.nextInt(legitRoads.size())); 
		this.currentLocation.setLocation(r.getEnd());
		return r;
	}
	
	public String getLocation(){
		return this.currentLocation.getLocation();
	}
	
	public void setLocation(String s){
		currentLocation.setLocation(s);
	}
}
