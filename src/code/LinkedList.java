package code;

/**
 * An instance of a LinkedList is capable of storing int values in a chain of Node objects. When ints are inserted
 * into the list, the list will automatically sort the inserted element to preserve the sorted order in the list. A
 * LinkedList object is capable of reporting its size, inserting elements in sorted order, deleting elements, finding
 * elements, and outputting the list in string form.
 * 
 * @author Alan Rosenberg
 *
 */
public class LinkedList {
	
	//Only a handle on the head is necessary for this implementation
	Node head;
	
	//Constructor initializes head to null, signals an empty list
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Size method will return the size of the linked list. It will do so by walking the length of the list, incrementing
	 * a counter as it goes until it reaches the end of the list.
	 * 
	 * This method belongs to O(n)
	 * @return the size of the list
	 */
	public int size() {
		
		//Covering empty list case, returning size 0
		if(head == null) {
			return 0;
		}
		
		//Establishing walker node and incrementing variable
		Node current = head;
		int i = 1;
		
		//Walking the list and incrementing...
		while(current.getNext() != null) {
			
			i++;
			current = current.getNext();
		}
		
		return i;	//returning final size of linked list
	}
	
	/**
	 * Insert fuction will insert values into the linked list in sorted order. The algorithm will walk the list looking for
	 * a value greater than or equal to the parameter. Once found, the algorithm will place a new node with the parameter in
	 * the list such that the sorted order is preserved. The node previous to the new node will reassign its next node to the
	 * new node, and the new node will assign its next node to the node previously attached to the parent of the new node.
	 * 
	 * This method belongs to O(n)
	 * @param int value to be inserted into the list
	 */
	public void insert(int val) {
		
		//Covering empty list case, inserting at the head and returning
		if(head == null) {
			head = new Node(val);
			return;
		}
		
		//Covering head insertion case, inserting at head and reassigning head variable to new element
		if(val < head.getVal()) {
			Node n = new Node(val);
			n.setNext(head);
			this.setHead(n);
			return;
		}
		
		//Establishing a walker and trailer to run the list and compare values
		Node current = head;
		Node trailer = new Node(head);
		
		//Walking the list until there are not more nodes
		while(current != null) {
			
			//When lesser node is found, executing insertion...
			if(val < current.getVal()) {
				/*
				 * Allocating new node, reassigning parent's next node to new node, and assigning new node's next node to former
				 * child node, then returning
				 */
				Node newNode = new Node(val);
				trailer.setNext(newNode);
				newNode.setNext(current);
				return;
			}
			
			//walkin...
			current = current.getNext();
			trailer = trailer.getNext();
		}
		
		//Inserting at the tail if value is greater than all values in linked list
		current = new Node(val);
		trailer.setNext(current);
	}
	
	/**
	 * Delete method will remove an item from the linked list. The method will return true if the element exists in the
	 * linked list, false if not.
	 * 
	 * This method belongs to O(n).
	 * @param int value intended for deletion
	 * @return true if element is found in the list and deleted, false if not.
	 */
	public boolean delete(int val) {
		
		//Covering empty list case, returning false, no possible matches
		if(head == null) {
			return false;
		}
		
		//Covering head deletion case..
		if(head.getVal() == val) {
			//in single element list, emptying the list and returning true
			if(head.getNext() == null) {
				head = null;
				return true;
			}	//Otherwise, reassigning head to its next and returning true
			head = head.getNext();
			return true;
		}
		
		//Establishing walker trailer combo
		Node current = head;
		Node trailer = new Node(current);
		
		//Walking the list...
		while(current != null) {
			
			//When a match is found, assigning parent node's next to its grand child and returning true
			if(current.getVal() == val) {
				trailer.setNext(current.getNext());
				return true;
			}
			
			//walkin...
			current = current.getNext();
			trailer = trailer.getNext();
		}
		
		//When no matches are found, returning false
		return false;
	}
	
	/**
	 * Find method will take the parameter and look for a matching element in the linked list. It will do so by walking
	 * the list, checking for a match as it goes.
	 * 
	 * Find belongs to O(n)
	 * @param int value for which the algorithm searches for a match
	 * @return true if a match is found, false if not
	 */
	public boolean find(int val) {
		
		//Covering empty list case, returning false, no possible matches
		if(head == null) {
			return false;
		}
		
		//Establishing walker
		Node current = head;
		
		//Walking the list...
		while(current != null) {
			
			//When a match is found, returning true
			if(current.getVal() == val) {
				return true;
			}
			
			//walkin...
			current = current.getNext();
		}
		
		//When no matches are found, returning false
		return false;
	}
	
	/**
	 * toString will read the content of the list, and generate a String with the int values stored. It will do so by walking
	 * the list, reading the values at each node, and appending the value to the string to be returned.
	 * 
	 * This method belongs to O(n)
	 * @return string of all values stored in the linked list
	 */
	public String toString() {
		
		String s = "";
		
		//Covering empty list case, returning empty string, no possible values to append
		if(head == null) {
			return s;
		}
		
		//Getting head value, makes formatting easier
		s = String.valueOf(head.getVal());
		
		//Establishing walker
		Node current = head.getNext();
		
		//Walking the list..
		while(current != null) {
			
			//Appending with style
			s = s + ", " + String.valueOf(current.getVal());
			
			//Walkin...
			current = current.getNext();
		}
		
		//Once string is built, returning it
		return s;
	}
	
	/*
	 * Getters and Setters
	 */

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
