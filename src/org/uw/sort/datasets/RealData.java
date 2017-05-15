package org.uw.sort.datasets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

//Libraries for excel workbook reading
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 * Utility class for dataset generation, generates random Gaussain and distributed data sets for 
 * sorting algorithms. In order to make sure all the algortihsm are dealing with the same data,
 * the data is generated and wrote a file for the all the sorting algos to pick up.
 * 
 * The datasets are further divided into sizes to get a perfect curve on the graphs.
 */
public class RealData {

	//only static access
	private RealData() {}
	
	static public int[] getLargeSortednessData(int size) 
	{
		 int[] dataset = getRealDataSet1FromExcel();
		
		 int[] arr = new int[size];
		
		 System.arraycopy(dataset, 0, arr, 0, size-1);
		 
		 return arr;
	}
	
	static public int[] getTextSortednessData(int size) 
	{
		 int[] dataset = getTextSortednessDataFromExcel();
		
		 int[] arr = new int[size];
		
		 System.arraycopy(dataset, 0, arr, 0, size-1);
		 
		 return arr;
	}
	
	static public int[] getTextSortednessDataFromExcel() 
	{
		return getColumnDataFromexcel("Top_100_Public_Colleges_2003.xls", "Enrollment");
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
	static public int[] getRealDataSet1(int size) 
	{
		String fileName = "realDataSet1_" + size + ".txt";
		int[] arr = readArrayFromFile(fileName);

		if(arr == null || arr.length ==0) 
		{
			int[] dataset = getRealDataSet1FromExcel();
			
			 arr = new int[size];
			
			System.arraycopy(dataset, 0, arr, 0, size-1);

			writeArrayToFile(arr, fileName);

			arr = readArrayFromFile(fileName);
		}
		return arr;
	}

	static public int[] getRealDataSet2(int size) 
	{
		String fileName = "realDataSet2_" + size + ".txt";
		int[] arr = readArrayFromFile(fileName);

		if(arr == null || arr.length ==0) 
		{
			int[] dataset = getRealDataSet2FromExcel();
			
			 arr = new int[size];
			
			System.arraycopy(dataset, 0, arr, 0, size-1);

			writeArrayToFile(arr, fileName);

			arr = readArrayFromFile(fileName);
		}
		return arr;
	}

	//"Top_100_Public_Colleges_2003.xls", "Out-of-State Costs"
	static int[] getColumnDataFromexcel(final String filename, final String columnName) 
	{
		List<Integer> dataset = new ArrayList<Integer>();
		//test file is located in the project path         
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//read file 
		POIFSFileSystem fs = null;
		try {
			fs = new POIFSFileSystem(fileIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		HSSFWorkbook file = null;
		try {

			file = new HSSFWorkbook(fs);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//open sheet 0 which is first sheet of your worksheet
		HSSFSheet sheet = file.getSheetAt(0);

		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = columnName;
		Integer columnNo = null;

		Row firstRow = sheet.getRow(0);

		for(Cell cell:firstRow) 
		{
			if (cell.getStringCellValue().equals(columnWanted)){
				columnNo = cell.getColumnIndex();
				break;
			}
		}

		if (columnNo != null) 
		{
			for (Row row : sheet) {
				Cell c = row.getCell(columnNo);
				if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK ) 
				{
					// Nothing in the cell in this row, skip it
				} else if (c.getCellType() == Cell.CELL_TYPE_STRING) 
				{
					
				}
				else 
				{
					Integer value = Double.valueOf(c.getNumericCellValue()).intValue();
					dataset.add(value);
				}
			}
		}
		else
		{
			System.out.println("could not find column " + columnWanted + " in first row of " + fileIn.toString());
		}

		//Only works in Java 8
		int[] array = dataset.stream().mapToInt(i->i).toArray();

		return array;
	}

	static public int[] getRealDataSet1FromExcel() 
	{
		return getColumnDataFromexcel("Top_1000_Public_Colleges_2003.xls", "Out-of-State Costs");
	}

	static public int[] getRealDataSet2FromExcel() 
	{
		return getColumnDataFromexcel("EuropeanPopulation.xls", "01.01.94");
	}

	public static void main(String[] args) 
	{
		int [] arr = getRealDataSet2(200);
		for(int i =0; i < arr.length; i++) 
		{
			System.out.println(arr[i]+ "\n");

		}
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
}
