package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.LinkedList;
import code.Node;

public class LinkedListTest {
	
	LinkedList emptyList;
	LinkedList oneElementList;
	LinkedList twoElementList;
	LinkedList normalList;

	@Before
	public void setUp() throws Exception {
		emptyList = new LinkedList();
		oneElementList = new LinkedList();
		normalList = new LinkedList();
		
		oneElementList.insert(5);
		
		normalList.insert(5);
		normalList.insert(10);
		normalList.insert(13);
	}

	@Test
	public void creationTest() {
		assertNotNull(emptyList);
		assertNotNull(oneElementList);
		assertNotNull(normalList);
	}
	
	/*
	 * Size Tests
	 */
	
	@Test
	public void sizeOfEmptyListTest() {
		assertEquals(0, emptyList.size());
	}
	
	@Test
	public void sizeTest() {
		assertEquals(1, oneElementList.size());
		assertEquals(3, normalList.size());
	}
	
	/*
	 * Insert Tests
	 */
	
	@Test
	public void insertInEmptyListTest() {
		assertEquals(0, emptyList.size());
		
		emptyList.insert(5);
		
		assertEquals(1, emptyList.size());
		assertTrue(emptyList.toString().equals("5"));
	}
	
	@Test
	public void insertInSingleElementListTest() {
		assertEquals(1, oneElementList.size());
		
		oneElementList.insert(8);
		
		assertEquals(2, oneElementList.size());
		assertTrue(oneElementList.toString().equals("5, 8"));
	}
	
	@Test
	public void insertAtHeadInSingleElementListTest() {
		assertEquals(1, oneElementList.size());
		
		oneElementList.insert(2);
		
		assertEquals(2, oneElementList.size());
		assertTrue(oneElementList.toString().equals("2, 5"));
	}
	
	@Test
	public void insertingDuplicateElementTest() {
		assertEquals(3, normalList.size());
		
		normalList.insert(10);
		
		assertEquals(4, normalList.size());
		assertTrue(normalList.toString().equals("5, 10, 10, 13"));
	}
	
	@Test
	public void insertNormalTest() {
		assertEquals(3, normalList.size());
		
		normalList.insert(12);
		
		assertEquals(4, normalList.size());
		assertTrue(normalList.toString().equals("5, 10, 12, 13"));
	}
	
	/*
	 * Delete Tests
	 */
	
	@Test
	public void deleteOnEmptyListTest() {
		assertEquals(0, emptyList.size());
		
		assertFalse(emptyList.delete(5));
		assertEquals(0, emptyList.size());
		assertTrue(emptyList.toString().equals(""));
	}
	
	@Test
	public void deleteAbsentElementsTest() {
		assertEquals(1, oneElementList.size());
		
		assertFalse(oneElementList.delete(2));
		assertEquals(1, oneElementList.size());
		assertTrue(oneElementList.toString().equals("5"));
		
		assertEquals(3, normalList.size());
		
		assertFalse(normalList.delete(2));
		assertEquals(3, normalList.size());
		assertTrue(normalList.toString().equals("5, 10, 13"));
	}
	
	@Test
	public void deleteOnSingleElementListTest() {
		assertEquals(1, oneElementList.size());
		
		assertTrue(oneElementList.delete(5));
		assertEquals(0, oneElementList.size());
		assertTrue(oneElementList.toString().equals(""));
	}
	
	@Test
	public void deleteAtHeadOnSingleElementListTest() {
		assertEquals(1, oneElementList.size());
		
		assertTrue(oneElementList.delete(5));
		assertEquals(0, oneElementList.size());
		assertTrue(oneElementList.toString().equals(""));

	}
	
	@Test
	public void deleteAtHeadNormalListTest() {
		assertEquals(3, normalList.size());
		
		assertTrue(normalList.delete(5));
		assertEquals(2, normalList.size());
		assertTrue(normalList.toString().equals("10, 13"));
	}
	
	@Test
	public void deleteNormalListTest() {
		assertEquals(3, normalList.size());
		
		assertTrue(normalList.delete(10));
		assertEquals(2, normalList.size());
		assertTrue(normalList.toString().equals("5, 13"));
		
		assertTrue(normalList.delete(13));
		assertEquals(1, normalList.size());
		assertTrue(normalList.toString().equals("5"));
	}
	
	/*
	 * Find Tests
	 */
	
	@Test
	public void findInEmptyListTest() {
		assertFalse(emptyList.find(2));
	}
	
	@Test
	public void findSingleElementListTest() {
		assertTrue(oneElementList.find(5));
	}
	
	@Test
	public void findAtHeadInNormalListTest() {
		assertTrue(normalList.find(5));
	}
	
	@Test
	public void findInNormalListTest() {
		assertTrue(normalList.find(10));
		assertTrue(normalList.find(13));
	}
	
	/*
	 * toString Tests
	 */
	
	@Test
	public void emptyListToStringTest() {
		assertTrue(emptyList.toString().equals(""));
	}
	
	@Test
	public void singleElementListToStringTest() {
		assertTrue(oneElementList.toString().equals("5"));
	}
	
	@Test
	public void normalListToStringTest() {
		assertTrue(normalList.toString().equals("5, 10, 13"));
	}
}
