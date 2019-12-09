
// Graph representation of cities

import java.text.DecimalFormat;

public class GraphCities {
	private LinkedList<City> cities;
	
	public GraphCities() {
		cities = new LinkedList<City>(); //linked list to hold cities
	}

	public City getCity(String name) {
		return cities.fetch(name); //get the city
	}

	public void setLeg(String cityName1, String cityName2, double cost, int time) { //set the legs

		City city1 = this.getCity(cityName1);
		City city2 = this.getCity(cityName2);

		if (city1 == null)
			cities.insert(city1 = new City(cityName1));

		if (city2 == null)
			cities.insert(city2 = new City(cityName2));

		city1.setAdj(city2, cost, time);
		city2.setAdj(city1, cost, time);
	}
	
	// Iterative Backtracking algorithm to find all flights,
	// then use a min-heap to extract first 3
	
	public String flightPlan(String source, String dest, String request) {
		
		DecimalFormat formatter = new DecimalFormat("0.00");
		if (request.equalsIgnoreCase("time")) {
			int count = 0;
			Heap<timePath> heap = new Heap<timePath>();
			
			Stack vertices = new Stack();
			Stack parents = new Stack();

			City sourceCity = cities.fetch(source);
			City destCity = cities.fetch(dest);

			Path path = new Path();

			vertices.push(sourceCity);
			parents.push(sourceCity);

			while (!vertices.isEmpty()) {

				City current = vertices.pop();
				City parent = parents.pop();

				while (!path.isEmpty() && parent != path.checkLast()) {
					path.removeLast();
				}

				path.add(current);

				current.resetItr();

				while (current.hasNextAdj()) {

					AdjCity neighbor = current.next();

					if (path.contains(neighbor.getCity())) {
						continue;
					}

					if (neighbor.getCity() == destCity) {
						path.add(neighbor.getCity());
						count++;
						heap.add(new timePath(path));
						path.removeLast();
					}

					else {
						vertices.push(neighbor.getCity());
						parents.push(current);
					}
				}
			}
			
			if (count == 0)
				return "There is no possible flight plan!";
			else if (count < 3) {
				String s = "";
				for (int i = 0; i < count; i++) {
					timePath timePath = heap.remove();
					s = s + "Path " + Integer.toString(i + 1) + ": " + timePath.path
							+ ". Time: " + Integer.toString(timePath.time)
							+ " Cost: " + formatter.format(timePath.cost) + "\n";
				}
				return s;
			}
			else {
				String s = "";
				for (int i = 0; i < 3; i++) {
					timePath timePath = heap.remove();
					s = s + "Path " + Integer.toString(i + 1) + ": " + timePath.path
							+ ". Time: " + Integer.toString(timePath.time)
							+ " Cost: " + formatter.format(timePath.cost) + "\n";
				}
				return s;
			}
		} 
		else {
			int count = 0;
			Heap<costPath> heap = new Heap<costPath>();

			Stack vertices = new Stack();
			Stack parents = new Stack();

			City sourceCity = cities.fetch(source);
			City destCity = cities.fetch(dest);

			Path path = new Path();

			vertices.push(sourceCity);
			parents.push(sourceCity);

			while (!vertices.isEmpty()) {

				City current = vertices.pop();
				City parent = parents.pop();

				while (!path.isEmpty() && parent != path.checkLast()) {
					path.removeLast();
				}

				path.add(current);

				current.resetItr();

				while (current.hasNextAdj()) {

					AdjCity neighbor = current.next();

					if (path.contains(neighbor.getCity())) {
						continue;
					}

					if (neighbor.getCity() == destCity) {
						path.add(neighbor.getCity());
						count++;
						heap.add(new costPath(path));
						path.removeLast();
					}

					else {
						vertices.push(neighbor.getCity());
						parents.push(current);
					}
				}
			}
			
			if (count == 0)
				return "There is no possible flight plan!";
			else if (count < 3) {
				String s = "";
				for (int i = 0; i < count; i++) {
					costPath costPath = heap.remove();
					s = s + "Path " + Integer.toString(i + 1) + ": " + costPath.path
							+ ". Time: " + Integer.toString(costPath.time)
							+ " Cost: " + formatter.format(costPath.cost) + "\n";
				}
				return s;
			}
			else {
				String s = "";
				for (int i = 0; i < 3; i++) {
					costPath costPath = heap.remove();
					s = s + "Path " + Integer.toString(i + 1) + ": " + costPath.path
							+ ". Time: " + Integer.toString(costPath.time)
							+ " Cost: " + formatter.format(costPath.cost) + "\n";
				}
				return s;
			}		
		}
	}
	
	// class to store paths in order of time
	class timePath implements Comparable<timePath> {
		String path;
		int time;
		double cost;
		timePath (Path path) {
			this.path = path.getPath();
			this.time = path.getTime();
			this.cost = path.getCost();
		}
		
		@Override
		public int compareTo(timePath obj) {
			if (this.time < obj.time)
				return -1;
			if (this.time > obj.time)
				return 1;
			else
				return 0;
		}
	}
	
	// class to store paths in order of cost
	class costPath implements Comparable<costPath> {
		String path;
		int time;
		double cost;
		costPath (Path path) {
			this.path = path.getPath();
			this.time = path.getTime();
			this.cost = path.getCost();
		}
		
		@Override
		public int compareTo(costPath obj) {
			if (this.cost < obj.cost)
				return -1;
			if (this.cost > obj.cost)
				return 1;
			else
				return 0;
		}
	}
}
