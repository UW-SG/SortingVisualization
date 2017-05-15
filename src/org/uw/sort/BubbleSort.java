package org.uw.sort;


public class BubbleSort implements Sort {

	public void sort(int dataset[])
	{ 
		int counter_1;
		int counter_2;
		int temp;
		for(counter_1 = dataset.length-1; counter_1 > 0; counter_1--)
		{
			for(counter_2 = 0; counter_2 < counter_1; counter_2++)
			{ 
				if(dataset[counter_2] > dataset[counter_2+1])
				{
					temp = dataset[counter_2];
					dataset[counter_2] = dataset[counter_2+1];
					dataset[counter_2+1] = temp;
				}//
			}// end inner loop
		}//end outer loop}// end bubble sort
	}
	
	public void sort(DrawArray dataset)
	{ 
		
		int counter_1;
		int counter_2;
		for(counter_1 = dataset.length(); counter_1 > 0; counter_1--)
		{
			for(counter_2 = 0; counter_2 < counter_1-1; counter_2++)
			{ 
				dataset.compareAndSwap(counter_2, counter_2+1);
			}
			dataset.setDone(counter_1-1);
			// end inner loop
		}//end outer loop}// end bubble sort
	}
	
	@Override
	public String getName() {
		return "Bubble Sort";
	}

	
}