
// class for edges

public class AdjCity {
	private City city;
	private int time;
	private double cost;
	
	public AdjCity(City city, double cost, int time) {
		this.city = city;
		this.time = time;
		this.cost = cost;
	}
	
	public int getTime() {
		return time;
	}
	
	public double getCost() {
		return cost;
	}
	
	public City getCity() {
		return city;
	}
	
	public String toString() {
		return city.toString();
	}
}
