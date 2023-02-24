package test;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import code.LinkedList;

public class LinkedListTimeTest {
	
	LinkedList lList10;
	int[] list10;
	LinkedList lList50;
	int[] list50;
	LinkedList lList100;
	int[] list100;
	LinkedList lList500;
	int[] list500;
	LinkedList lList1000;
	int[] list1000;
	Random r;

	@Before
	public void setUp() throws Exception {
		lList10 = new LinkedList();
		list10 = new int[10];
		lList50 = new LinkedList();
		list50 = new int[50];
		lList100 = new LinkedList();
		list100 = new int[100];
		lList500 = new LinkedList();
		list500 = new int[500];
		lList1000 = new LinkedList();
		list1000 = new int[1000];
		
		r = new Random();
		int current = 0;
		for(int i = 0; i<10; i++) {
			current = r.nextInt();
			lList10.insert(current);
			list10[i] = current;
		}
		
		for(int i = 0; i<50; i++) {
			current = r.nextInt();
			lList50.insert(current);
			list50[i] = current;
		}
		
		for(int i = 0; i<100; i++) {
			current = r.nextInt();
			lList100.insert(current);
			list100[i] = current;
		}
		
		for(int i = 0; i<500; i++) {
			current = r.nextInt();
			lList500.insert(current);
			list500[i] = current;
		}
		
		for(int i = 0; i<1000; i++) {
			current = r.nextInt();
			lList1000.insert(current);
			list1000[i] = current;
		}
	}

	@Test
	public void timeTestOf10ElementList() {
		
		System.out.println("Regarding 10 Element LinkedList...");
		long before = System.nanoTime();
		lList10.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int fifth = list10[4];
		before = System.nanoTime();
		lList10.insert(fifth);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		lList10.find(fifth);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		lList10.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf50ElementList() {
		System.out.println("Regarding 50 Element LinkedList...");
		long before = System.nanoTime();
		lList50.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list50[25];
		before = System.nanoTime();
		lList50.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		lList50.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		lList50.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf100ElementList() {
		System.out.println("Regarding 100 Element LinkedList...");
		long before = System.nanoTime();
		lList100.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list100[50];
		before = System.nanoTime();
		lList100.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		lList100.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		lList100.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf500ElementList() {
		System.out.println("Regarding 500 Element LinkedList...");
		long before = System.nanoTime();
		lList500.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list500[250];
		before = System.nanoTime();
		lList500.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		lList500.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		lList500.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf1000ElementList() {
		System.out.println("Regarding 1000 Element LinkedList...");
		long before = System.nanoTime();
		lList1000.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list1000[500];
		before = System.nanoTime();
		lList1000.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		lList1000.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		lList1000.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}

}
