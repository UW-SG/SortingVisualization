package org.uw.sort.sortedness;

import org.uw.sort.Sort;
import org.uw.sort.SortingHelper;
import org.uw.sort.DrawArray;;


public class MergeSort implements Sort {

	private int[] array;
    private int[] mergeArray;
    private int length;
 
    public static void main(String[] args) 
    {
    	MergeSort sort = new MergeSort();
    	SortingHelper.analyseRealDataset2(sort);
	}
    
    public void sort(int inputArr[]) 
    {
        this.array = inputArr;
        this.length = inputArr.length;
        this.mergeArray = new int[length];
        doMergeSort(0, length - 1);
        this.array = null;
        this.mergeArray = null;
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) 
        {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            
            // Now merge both sides
            mergeSortedSubArrays(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeSortedSubArrays(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) 
        {
            mergeArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) 
        {
            if (mergeArray[i] <= mergeArray[j]) 
            {
                array[k] = mergeArray[i];
                i++;
            } else {
                array[k] = mergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = mergeArray[i];
            k++;
            i++;
        }
    }

	@Override
	public void sort(DrawArray dataset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Merge Sort";
	}
}
