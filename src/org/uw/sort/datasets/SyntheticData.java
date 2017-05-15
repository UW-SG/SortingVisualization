package org.uw.sort.datasets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uw.sort.Sort;
import org.uw.sort.SortingHelper;

/*
 * Utility class for dataset generation, generates random Gaussain and distributed data sets for 
 * sorting algorithms. In order to make sure all the algortihsm are dealing with the same data,
 * the data is generated and wrote a file for the all the sorting algos to pick up.
 * The datasets are further divided into sizes to get a perfect curve on the graphs.
 */
public class SyntheticData {

	//only static access
	private SyntheticData(){}
	
	
	static public int[] getLargeSyntheticDataSet(int size) {

		int[] arr = readArrayFromFile("subLfile.txt");

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, "subLfile.txt");

			arr = readArrayFromFile("subLfile.txt");
		}
		return arr;
	}
	
	
	static public int[] getLargeSyntheticDataSetSub1(int size) {

		int[] arr = readArrayFromFile("subLfile1.txt");

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, "subLfile1.txt");

			arr = readArrayFromFile("subLfile1.txt");
		}
		return arr;
	}
	
	static public int[] getLargeSyntheticDataSetSub(int size) {

		String fileName = "Dataset_" + size + ".txt";

		int[] arr = readArrayFromFile(fileName);

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, fileName);

			arr = readArrayFromFile(fileName);
		}
		return arr;
	}
	
	
	static public int[] getLargeSyntheticDataSetSub2(int size) {

		int[] arr = readArrayFromFile("subLfile2.txt");

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, "subLfile2.txt");

			arr = readArrayFromFile("subLfile2.txt");
		}
		return arr;
	}
	
	static public int[] getLargeSyntheticSortednessData(int size) 
	{
			Random r = new Random();
			int[] dataset = r.ints(size, 0, size+1).toArray();
			return dataset;
	}
	
	static public int[] getSmallSyntheticSortednessDataset2(int size) 
	{
			Random r = new Random();
			int[] dataset = r.ints(size, 0, 50000).toArray();
			return dataset;
	}
	
	static public int[] getLargeSyntheticDataSetSub3(int size) {

		int[] arr = readArrayFromFile("subLfile3.txt");

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, "subLfile3.txt");

			arr = readArrayFromFile("subLfile3.txt");
		}
		return arr;
	}
	static public int[] getLargeSyntheticDataSetSub4(int size) {

		int[] arr = readArrayFromFile("subLFile4.txt");

		if(arr == null || arr.length ==0) 
		{
			Random r = new Random();

			int[] dataset = r.ints(size, 0, size).toArray();

			writeArrayToFile(dataset, "subLFile4.txt");

			arr = readArrayFromFile("subLFile4.txt");
		}
		return arr;
	}


	public static void main(String[] args) 
	{
//		int[] arr = getLargeSyntheticDataSet(1000000);
		
//		deleteFiles();
//		System.out.println(arr);
	}

	private static void writeArrayToFile(int[] dataset, String file) {

		try {

			FileWriter fw = new FileWriter(file);
			Writer output = new BufferedWriter(fw);
			int size = dataset.length;
			for(int i =0; i < size; i++) 
			{
				output.write(String.valueOf(dataset[i]) + "\n");
			}
			output.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	
	static private int[] readArrayFromFile(String file) {

		try {
			
			String line;
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader input = new BufferedReader(new FileReader(file));
			while((line = input.readLine()) != null) {
				list.add(Integer.valueOf(line));
			}
			input.close();

			int size = list.size();
			int dataset[] = new int[list.size()];
			for(int i=0; i < size; i++) {
				dataset[i] = list.get(i);
			}
			return dataset;

		} catch (IOException e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	static public int[] getSmallSyntheticDataSet1(int size) {

		int[] dataset = readArrayFromFile("subSFile1.txt");

		if(dataset == null || dataset.length ==0) 
		{
			Random r = new Random();

			dataset = new int[size];
			for(int i=0; i < size; i++) 
			{
				dataset[i] = r.nextInt();
			}

			writeArrayToFile(dataset, "subSFile1.txt");

			dataset = readArrayFromFile("subSFile1.txt");
		}
		return dataset;
	}
	
	static public int[] getSmallSyntheticDataSet2(int size) {

		int[] dataset = readArrayFromFile("subSFile2.txt");

		if(dataset == null || dataset.length ==0) 
		{
			Random r = new Random();

			dataset = new int[size];
			for(int i=0; i < size; i++) 
			{
				dataset[i] = r.nextInt();
			}

			writeArrayToFile(dataset, "subSFile2.txt");

			dataset = readArrayFromFile("subSFile2.txt");
		}
		return dataset;
	}
	
	static public int[] getSmallSyntheticDataSet3(int size) {

		int[] dataset = readArrayFromFile("subSFile3.txt");

		if(dataset == null || dataset.length ==0) 
		{
			Random r = new Random();

			dataset = new int[size];
			for(int i=0; i < size; i++) 
			{
				dataset[i] = r.nextInt();
			}

			writeArrayToFile(dataset, "subSFile3.txt");

			dataset = readArrayFromFile("subSFile3.txt");
		}
		return dataset;
	}
	
	static public int[] getSmallSyntheticDataSet4(int size) {

		int[] dataset = readArrayFromFile("subSFile4.txt");

		if(dataset == null || dataset.length ==0) 
		{
			Random r = new Random();

			dataset = new int[size];
			for(int i=0; i < size; i++) 
			{
				dataset[i] = r.nextInt();
			}

			writeArrayToFile(dataset, "subSFile4.txt");

			dataset = readArrayFromFile("subSFile4.txt");
		}
		return dataset;
	}
	
	static public int[] getSmallSyntheticDataSet5(int size) {

		int[] dataset = readArrayFromFile("subSFile5.txt");

		if(dataset == null || dataset.length ==0) 
		{
			Random r = new Random();

			dataset = new int[size];
			for(int i=0; i < size; i++) 
			{
				dataset[i] = r.nextInt();
			}

			writeArrayToFile(dataset, "subSFile5.txt");

			dataset = readArrayFromFile("subSFile5.txt");
		}
		return dataset;
	}


}
