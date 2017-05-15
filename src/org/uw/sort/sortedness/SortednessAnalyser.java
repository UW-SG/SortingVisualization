package org.uw.sort.sortedness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.uw.sort.BubbleSort;
import org.uw.sort.InsertionSort;
import org.uw.sort.QuickSort;
import org.uw.sort.SelectionSort;
import org.uw.sort.Sort;
import org.uw.sort.SortingHelper;
import org.uw.sort.datasets.RealData;
import org.uw.sort.datasets.SyntheticData;

public class SortednessAnalyser {
	
	private SortednessAnalyser() {}
	
	/**
	 * This method gets the same size data each time for each loop, but with different 
	 * sortedness i.e. correlation here. This would help to know the runtime and
	 * memory of the data when different sortedness values are used for sorting with 
	 * all the algorithms.
	 */
	public void analyseAllAlgorithmsForSyntheticData() 
	{
		
		//Getting the list of algos to be analysed
		List<Sort> algos = new ArrayList<Sort>(5);
		algos.add(new QuickSort());
		algos.add(new MergeSort());
		algos.add(new SelectionSort());
		algos.add(new InsertionSort());
		algos.add(new BubbleSort());
		
		for(int i = 0; i < 1; i++) 
		{
//			int[] data = SyntheticData.getSmallSyntheticSortednessDataset2(5000);
			
			int[] data = SyntheticData.getLargeSyntheticSortednessData(20);
			System.out.println("Starting for new DATA SET ");

			for(int j =0; j < algos.size(); j++) 
			{
				Sort algorithm = algos.get(j);
				printCorrelation(data);
				int[] dataset = new int[data.length];
				System.arraycopy(data, 0, dataset, 0, data.length);
				SortingHelper.sortAndPrintSortedness(dataset, algorithm);;
				System.out.println("***********************************************************************************");
				System.out.println();
//				data = null;
//				Runtime.getRuntime().gc();
			}
		}
	}
	

	public static void main(String[] args) 
	{
		SortednessAnalyser sa = new SortednessAnalyser();
		sa.analyseAllAlgorithmsForSyntheticData();
	}
	

	
	/**
	 * This method gets the same size data each time for each loop, but with different 
	 * sortedness i.e. correlation here. This would help to know the runtime and
	 * memory of the data when different sortedness values are used for sorting with 
	 * all the algorithms.
	 */
	public void analyseAllAlgorithmsForRealData() {
		
		//Getting the list of algos to be analysed
		List<Sort> algos = new ArrayList<Sort>(5);
		algos.add(new QuickSort());
		algos.add(new MergeSort());
		algos.add(new SelectionSort());
		algos.add(new InsertionSort());
		algos.add(new BubbleSort());
		
		for(int i = 0; i < 1; i++) 
		{
//			int[] data = RealData.getLargeSortednessData(14200);
			
			int[] data = RealData.getTextSortednessData(14200);
			shuffle(data);

			System.out.println("Starting for new DATA SET ");

			for(int j =0; j < algos.size(); j++) 
			{
				Sort algorithm = algos.get(j);
				printCorrelation(data);
				int[] dataset = new int[data.length];
				System.arraycopy(data, 0, dataset, 0, data.length);
				SortingHelper.sortAndPrintStatistics(dataset, algorithm);;
				System.out.println("***********************************************************************************");
				System.out.println();
//				data = null;
//				Runtime.getRuntime().gc();
			}
		}
	}
	
	public static void shuffle(int[] array) 
	{
		Random random = new Random();
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	static private void printCorrelation(int[] arr) 
	{
		SortednessMeasure cor = new SortednessMeasure();
		
		double [] sortedArr = new double [arr.length];
		double [] originalArray = new double [arr.length];

		for(int i=0; i < arr.length; i++) 
		{
			sortedArr[i] = arr[i];
			originalArray[i] = arr[i];
		}
		Arrays.sort(sortedArr);
		double correlationResult = cor.correlation(originalArray, sortedArr);
		System.out.println("CORRELATION CO-EFFICIENT : " + Math.abs(correlationResult));
	}
	
	public static void analyseSyntheticDataset1(final Sort algorithm) 
    {
		int[] dataset1 =  SyntheticData.getLargeSyntheticDataSetSub(5000);
		printCorrelation(dataset1);
    	SortingHelper.sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset2 =  SyntheticData.getLargeSyntheticDataSetSub(10000);
		printCorrelation(dataset2);
    	SortingHelper.sortAndPrintStatistics(dataset2, algorithm);
    	
    	int[] dataset3 =  SyntheticData.getLargeSyntheticDataSetSub(50000);
		printCorrelation(dataset3);
    	SortingHelper.sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  SyntheticData.getLargeSyntheticDataSetSub(100000);
		printCorrelation(dataset4);
    	SortingHelper.sortAndPrintStatistics(dataset4, algorithm);
    	
    	int[] dataset5 =  SyntheticData.getLargeSyntheticDataSetSub(500000);
		printCorrelation(dataset5);
    	SortingHelper.sortAndPrintStatistics(dataset5, algorithm);
    	
		Runtime.getRuntime().gc();
    }

    /**
     * Returns the number of inversions in the input array
     * 
     * @param a the input array
     * @return  the number of inversions.
     * 
     */
    public static int countInversions(int[] a) 
    {
        return mergeSort(a, 0, a.length);
    }

    private static int mergeSort (int[] a, int low, int high) {
        if (low == high - 1) return 0;

        int mid = (low + high)/2;

        return mergeSort (a, low, mid) + mergeSort (a, mid, high) + merge (a, low, mid, high);
    }

    private static int merge (int[] a, int low, int mid, int high) 
    {
        int count = 0;
        int[] temp = new int[a.length];

       for (int i = low, lb = low, hb = mid; i < high; i++) {

            if (hb >= high || lb < mid && a[lb] <= a[hb]) {
                temp[i]  = a[lb++];
            } else {
                count = count + (mid - lb); 
                temp[i]  = a[hb++];
            } 
       }
       System.arraycopy(temp, low, a, low, high - low);
       return count;
    }
 }
