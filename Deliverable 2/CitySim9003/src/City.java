import java.util.*;

public class City {
	private ArrayList<Location> startLocations = new ArrayList<>();
	private ArrayList<Road> availRoads = new ArrayList<>();
	
	public void addRoad(Road road){
		//avoid Duplicates, this messes with perfect rng.
		if(!availRoads.contains(road)){
			availRoads.add(road);
		}
	}
	
	public void addLocation(Location location){
		//avoid duplicates, this messes up perfect rng.
		if(!startLocations.contains(location)){
			startLocations.add(location);
		}
	}
	
	
	public boolean locationExists(Location l){
		if(startLocations.contains(l)){
			return true;
		}
		return false;
	}
	
	public boolean roadExists(Road r){
		if(availRoads.contains(r)){
			return true;
		}
		return false;
	}
	
	public int getNumberOfRoads(){
		return availRoads.size();
	}
	
	public int getNumberOfLocations(){
		return startLocations.size();
	}
	
	public ArrayList<Road> getNextDestination(String startLocation){
		ArrayList<Road> legitDestinations = new ArrayList<>();
		for(int i = 0; i < availRoads.size();i++){
			if(availRoads.get(i).getStart().equals(startLocation)){
				legitDestinations.add(availRoads.get(i));
			}
		}
		return legitDestinations;
	}
	
	public String getRandomStart(Random random){
		int index = random.nextInt(startLocations.size());
		return(startLocations.get(index).getLocation());
	}

}
