package code;


/**
 * This interface helps us to establish a common call interface so we can easily
 * swap out the frontier implementation in our agent's seach/plan code without
 * having to make many manual edits.
 * 
 * @author mahiggs
 *
 */
public interface Frontier  {
	
	/**
	 * Returns the number of elements in the binary search tree
	 * 
	 * @return
	 */
	public int size();
	
	/**
	 * Appropriately adds the search treenode to the frontier collection;
	 * 
	 * @param n
	 */
	public void insert(int val);
	
	/**
	 * Removes and returns the next appropriate node from the frontier.
	 * 
	 * @return
	 */
	public boolean delete(int val);
	
	/**
	 * Returns true if the specified state is associated with a node in the frontier.
	 * 
	 * @param state
	 * @return true if a match is found, false if not
	 */
	public boolean find(int val);
	
	/**
	 * Returns true if the frontier is empty
	 * @return
	 */
	public boolean isEmpty();
}
