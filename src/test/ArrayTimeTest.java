package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import code.Array;

public class ArrayTimeTest {

	Array array10;
	int[] list10;
	Array array50;
	int[] list50;
	Array array100;
	int[] list100;
	Array array500;
	int[] list500;
	Array array1000;
	int[] list1000;
	Random r;
	
	@Before
	public void setUp() throws Exception {
		array10 = new Array();
		list10 = new int[10];
		array50 = new Array();
		list50 = new int[50];
		array100 = new Array();
		list100 = new int[100];
		array500 = new Array();
		list500 = new int[500];
		array1000 = new Array();
		list1000 = new int[1000];
		
		r = new Random();
		int current = 0;
		for(int i = 0; i<10; i++) {
			current = r.nextInt();
			array10.insert(current);
			list10[i] = current;
		}
		
		for(int i = 0; i<50; i++) {
			current = r.nextInt();
			array50.insert(current);
			list50[i] = current;
		}
		
		for(int i = 0; i<100; i++) {
			current = r.nextInt();
			array100.insert(current);
			list100[i] = current;
		}
		
		for(int i = 0; i<500; i++) {
			current = r.nextInt();
			array500.insert(current);
			list500[i] = current;
		}
		
		for(int i = 0; i<1000; i++) {
			current = r.nextInt();
			array1000.insert(current);
			list1000[i] = current;
		}
	}

	@Test
	public void timeTestOf10ElementArray() {
		System.out.println("Regarding 10 Element Array...");
		long before = System.nanoTime();
		array10.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list10[4];
		before = System.nanoTime();
		array10.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		array10.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		array10.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf50ElementArray() {
		System.out.println("Regarding 50 Element Array...");
		long before = System.nanoTime();
		array50.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list50[25];
		before = System.nanoTime();
		array50.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		array50.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		array50.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf100ElementArray() {
		System.out.println("Regarding 100 Element Array...");
		long before = System.nanoTime();
		array100.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list100[50];
		before = System.nanoTime();
		array100.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		array100.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		array100.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf500ElementArray() {
		System.out.println("Regarding 500 Element LinkedList...");
		long before = System.nanoTime();
		array500.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list500[250];
		before = System.nanoTime();
		array500.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		array500.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		array500.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf1000ElementArray() {
		System.out.println("Regarding 1000 Element Array...");
		long before = System.nanoTime();
		array1000.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list1000[500];
		before = System.nanoTime();
		array1000.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		array1000.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		array1000.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}

}
