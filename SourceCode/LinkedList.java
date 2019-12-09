
//Linked List

public class LinkedList<T> {

	private Node head; // head of linked list
	public Iterator itr;
	
	public LinkedList() {
		head = new Node();
		itr = new Iterator();
	}

	// insert method to use the main linked list of distinct cities
	public void insert(T newData) {
		Node n = new Node(); // create a new node to insert into the list
		n.next = head.next; // use the next field of new node to link to the stored nodes
		head.next = n; // link the next field of dummy node to the new node
		n.data = newData; // deep copy the new account into the account field of new node
	}
	
	//fetch a node
	public T fetch(String key) {
		Node current = head.next;
		while (current != null) {
			if (current.data.toString().equalsIgnoreCase(key)) {
				return current.data;
			}
			else
				current = current.next;
		}
		return null;
	}
	
	// get the number of items
	public int getSize() {
		int count = 0;
		Node current = head.next;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	// method for stack pop
	public T pop() {
		Node temp = head.next;
		head.next = head.next.next;
		return temp.data;
	}
	
	//reverse the linked list
	public void reverse() {
        Node prev = null; 
        Node current = head.next; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head.next = prev;
        itr.reset();
	}
	
	// class for the Node
	public class Node {
		private T data;// Account_Nguyen field
		private Node next;// the next field

		// no-argument constructor
		public Node() {
			data = null;
			next = null;
		}
	}
	
	public class Iterator {
		private Node ip; //Node reference variable to point to a position of node
		
		//no-argument constructor
		public Iterator() {
			ip = head; //initialize the position to the dummy node
		}
		//reset method
		public void reset() {
			ip = head;
		}
		
		//hasNext method
		public boolean hasNext() {
			if(ip.next != null)//check if there is node next to current position
				return true;//return true
			else
				return false;//return false if there is no such node
		}
		
		public T next() {
			ip = ip.next;
			return ip.data;
		}

	}
}
