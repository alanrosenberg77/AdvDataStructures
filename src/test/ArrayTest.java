package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Array;

public class ArrayTest {
	
	Array emptyArray;
	Array fullArray;
	Array normalArray;

	@Before
	public void setUp() throws Exception {
		emptyArray = new Array();
		fullArray = new Array();
		normalArray = new Array();
		
		fullArray.setList(new Integer[] {5, 10, 13});
		
		normalArray.setList(new Integer[] {5, 10, 13, null});
	}

	@Test
	public void creationTest() {
		assertNotNull(emptyArray);
		assertNotNull(fullArray);
		assertNotNull(normalArray);
	}
	
	/*
	 * Size Tests
	 */
	
	@Test
	public void sizeOfEmptyArrayTest() {
		assertEquals(0, emptyArray.size());
	}
	
	@Test
	public void sizeOfFullArrayTest() {
		assertEquals(3, fullArray.size());
	}
	
	@Test
	public void sizeOfNormalArrayTest() {
		assertEquals(3, normalArray.size());
	}
	
	/*
	 * Insert Tests
	 */
	
	@Test
	public void insertInEmptyArrayTest() {
		assertEquals(0, emptyArray.size());
		assertEquals(128, emptyArray.getList().length);
		
		emptyArray.insert(5);
		
		assertEquals(1, emptyArray.size());
		assertEquals(128, emptyArray.getList().length);
		assertTrue(emptyArray.toString().equals("5"));
	}
	
	@Test
	public void insertInFullArrayTest() {
		assertEquals(3, fullArray.size());
		assertEquals(3, fullArray.getList().length);
		
		fullArray.insert(12);
		
		assertEquals(4, fullArray.size());
		assertEquals(6, fullArray.getList().length);
		assertTrue(fullArray.toString().equals("5, 10, 12, 13"));
	}
	
	@Test
	public void insertInNormalArrayTest() {
		assertEquals(3, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		
		normalArray.insert(12);
		
		assertEquals(4, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		assertTrue(normalArray.toString().equals("5, 10, 12, 13"));
	}
	
	@Test
	public void insertDuplicateElementTest() {
		assertEquals(3, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		
		normalArray.insert(10);
		
		assertEquals(4, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		assertTrue(normalArray.toString().equals("5, 10, 10, 13"));
	}
	
	/*
	 * Delete Tests
	 */
	
	@Test
	public void deleteFromEmptyArrayTest() {
		assertEquals(0, emptyArray.size());
		assertEquals(128, emptyArray.getList().length);
		
		assertFalse(emptyArray.delete(5));
		assertEquals(0, emptyArray.size());
		assertEquals(128, emptyArray.getList().length);
		assertTrue(emptyArray.toString().equals(""));
	}
	
	@Test
	public void deleteFromFullArrayTest() {
		assertEquals(3, fullArray.size());
		assertEquals(3, fullArray.getList().length);
		
		assertTrue(fullArray.delete(10));
		assertEquals(2, fullArray.size());
		assertEquals(3, fullArray.getList().length);
		assertTrue(fullArray.toString().equals("5, 13"));
	}
	
	@Test
	public void deleteFromNormalArrayTest() {
		assertEquals(3, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		
		assertTrue(normalArray.delete(10));
		assertEquals(2, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		assertTrue(normalArray.toString().equals("5, 13"));
	}
	
	@Test
	public void deleteNonExistentElementTest() {
		assertEquals(3, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		
		assertFalse(normalArray.delete(2));
		assertEquals(3, normalArray.size());
		assertEquals(4, normalArray.getList().length);
		assertTrue(normalArray.toString().equals("5, 10, 13"));
	}
	
	/*
	 * Find Tests
	 */
	
	@Test
	public void findInEmptyArrayTest() {
		assertFalse(emptyArray.find(5));
	}
	
	@Test
	public void findInFullArrayTest() {
		assertTrue(fullArray.find(10));
	}
	
	@Test
	public void findInNormalArrayTest() {
		assertTrue(normalArray.find(10));
	}
	
	@Test
	public void findNonExistentElementTest() {
		assertFalse(normalArray.find(12));
	}
	
	/*
	 * toString Tests
	 */
	
	@Test
	public void emptyArrayToStringTest() {
		assertTrue(emptyArray.toString().equals(""));
	}
	
	@Test
	public void fullArrayToStringTest() {
		assertTrue(fullArray.toString().equals("5, 10, 13"));
	}
	
	@Test
	public void normalArrayToStringTest() {
		assertTrue(normalArray.toString().equals("5, 10, 13"));
	}
}
