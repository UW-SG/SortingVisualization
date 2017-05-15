package org.uw.sort;


public class MergeSort implements Sort {

	private static int[] array;
    private static int[] mergeArray;
    private int length;
    
    public void sort(int inputArr[]) 
    {
        this.array = inputArr;
        this.length = inputArr.length;
        this.mergeArray = new int[length];
        mergesort(null, 0, length - 1);
        this.array = null;
        this.mergeArray = null;
    }

    @Override
	public void sort(DrawArray dataset) 
	{
    	this.array = dataset.values;
    	this.mergeArray = new int[dataset.length()];
		mergesort(dataset, 0 , dataset.length());
	}
    
    @Override
	public String getName() {
		return "Merge Sort";
	}
    
    //Adapted the original implementation to use compareAndSwap for highlighting 
  	//and swapping for visualization
  	public static void mergesort(DrawArray array, int low, int hi) 
  	{
  		if (low >= hi)
  			return;
  		
  		array.setInactive(low, hi);
  		int partition = low;
  		int high = hi - 1;  // Do not change this!
  		for (int i = low; i < hi - 1; i++) {
  			if (array.compare(i, high) < 0) {
  				array.swap(i, partition);
  				array.setInactive(partition);
  				partition++;
  			}
  		}
  		array.swap(high, partition);
  		high = partition;
  		array.setDone(high);
  		array.setInactive(high + 1, hi);  		
  		
  		mergesort(array, low, high);
  		mergesort(array, high + 1, hi);
  		mergeSortedSubArrays(array, low, partition, high);
  	}

  
    public static void mergeSortedSubArrays(DrawArray dataset, int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) 
        {
            mergeArray[i] = array[i];
//            dataset.compare(i, i+1);
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        
        while (i <= middle && j <= higherIndex) 
        {
            if (mergeArray[i] <= mergeArray[j]) 
            {
            	dataset.swap(k, i);
                array[k] = mergeArray[i];
                i++;
            } else 
            {
                array[k] = mergeArray[j];
            	dataset.swap(k, j);
                j++;
            }
            k++;
        }
        while (i <= middle) 
        {
        	dataset.swap(k, i);
            array[k] = mergeArray[i];
            k++;
            i++;
        }
        
        dataset.setDone(lowerIndex, higherIndex+1);
    }

}
