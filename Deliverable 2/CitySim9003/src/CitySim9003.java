import java.util.*;


public class CitySim9003 {

	public static void main(String[] args){
		//Argument handling, we don't care about additional inputs.
		int seed = 0;
		try{
			seed = Integer.parseInt(args[0]);
		}
		catch(Exception e){
			System.out.println("Unexpected input. Please run the program with one integer value from -2147483648 to 2147483647");
			return;
		}

		City c = new City();
		
		//Location initialization
		Location location = new Location("Coffee");
		c.addLocation(location);
		location = new Location("Hotel");
		c.addLocation(location);
		location = new Location("Diner");
		c.addLocation(location);
		location = new Location("Library");
		c.addLocation(location);
		
		//Roads initialization
		Road road = new Road("Hotel","Fourth Ave","Diner");
		c.addRoad(road);
		road = new Road("Diner","Fourth Ave","Outside City");
		c.addRoad(road);
		road = new Road("Hotel","Bill Street","Library");
		c.addRoad(road);
		road = new Road("Library", "Fifth Ave", "Outside City");
		c.addRoad(road);
		road = new Road("Coffee","Fifth Ave","Library");
		c.addRoad(road);
		road = new Road("Diner", "Phil Street", "Coffee");
		c.addRoad(road);
		road = new Road("Coffee", "Phil Street", "Diner");
		c.addRoad(road);
		road = new Road("Library","Bill Street","Hotel");
		c.addRoad(road);
		
		Random random = new Random(seed);
		for(int i = 1; i < 6; i++){
			Location l = new Location(c.getRandomStart(random));
			Driver d = new Driver(c,l);
			int coffee = 0;
			if(l.getLocation().equals("Coffee")){
				coffee++;
			}

			while(!d.getLocation().equals("Outside City")){
				road = d.driveAround(random);
				if(road.getEnd().equals("Coffee")){
					coffee++;
				}
				System.out.println("Driver "+i+" heading from "+road.getStart() +" to " + road.getEnd() + " via " + road.getStreet()+".");
			}
			if(road.getStreet().equals("Fourth Ave")){
				System.out.println("Driver "+i+" has gone to Philadelphia!");
			}
			else{
				System.out.println("Driver "+i+" has gone to Cleveland!");
			}
			System.out.println("Driver "+i+" got "+coffee+" cup(s) of coffee.");
			System.out.println();
		}
	}
}
