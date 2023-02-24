package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import code.BinarySearchTree;

public class BinarySearchTreeTimeTest {

	BinarySearchTree tree10;
	int[] list10;
	BinarySearchTree tree50;
	int[] list50;
	BinarySearchTree tree100;
	int[] list100;
	BinarySearchTree tree500;
	int[] list500;
	BinarySearchTree tree1000;
	int[] list1000;
	Random r;
	
	@Before
	public void setUp() throws Exception {
		tree10 = new BinarySearchTree();
		list10 = new int[10];
		tree50 = new BinarySearchTree();
		list50 = new int[50];
		tree100 = new BinarySearchTree();
		list100 = new int[100];
		tree500 = new BinarySearchTree();
		list500 = new int[500];
		tree1000 = new BinarySearchTree();
		list1000 = new int[1000];
		
		r = new Random();
		int current = 0;
		for(int i = 0; i<10; i++) {
			current = r.nextInt();
			tree10.insert(current);
			list10[i] = current;
		}
		
		for(int i = 0; i<50; i++) {
			current = r.nextInt();
			tree50.insert(current);
			list50[i] = current;
		}
		
		for(int i = 0; i<100; i++) {
			current = r.nextInt();
			tree100.insert(current);
			list100[i] = current;
		}
		
		for(int i = 0; i<500; i++) {
			current = r.nextInt();
			tree500.insert(current);
			list500[i] = current;
		}
		
		for(int i = 0; i<1000; i++) {
			current = r.nextInt();
			tree1000.insert(current);
			list1000[i] = current;
		}
	}

	@Test
	public void timeTestOf10ElementTree() {
		System.out.println("Regarding 10 Element Tree...");
		long before = System.nanoTime();
		tree10.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list10[4];
		before = System.nanoTime();
		tree10.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		tree10.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		tree10.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTest50ElementTree() {
		System.out.println("Regarding 50 Element Tree...");
		long before = System.nanoTime();
		tree50.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list50[25];
		before = System.nanoTime();
		tree50.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		tree50.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		tree50.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf100ElementTree() {
		System.out.println("Regarding 100 Element Tree...");
		long before = System.nanoTime();
		tree100.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list100[50];
		before = System.nanoTime();
		tree100.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		tree100.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		tree100.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf500ElementTree() {
		System.out.println("Regarding 500 Element Tree...");
		long before = System.nanoTime();
		tree500.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list500[250];
		before = System.nanoTime();
		tree500.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		tree500.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		tree500.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}
	
	@Test
	public void timeTestOf1000ElementTree() {
		System.out.println("Regarding 1000 Element Tree...");
		long before = System.nanoTime();
		tree1000.insert(r.nextInt());
		long after = System.nanoTime();
		long diff = after - before;
		
		System.out.println("Time to insert: " + diff);
		
		int median = list1000[500];
		before = System.nanoTime();
		tree1000.insert(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to delete: " + diff);
		
		before = System.nanoTime();
		tree1000.find(median);
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to find: " + diff);
		
		before = System.nanoTime();
		tree1000.toString();
		after = System.nanoTime();
		diff = after - before;
		
		System.out.println("Time to String: " + diff + "\n\n");
	}

}
