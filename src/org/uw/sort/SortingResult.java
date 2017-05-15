package org.uw.sort;

public class SortingResult {
	
	private long memoryUsed;
	
	private long time;
	
	private int[] sortedArray;
	
	public SortingResult(long memoryUsed, long time, int[] sortedArray) {
		super();
		this.memoryUsed = memoryUsed;
		this.time = time;
		this.sortedArray = sortedArray;
	}

	public long getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(long memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int[] getSortedArray() {
		return sortedArray;
	}

	public void setSortedArray(int[] sortedArray) {
		this.sortedArray = sortedArray;
	}
	
	

}
