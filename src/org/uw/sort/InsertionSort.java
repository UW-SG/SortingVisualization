package org.uw.sort;

public class InsertionSort implements Sort {

	public void sort(final int dataset[])
	{
		int var2, var1, key;
		
		for(var1 = 1; var1 < dataset.length-1; var1++)
		{
			key = dataset[var1];
			var2 = var1; // range 0 to var2-1 is sorted 
			
			while(var2 > 0 && dataset[var2 - 1 ] >= key)
			{
				dataset[var2] = dataset[var2 - 1];
				var2--; 
			}
			dataset[var2] = key;
		} 
	} // end insertion sort
	
	public void sort(DrawArray array) 
	{
		
		array.setInactive(0, array.length());
		for (int i = 0; i < array.length(); i++) 
		{
			for (int j = i; j >= 1 && array.compareAndSwap(j - 1, j); j--);
		}
		array.setDone(0, array.length());
	}

	@Override
	public String getName() {
		return "Insertion Sort";
	}

	
	
}
