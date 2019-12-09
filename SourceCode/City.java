
// class for cities

public class City {
	private String cityName; // city Name
	private LinkedList<AdjCity> adjacentCities; // List of adjacent cities
	private boolean visited;
	
	public City(String name) {
		cityName = name;
		adjacentCities = new LinkedList<AdjCity>();
	}
	
	public void setAdj(City city, double cost, int time) {
		adjacentCities.insert(new AdjCity(city, cost, time));
	}
	
	public AdjCity getDest(String cityName) {
		return adjacentCities.fetch(cityName);
	}
	
	public void resetItr() {
		adjacentCities.itr.reset();
	}
	
	public boolean hasNextAdj() {
		return adjacentCities.itr.hasNext();
	}
	
	public AdjCity next() {
		return adjacentCities.itr.next();
	}
	
	public String toString() {
		return cityName;
	}
}
