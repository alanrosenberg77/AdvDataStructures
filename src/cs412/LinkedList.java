package cs412;

public class LinkedList {
	
	Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public LinkedList(int... vals) {
		
		Node n;
		
		for(int val : vals) {
			n = new Node(val);
			
		}
	}
	
	/**
	 * The insert fuction will insert values into the linked list in sorted order. The algorithm will walk the list looking for
	 * a value greater than or equal to the parameter. Once found, the algorithm will place a new node with the parameter in
	 * the list such that the sorted order is preserved. The node previous to the new node will reassign its next node to the
	 * new node, and the new node will assign its next node to the node previously attached to the parent of the new node.
	 * @param val
	 */
	public void insert(int val) {
		
		if(head == null) {
			head.setVal(val);
			return;
		}
		
		if(head.getNext() == null) {
			if(val > head.getVal()) {
				head.setNext(new Node(val));
			}
			else {
				Node n = new Node(val);
				n.setNext(head);
				this.setHead(n);
			}
			return;
		}
		
		
		if(val > head.getVal()) {
			Node n = new Node(val);
			n.setNext(head);
			this.setHead(n);
			return;
		}
		
		//Establishing a scrubber and trailer to run the list and compare values
		Node n = head;
		Node trailer = new Node(n);
		
		while(n.getNext() != null) {
			
			if(val > n.getVal()) {
				Node newNode = new Node(val);
				trailer.setNext(newNode);
				newNode.setNext(n);
				return;
			}
			
			n = n.getNext();
			trailer = trailer.getNext();
		}
		
		n.setNext(new Node(val));
	}
	
	/**
	 * Delete method will remove an item from the linked list. The method will return true if the element exists in the linked list,
	 * false if not. This method belongs to O(n).
	 * @param value
	 * @return
	 */
	public boolean delete(int value) {
		return true;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
