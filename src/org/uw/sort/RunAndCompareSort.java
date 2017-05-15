package org.uw.sort;

import java.util.ArrayList;
import java.util.List;

import org.uw.sort.sortedness.MergeSort;

public class RunAndCompareSort {

	public static void main(String[] args) 
	{
		sortAndCompare();
	}

	private static void sortAndCompare() {

		//Getting the list of algos to be analysed
		List<Sort> algos = new ArrayList<Sort>(5);
		algos.add(new QuickSort());
		algos.add(new MergeSort());
		algos.add(new SelectionSort());
		algos.add(new InsertionSort());		
		algos.add(new BubbleSort());

		for(int j =0; j < algos.size(); j++) 
		{
			Sort algorithm = algos.get(j);
			
			SortingHelper.analyseSyntheticDataset1(algorithm);
			
			SortingHelper.analyseSynthecticDataset2(algorithm);

			SortingHelper.analyseRealDataset1(algorithm);

			SortingHelper.analyseRealDataset2(algorithm);
		}
	}

}
