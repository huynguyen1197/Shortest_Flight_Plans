// The stack for backtracking

public class Stack {
	private LinkedList<City> list;
	
	public Stack() {
		list = new LinkedList<City>();
	}
	
	public void push(City newCity) {
		list.insert(newCity);
	}
	
	public City pop() {
		return list.pop();
	}
	
	public boolean isEmpty() {
		return list.getSize() == 0;
	}
}
