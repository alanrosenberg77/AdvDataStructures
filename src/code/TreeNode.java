package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in the search tree that results from searching our state space.
 * For any given node, we know/track the prior node from which we came in the search,
 * as well as additional meta-data.
 * <p>
 * Because we are constructing a n-ary tree, will manage a list of children nodes that
 * are possible when we take a specified action. 
 *  
 * @author mahiggs
 *
 */
public class TreeNode {
	
	TreeNode parent;
	List<TreeNode> children;
	Integer val;
	
	public TreeNode(Integer val) {
		parent = null;
		children = new ArrayList<>();
		this.val = val;
	}

	/*
	 * Getters and Setters
	 */

	public TreeNode getParent() {
		return parent;
	}


	public void setParent(TreeNode parent) {
		this.parent = parent;
	}


	public List<TreeNode> getChildren() {
		return children;
	}


	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}


	public Integer getVal() {
		return val;
	}


	public void setVal(Integer val) {
		this.val = val;
	}


	/**
	 * Allows our search tree node instance to work with hash table based sets and
	 * other collections that rely on a working hashCode function.   We are basing
	 * our hash key on the search tree state.  In other words, we lookup a matching
	 * node based on its puzzle 8 state. 
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}


	/**
	 * Allows our search tree node instance to be compared with other nodes to 
	 * determine if they are "equivalent" (ie, they hold the same state).  
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}
	
}
