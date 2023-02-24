package code;

/**
 * An instance of the Array class is capable of storing Integer values in a built-in java Array. When ints are inserted
 * into the array, the array will automatically sort the inserted element to preserve the sorted order in the array.
 * An Array object is capable of reporting its size, inserting elements in sorted order, deleting elements, finding
 * elements, and outputting the array in string form.
 * 
 * @author Alan Rosenberg
 *
 */
public class Array {
	
	Integer[] array;
	
	public Array() {
		array = new Integer[128];
	}
	
	/**
	 * Size method will return the size of the array. It will do so by walking the length of the array, incrementing
	 * a counter as it goes, until it reaches null, signaling the end of populated slots in the array.
	 * 
	 * This method belongs to O(n)
	 * @return int size of the array
	 */
	public int size() {
		
		//Establishing incrementing variable
		int i = 0;
		
		//Walking the array...
		while(i < array.length) {
			
			//When null is found, breaking the loop
			if(array[i] == null) {
				break;
			}
			
			//incrementin...
			i++;
		}
		
		//returning number of elements in the array
		return i;
	}
	
	/**
	 * Insert fuction will insert values into the array in sorted order. The algorithm will walk the array looking for
	 * a value greater than or equal to the parameter. Once found, the algorithm will place a parameter in
	 * the array such that the sorted order is preserved. The parameter will take the place of the element greater than it,
	 * and every element following will be shifted down the array by one index.
	 * 
	 * If the array outgrows its size, the algorithm will create a new array with double the size, copy the data into the
	 * new array, and then perform the insertion as described above.
	 * 
	 * This method belongs to O(n^2)
	 * @param int value to be inserted into the array
	 */
	public void insert(int val) {
		
		//Covering full array case, creating an array of double size and copying all data into new array
		if(this.size() == array.length) {
			
			//Holding onto old data while double array size
			Integer[] temp = array;
			array = new Integer[array.length*2];
			
			//Copying array elements into the larger array
			for(int i = 0; i < temp.length; i++) {
				array[i] = temp[i];
			}
		}
		
		//Establishing incrementing variable
		int i = 0;
		
		//Walking the array...
		while(array[i] != null) {
			
			//When a lesser element is found, executing insertion...
			if(val < array[i]) {
				
				//Starting at the last element, all elements get shifted back by one index
				for(int j = this.size(); j > i; j--) {
					array[j] = array[j-1];
				}
				
				//Inserting new element
				Integer newVal = val;
				array[i] = newVal;
				return;
			}
			
			//walkin...
			i++;
		}
		
		//When element for insertion is larger than all elements, appending
		Integer newVal = val;
		array[i] = newVal;
	}
	
	/**
	 * Delete method will remove an item from the array. It does so by first finding the item (if it exists in the array),
	 * then shifting all following elements back by one index.
	 * 
	 * This method belongs to O(n^2)
	 * @param int value intended for deletion
	 * @return true if element is found in the array and deleted, false if not.
	 */
	public boolean delete(int val) {
		
		//Covering empty array case, returning false, no possible matches
		if(array[0] == null) {
			return false;
		}
		
		//Establishing incrementing variable
		int i = 0;
		
		//Walking the array...
		while(array[i] != null) {
			
			//When a match is found, shifting all following elements back one index and returning true
			if(array[i] == val) {
				int j = i;
				while(j < this.size()-1) {
					
					array[j] = array[j+1];
					
					j++;
				}
				
				//Covering full array case, inserting null in place of last element, finalizing backward shift
				array[j] = null;
				return true;
			}
			
			//walkin...
			i++;
		}
		
		//When no matches are found, returning false
		return false;
	}
	
	/**
	 * Find method will take the parameter and look for a matching element in the array. It will do so by walking the array,
	 * checking for a match as it goes.
	 * 
	 * Find belongs to O(n)
	 * @param int value for which the algorithm searches for a match
	 * @return true if a match is found, false if not
	 */
	public boolean find(int val) {
		
		//Establishing incrementing variable
		int i = 0;
		
		//Walking the array...
		while(array[i] != null) {
			
			//When a match is found, return true
			if(array[i] == val) {
				return true;
			}
			
			//walkin...
			i++;
		}
		
		//When no match is found, return false
		return false;
	}
	
	/**
	 * toString will read the content of the array, and generate a String with the int values stored. It will do so by walking
	 * the array, reading the values at each index, and appending the value to the string to be returned.
	 * 
	 * This method belongs to O(n)
	 * @return string of all values stored in the array
	 */
	public String toString() {
		
		//String to build into
		String s = "";
		
		//Covering empty array case, returning empty string
		if(this.size() == 0) {
			return s;
		}
		
		//Starting with first element, makes output prettier this way
		s = String.valueOf(array[0]);
		
		//Appending elements to the string stylishly
		for(int i = 1; i < this.size(); i++) {
			if(array[i] != null) {
				s = s + ", " + array[i];
			}
		}
		
		//Returning built string
		return s;
	}

	/*
	 * Getters and Setters
	 */
	public Integer[] getList() {
		return array;
	}

	public void setList(Integer[] list) {
		this.array = list;
	}
}
