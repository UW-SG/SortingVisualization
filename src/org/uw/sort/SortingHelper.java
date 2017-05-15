package org.uw.sort;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.uw.sort.datasets.RealData;
import org.uw.sort.datasets.SyntheticData;
import org.uw.sort.sortedness.LongestIncreasingSubSequence;

public class SortingHelper {
	
	static void analyseSortedNess(final Sort algorithm) 
	{
		int[] unsortedArr11Percent = LongestIncreasingSubSequence.get11PercentSorted();
		sortAndPrintStatistics(unsortedArr11Percent, algorithm);

		int[] unsortedArr33Percent = LongestIncreasingSubSequence.get33PercentSorted();
		sortAndPrintStatistics(unsortedArr33Percent, algorithm);

		int[] unsortedArr54Percent = LongestIncreasingSubSequence.get54PercentSorted();
		sortAndPrintStatistics(unsortedArr54Percent, algorithm);

		int[] unsortedArr66Percent = LongestIncreasingSubSequence.get66PercentSorted();
		sortAndPrintStatistics(unsortedArr66Percent, algorithm);

		int[] unsortedArr88Percent = LongestIncreasingSubSequence.get88PercentSorted();
		sortAndPrintStatistics(unsortedArr88Percent, algorithm);
		
		Runtime.getRuntime().gc();
	}
    
    static void analyseSynthecticDataset1(final Sort algorithm) 
    {
		int[] dataset1 =  SyntheticData.getLargeSyntheticDataSet(5000);
    	sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset2 =  SyntheticData.getLargeSyntheticDataSetSub1(10000);
    	sortAndPrintStatistics(dataset2, algorithm);
    	
    	int[] dataset3 =  SyntheticData.getLargeSyntheticDataSetSub2(50000);
//    	Arrays.sort(dataset3);
    	
    	sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  SyntheticData.getLargeSyntheticDataSetSub3(100000);
    	sortAndPrintStatistics(dataset4, algorithm);
//    	
    	int[] dataset5 =  SyntheticData.getLargeSyntheticDataSetSub4(100000);
    	sortAndPrintStatistics(dataset5, algorithm);
    	
		Runtime.getRuntime().gc();
    }
    
    static void analyseSynthecticDataset2(final Sort algorithm) 
    {
    	
		int[] dataset1 =  SyntheticData.getSmallSyntheticDataSet1(5);
    	sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset3 =  SyntheticData.getSmallSyntheticDataSet2(50);
    	sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  SyntheticData.getSmallSyntheticDataSet3(500);
    	sortAndPrintStatistics(dataset4, algorithm);
    	
    	int[] dataset5 =  SyntheticData.getSmallSyntheticDataSet4(3000);
    	sortAndPrintStatistics(dataset5, algorithm);
    	
    	int[] dataset6 =  SyntheticData.getSmallSyntheticDataSet5(7000);
    	sortAndPrintStatistics(dataset6, algorithm);
    	
		Runtime.getRuntime().gc();

    }
    
    /**
	 * This data is real that is obtained from an excel as in the method below, however
	 * it is reverse sorted to verify its effect on different sorting algorithms
	 * 
	 * Also this list may have duplicates to verify if the sort is stable or not
	 * 
	 *  @param size. 
	 * @return
	 */
    
    static void analyseRealDataset1(final Sort algorithm) 
    {
		int[] dataset1 =  RealData.getRealDataSet1(5200);
    	sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset3 =  RealData.getRealDataSet1(12000);
    	sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  RealData.getRealDataSet1(21000);
    	sortAndPrintStatistics(dataset4, algorithm);
    	
    	int[] dataset5 =  RealData.getRealDataSet1(40000);
    	sortAndPrintStatistics(dataset5, algorithm);
    	
    	int[] dataset6 =  RealData.getRealDataSet1(61000);
    	sortAndPrintStatistics(dataset6, algorithm);
    	
		Runtime.getRuntime().gc();
    }
    
    public static void analyseRealDataset2(final Sort algorithm) 
    {
    	int[] dataset =  RealData.getRealDataSet2(2);
    	sortAndPrintStatistics(dataset, algorithm);
    	
    	int[] dataset1 =  RealData.getRealDataSet2(5);
    	sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset3 =  RealData.getRealDataSet2(8);
    	sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  RealData.getRealDataSet2(12);
    	sortAndPrintStatistics(dataset4, algorithm);
    	
    	int[] dataset5 =  RealData.getRealDataSet2(16);
    	sortAndPrintStatistics(dataset5, algorithm);
    	
		Runtime.getRuntime().gc();
    }
    
    public static void analyseSyntheticDataset1(final Sort algorithm) 
    {
		int[] dataset1 =  SyntheticData.getLargeSyntheticDataSetSub(5000);
    	SortingHelper.sortAndPrintStatistics(dataset1, algorithm);
    	
    	int[] dataset2 =  SyntheticData.getLargeSyntheticDataSetSub(10000);
    	SortingHelper.sortAndPrintStatistics(dataset2, algorithm);
    	
    	int[] dataset3 =  SyntheticData.getLargeSyntheticDataSetSub(50000);
    	SortingHelper.sortAndPrintStatistics(dataset3, algorithm);
    	
    	int[] dataset4 =  SyntheticData.getLargeSyntheticDataSetSub(100000);
    	SortingHelper.sortAndPrintStatistics(dataset4, algorithm);
    	
    	int[] dataset5 =  SyntheticData.getLargeSyntheticDataSetSub(500000);
    	SortingHelper.sortAndPrintStatistics(dataset5, algorithm);
    	
		Runtime.getRuntime().gc();
    }

    
	static public void sortAndPrintStatistics( int[] dataset, final Sort algorithm) {

    	Runtime.getRuntime().gc();
    	MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();

//    	System.out.println("-------------------------------------------------------------------------------------------");

//    	System.out.println();
    	System.out.println("ARRAY LENGTH : " + dataset.length);

    	long start = System.nanoTime();

    	algorithm.sort(dataset);

    	long end = System.nanoTime();
    	long elapsedTime = end - start;
    	long millis = elapsedTime/1000;
    	
//    	System.out.println("Time taken : " + elapsedTime + " nanosecond.");

    	MemoryUsage heap = memBean.getHeapMemoryUsage();

//    	System.out.println("---------------------------------------- Memory Used --------------------------------------");

    	System.out.println(" Memory used : " + heap.getUsed()/1000 + "KB");

//    	System.out.println(" Memory used : " + heap.getUsed()/1000000 + "MB");

//    	System.out.println("------------------------------------------ Running Time  ------------------------------------------");

    	System.out.println("Time taken : " + millis + " microsecond.");
    	
    	System.out.println("Time taken : " + millis/1000 + " millisecond.");

    	dataset = null;
    	
    	System.out.println("-------------------------------------------------------------------------------------------");

    	Runtime.getRuntime().gc();
    }
	
	static public void sortAndPrintSortedness( int[] dataset, final Sort algorithm) {

    	Runtime.getRuntime().gc();
    	MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();

    	long start = System.nanoTime();

    	algorithm.sort(dataset);

    	long end = System.nanoTime();
    	long elapsedTime = end - start;
    	long millis = elapsedTime/1000;
    	System.out.println("Time taken : " + millis + " MICRO.");
    	
    	MemoryUsage heap = memBean.getHeapMemoryUsage();


    	System.out.println(" Memory used : " + heap.getUsed()/1000 + "KB");


    	dataset = null;
    	
    	System.out.println("-------------------------------------------------------------------------------------------");

    	Runtime.getRuntime().gc();
    }

}
