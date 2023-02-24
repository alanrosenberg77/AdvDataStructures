package code;

/**
 * An instance of a Binary Search Tree will be able to store int values in sorted order such that the root of the tree is
 * always the smallest value. The tree functions as a priority queue, so the underlying array may not be in sorted order,
 * but one thing will always be true: a node will always be smaller than its children. A Binary Search Tree is capable of
 * reporting its size, inserting elements, deleting elements, finding elements, and reporting whether it is empty.
 * 
 * @author Alan Rosenberg
 *
 */
public class BinarySearchTree {
	
	TreeNode[] queue;
	
	public BinarySearchTree(){
		queue = new TreeNode[0];
	}
	
	public BinarySearchTree(Integer ... vals) {
		queue = new TreeNode[vals.length];
		
		for(Integer val : vals)
			if(val != null)
				insert(val);
	}
	
	
	/**
	 * Size method will return the size of the binary search tree. It will do so by walking the span
	 * of the tree, incrementing a counter as it goes, until it reaches null, signaling the end of
	 * elements in the tree.
	 * 
	 * This method belongs to O(n)
	 * @return int size of the array
	 */
	public int size() {
		
		//Establishing incrementing variable (starting at index 1 to avoid null first element)
		int i = 1;
		
		//Walking the tree (BFS)...
		while(i < queue.length) {
			
			//When null is found, breaking the loop
			if(queue[i] == null)
				break;
			
			//incrementin...
			i++;
		}
		
		//returning number of elements in the tree
		return i-1;
	}
	
	/**
	 * Insert fuction will insert values into the tree in sorted order. The algorithm will insert the value at the last index
	 * of the underlying queue (lowest branch of the tree). It will then call the bubble up method to place the new element
	 * in its appropriate place in the binary search tree.
	 * 
	 * If the queue outgrows its size, the algorithm will create a new queue with double the size, copy the data into the
	 * new queue, and then perform the insertion as described above.
	 * 
	 * This method belongs to O(lg(n))
	 * @param int value to be inserted into the array
	 */
	public void insert(int val) {

		//Initializing queue if not done already
		if(queue.length == 0) {
			queue = new TreeNode[2];
		}
		
		//Expanding the queue by a factor of 2 if needed, and copying data into new queue
		else if(queue[queue.length-1] != null) {
			TreeNode[] tmp = queue;
			queue = new TreeNode[queue.length*2];
			for(int i=0 ; i<tmp.length ; i++) {
				queue[i] = tmp[i];
			}
		}
		
		//Covering empty list case, inserting at the root of the tree
		if(this.size() == 0) {
			TreeNode n = new TreeNode(val);
			queue[1] = n;
			return;
		}
		
		//Appending at the end of the queue (lowest branch), then calling BubbleUp
		int lastIndex = this.size();
		TreeNode n = new TreeNode(val);
		queue[lastIndex+1] = n;
		BubbleUp(n, lastIndex+1);
		}

	/**
	 * Delete method will remove an item from the tree. It does so by first finding the item (if it exists in the tree),
	 * replacing it with the element at the end of the queue (lowest branch), then Bubbling Down.
	 * 
	 * This method belongs to O(n)
	 * @param int value intended for deletion
	 * @return true if element is found in the tree and deleted, false if not.
	 */
	public boolean delete(int val) {

		//Covering empty tree case, returning false
		if(queue.length == 0)
			return false;
		
		//Finding the end of the queue (lowest branch)
		int lastIndex = this.size();
		
		//Establishing incrementing variable
		int i = 1;
		boolean found = false;
		
		//Walking the tree (BFS)
		while(i <= lastIndex) {
			
			//When a match is found, breaking the loop to get index of element intended for deletion
			if(queue[i].getVal() == val) {
				found = true;
				break;
			}
			
			//walkin...
			i++;
		}
		
		//Covering non existent element case, returning false
		if(!found)
			return false;
		
		//Deleting element and replacing it with element at the end of the tree
		queue[i] = queue[lastIndex];
		queue[lastIndex] = null;

		//Bubbling down to reestablish sorted order
		BubbleDown(queue[i], i);
		
		//Returning true because element was found and deleted
		return true;
	}

