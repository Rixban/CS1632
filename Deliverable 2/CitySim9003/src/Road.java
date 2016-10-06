public class Road {
	private String startLocation;
	private String street;
	private String endLocation;
	
	public Road(String start, String stre, String end){
		startLocation = start;
		street = stre;
		endLocation = end;
	}
	
	public void setStart(String s){
		startLocation = s;
	}
	
	public void setStreet(String s){
		street = s;
	}
	
	public void setEnd(String s){
		endLocation = s;
	}
	
	public String getStart(){
		return this.startLocation;
	}
	
	public String getStreet(){
		return this.street;
	}
	
	public String getEnd(){
		return this.endLocation;
	}
}
