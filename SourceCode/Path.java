
public class Path {

	private LinkedList<City> list;
	private int time;
	private double cost;

	Path() {
		list = new LinkedList();
		time = 0;
		cost = 0.00;
	}

	public City checkLast() {
		list.itr.reset();
		City city = list.itr.next();
		return city;
	}

	public boolean contains(City city) {
		return list.fetch(city.toString()) != null;
	}

	public boolean isEmpty() {
		return list.getSize() == 0;
	}

	public void add(City newCity) {
		if (!this.isEmpty()) {
			time = time + this.checkLast().getDest(newCity.toString()).getTime();
			cost = cost + this.checkLast().getDest(newCity.toString()).getCost();
		}
		list.insert(newCity);
	}

	public void removeLast() {
		City last = list.pop();
		time = time - this.checkLast().getDest(last.toString()).getTime();
		cost = cost - this.checkLast().getDest(last.toString()).getCost();
	}
	
	public int getTime() {
		return time;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getPath() {
		String s = "";
		list.reverse();
		list.itr.reset();
		s = s + list.itr.next().toString();
		while (list.itr.hasNext()) {
			s = s + " -> " + list.itr.next().toString();
		}
		list.reverse();
		return s;
	}
}