	/**
	 * Find method will take the parameter and look for a matching element in the tree. It will do so by walking the tree,
	 * checking for a match as it goes.
	 * 
	 * Find belongs to O(n)
	 * @param int value for which the algorithm searches for a match
	 * @return true if a match is found, false if not
	 */
	public boolean find(int val) {
		
		//Covering uninitialized queue case, ducking out
		if(queue == null)
			return false;
		
		//Walking the tree...
		for(TreeNode tn : queue) {
			
			//When a match is found, returning true
			if(tn!=null && tn.getVal().equals(val))
				return true;
		}
		
		//When no match is found, returning false
		return false;
	}
	
	/**
	 * toString will read the content of the tree, and generate a String with the int values stored. It will do so by walking
	 * the queue, reading the values at each index, and appending the value to the string to be returned.
	 * 
	 * This method belongs to O(n)
	 * @return string of all values stored in the tree
	 */
	public String toString() {
		
		//Starting with empty string
		String s = "";
		
		//Covering empty tree case, returning empty string
		if(this.size() == 0) {
			return s;
		}
		
		//s can have the root value, as a treat
		s = String.valueOf(queue[1].getVal());
		
		//Walking the tree
		for(int i = 2; i < this.size()+1; i++) {
			
			//Appending values till there are no more
			if(queue[i] != null) {
				s = s + ", " + queue[i].getVal();
			}
		}
		
		//Returning built string
		return s;
	}
	
	/*
	 * This method defines the bubbling up functionality.
	 * If the value is in the correct spot, the method terminates, as it has reached its goal.
	 * If not, the value's position is swapped with its parent until the goal is reached.
	 */
	private void BubbleUp(TreeNode value, int index) {
		
		if(queue[1].equals(value))	//skips everything if the value is at index 0
			return;
		
		else if(value.getVal() < queue[index/2].getVal()) {	//comparing value and its parent
			TreeNode tmp = queue[index/2];		
			queue[index/2] = value;
			queue[index] = tmp;				//swapping value and its parent
			BubbleUp(value, index/2);		//recursive call to continue until satisfied
		}
	}
	
	/*
	 * Defines the bubbling down functionality.
	 * If the value is in the correct spot, the method terminates, as it has reached its goal.
	 * If not, the value's position is swapped with the appropriate child until the goal is reached.
	 */
	private void BubbleDown(TreeNode value, int index) {
		
		TreeNode child1 = null;
		TreeNode child2 = null;
		
		if(queue.length > index*2+1) {		//avoiding index out of bounds error
			child1 = queue[index*2];
			child2 = queue[index*2+1];
		}
		
		if(child1!=null && child2!=null) {	//if both children exist...
			if(child1.getVal() >= value.getVal() && child2.getVal() >= value.getVal())
				return;
			else if(child1.getVal() < value.getVal()) {			//if child 1 is less than current...
				queue[index*2+1] = value;
				queue[index] = child1;
				BubbleDown(value, index*2+1);	//swap current node and child 1
			}
			else if(child2.getVal() < value.getVal()) {			//if child 2 is less than current...
				queue[index*2] = value;
				queue[index] = child2;
				BubbleDown(value, index*2);		//swap current node and child 2
			}
			else {							//if both children are less than current...
				int diff = child1.getVal()-child2.getVal();
				if(diff > 0) {				//if child 1 is larger than child 2...
					queue[index*2+1] = value;
					queue[index] = child2;
					BubbleDown(value, index*2+1);	//swap current node and child 2
				}
				else if(diff < 0) {			//if child 2 is larger than child 1...
					queue[index*2] = value;
					queue[index] = child1;
					BubbleDown(value, index*2);		//swap current node and child 1
				}
			}
		}
		else if(child1!=null) {		//if only 1 child exists...
			if(child1.getVal() < value.getVal()) {			//if child is less than current...
				queue[index*2] = value;
				queue[index] = child1;
				BubbleDown(value, index*2);		//swap current node and child
			}
		}
	}

	/*
	 * Getters and Setters
	 */
	public TreeNode[] getQueue() {
		return queue;
	}

	public void setQueue(TreeNode[] queue) {
		this.queue = queue;
	}

}