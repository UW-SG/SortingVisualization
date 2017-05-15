package org.uw.sort;


/**
 * @author Sonam Gupta
 *
 */
public class QuickSort implements Sort {

	// This class should not be instantiated.
	public QuickSort() { }
	

	@Override
	public void sort(DrawArray dataset) 
	{
		sort(dataset, 0 , dataset.length());
	}

	@Override
	public String getName() {
		return "Quick Sort";
	}
	
	//Adapted the original implementation to use compareAndSwap for highlighting 
	//and swapping for visualization
	public static void sort(DrawArray array, int start, int end) 
	{
		if (start == end)
			return;
		
		array.setInactive(start, end);
		int partition = start;
		int pivot = end - 1;  // Do not change this!
		for (int i = start; i < end - 1; i++) {
			if (array.compare(i, pivot) < 0) {
				array.swap(i, partition);
				array.setInactive(partition);
				partition++;
			}
		}
		
		array.swap(pivot, partition);
		pivot = partition;
		array.setDone(pivot);
		array.setInactive(pivot + 1, end);
		
		sort(array, start, pivot);
		sort(array, pivot + 1, end);
	}
	
	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * @param a the array to be sorted
	 */
	public void sort(int[] a) 
	{
		sort(a, 0, a.length - 1);
	}

	// exchange a[i] and a[j] without using temp variable
	private static void swap(int[] a, int i, int j) 
	{
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(int[] dataset, int low, int high) 
	{ 
		if (high <= low) return;
		int j = doQuickSort(dataset, low, high);
		sort(dataset, low, j-1);
		sort(dataset, j+1, high);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int doQuickSort(int[] dataset, int low, int high) 
	{
		int lowIndex = low;
		int highIndex = high + 1;
		int lowVal = dataset[low];
		
		while (true) 
		{ 

			// find item on lo to swap
			while (less(dataset[++lowIndex], lowVal))
				if (lowIndex == high) break;

			// find item on hi to swap
			while (less(lowVal, dataset[--highIndex]))
				if (highIndex == low) break;      // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (lowIndex >= highIndex) break;

			swap(dataset, lowIndex, highIndex);
		}

		// put partitioning item v at a[j]
		swap(dataset, low, highIndex);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return highIndex;
	}

	/**
	 * Rearranges the dataset so that a[k] has the kth smallest number;
	 * a[0] through a[k-1] are less than (or equal to) a[k]; and
	 * a[k+1] through a[N-1] are greater than (or equal to) a[k].
	 * @param dataset the array
	 * @param value find the kth smallest
	 */
	public static int rearrange(int[] dataset, int value)
	{
		if (value < 0 || value >= dataset.length) {
			throw new IndexOutOfBoundsException("Selected element out of bounds");
		}
		int lo = 0, hi = dataset.length - 1;
		while (hi > lo) 
		{
			int i = doQuickSort(dataset, lo, hi);
			if      (i > value) hi = i - 1;
			else if (i < value) lo = i + 1;
			else return dataset[i];
		}
		return dataset[lo];
	}

	 // Helper sorting functions.

	// is v < w ?
	private static boolean less(int v, int w) 
	{
		return v < w;
	}

}

