package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.BinarySearchTree;
import code.TreeNode;

public class BinarySearchTreeTest {

	BinarySearchTree emptyTree;
	BinarySearchTree fullTree;
	BinarySearchTree normalTree;
	
	@Before
	public void setUp() throws Exception {
		emptyTree = new BinarySearchTree();
		fullTree = new BinarySearchTree();
		normalTree = new BinarySearchTree();
		
		fullTree.setQueue(new TreeNode[] {null, new TreeNode(5), new TreeNode(10), new TreeNode(13)});
		
		normalTree.setQueue(new TreeNode[] {null, new TreeNode(5), new TreeNode(10), new TreeNode(13), null});
	}

	@Test
	public void creationTest() {
		assertNotNull(emptyTree);
		assertNotNull(fullTree);
		assertNotNull(normalTree);
	}
	
	/*
	 * Size Tests
	 */
	
	@Test
	public void sizeOfEmptyTreeTest() {
		assertEquals(0, emptyTree.size());
	}
	
	@Test
	public void sizeOfFullTreeTest() {
		assertEquals(3, fullTree.size());
	}
	
	@Test
	public void sizeOfNormalTreeTest() {
		assertEquals(3, normalTree.size());
	}
	
	/*
	 * Insert Tests
	 */
	
	@Test
	public void insertInEmptyTreeTest() {
		assertEquals(0, emptyTree.size());
		assertEquals(0, emptyTree.getQueue().length);
		
		emptyTree.insert(5);
		
		assertEquals(1, emptyTree.size());
		assertEquals(2, emptyTree.getQueue().length);
		assertTrue(emptyTree.toString().equals("5"));
	}
	
	@Test
	public void insertInFullTreeTest() {
		assertEquals(3, fullTree.size());
		assertEquals(4, fullTree.getQueue().length);
		
		fullTree.insert(12);
		
		assertEquals(4, fullTree.size());
		assertEquals(8, fullTree.getQueue().length);
		assertTrue(fullTree.toString().equals("5, 10, 13, 12"));
	}
	
	@Test
	public void insertInNormalTreeTest() {
		assertEquals(3, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		
		normalTree.insert(12);
		
		assertEquals(4, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		assertTrue(normalTree.toString().equals("5, 10, 13, 12"));
	}
	
	/*
	 * Delete Tests
	 */
	
	@Test
	public void deleteFromEmptyTreeTest() {
		assertEquals(0, emptyTree.size());
		assertEquals(0, emptyTree.getQueue().length);
		
		assertFalse(emptyTree.delete(5));
		assertEquals(0, emptyTree.size());
		assertEquals(0, emptyTree.getQueue().length);
		assertTrue(emptyTree.toString().equals(""));
	}
	
	@Test
	public void deleteFromFullTreeBubblingTest() {
		assertEquals(3, fullTree.size());
		assertEquals(4, fullTree.getQueue().length);
		
		assertTrue(fullTree.delete(5));
		assertEquals(2, fullTree.size());
		assertEquals(4, fullTree.getQueue().length);
		assertTrue(fullTree.toString().equals("10, 13"));
	}
	
	@Test
	public void deleteFromFullTreeNoBubblingTest() {
		assertEquals(3, fullTree.size());
		assertEquals(4, fullTree.getQueue().length);
		
		assertTrue(fullTree.delete(10));
		assertEquals(2, fullTree.size());
		assertEquals(4, fullTree.getQueue().length);
		assertTrue(fullTree.toString().equals("5, 13"));
	}
	
	@Test
	public void deleteFromNormalTreeBubblingTest() {
		assertEquals(3, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		
		assertTrue(normalTree.delete(5));
		assertEquals(2, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		assertTrue(normalTree.toString().equals("10, 13"));
	}
	
	@Test
	public void deleteFromNormalTreeNoBubblingTest() {
		assertEquals(3, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		
		assertTrue(normalTree.delete(10));
		assertEquals(2, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		assertTrue(normalTree.toString().equals("5, 13"));
	}
	
	@Test
	public void deleteNonExistentElementTest() {
		assertEquals(3, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		
		assertFalse(normalTree.delete(12));
		assertEquals(3, normalTree.size());
		assertEquals(5, normalTree.getQueue().length);
		assertTrue(normalTree.toString().equals("5, 10, 13"));
	}
	
	/*
	 * Find Tests
	 */
	
	@Test
	public void findInEmptyTreeTest() {
		assertFalse(emptyTree.find(5));
	}
	
	@Test
	public void findInFullTreeTest() {
		assertTrue(fullTree.find(10));
	}
	
	@Test
	public void findInNormalTreeTest() {
		assertTrue(normalTree.find(10));
	}
	
	@Test
	public void findNonExistentElementTest() {
		assertFalse(normalTree.find(12));
	}

	/*
	 * toString Tests
	 */
	
	@Test
	public void emptyTreeToString() {
		assertTrue(emptyTree.toString().equals(""));
	}
	
	@Test
	public void fullTreeToString() {
		assertTrue(fullTree.toString().equals("5, 10, 13"));
	}
	
	@Test
	public void normalTreeToString() {
		assertTrue(normalTree.toString().equals("5, 10, 13"));
	}
}
