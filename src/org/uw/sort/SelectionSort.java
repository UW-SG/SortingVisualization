package org.uw.sort;

/**
 * Sorting 
 * @author Sonam Gupta
 *
 */
public class SelectionSort implements Sort
{

	@Override
	public String getName() {
		return "Selection Sort";
	}
	
	public void sort(DrawArray array) 
	{
		
		for (int i = 0; i < array.length(); i++) {
			int minindex = i;
			for (int j = i; j < array.length(); j++) {
				if (array.compare(j, minindex) < 0)
					minindex = j;
			}
			array.swap(i, minindex);
			array.setDone(i);
		}
	}
	
	public void sort(int[] arr) 
	{
		int least, counter1, counter2;
		for(counter1 = 0 ; counter1 < arr.length-1; counter1++) { 
			
			least = counter1;                       /* take the 1st element as min to start with */
			
			for(counter2 = counter1+1 ; counter2 < arr.length; counter2++) 
			{ 
				/* if this element is less, then it is the new minimum */ 
				if(arr[counter2] < arr[least]) 
				{
					least = counter2;                  
					/* Found a new min element; note its position in the array */
				}
			}
			/**
			 * Not Using temp variable to swap
			 */
			if(least != counter1) 
			{                   /* Swap it with the current position */
				arr[counter1] = arr[counter1] + arr[least];
				arr[least] = arr[counter1] - arr[least];
				arr[counter1] = arr[counter1] - arr[least];
			}
		}
	}

}
