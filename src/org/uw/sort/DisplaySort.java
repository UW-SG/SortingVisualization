package org.uw.sort;

import org.uw.sort.Sort;

final class DisplaySort extends Thread {
	
	private Sort algorithm;
	private DrawArray array;
	
	
	public DisplaySort(DrawArray array, Sort algo) {
		this.array = array;
		this.algorithm = algo;
		new SortFrame(algorithm.getName(), array.getCanvas(), this);
	}
	
	public void run() {
		try {
			Thread.sleep(30000);
			
			array.print();
			algorithm.sort(array);
			array.print();
			try {
				array.assertSorted();
				System.out.printf("%s: %d comparisons, %d swaps%n", algorithm.getName(), array.getComparisonCount(), array.getSwapCount());
			} catch (AssertionError e) {
				System.out.printf("%s: Sorting failed%n", algorithm.getName());
			}
		}
		catch (StopDrawingException e) {}
		catch (InterruptedException e) {}
	}	
	
	public void requestStop() {
		interrupt();
		array.requestStop();
	}
	
}
