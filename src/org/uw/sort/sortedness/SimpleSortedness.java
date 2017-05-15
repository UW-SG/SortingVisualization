package org.uw.sort.sortedness;

/**
 * @author karwaj
 *
 */
public class SimpleSortedness {

	private static int binarySearch(int table[],int a,int len){

		int end = len-1;
		int start = 0;
		int mid = 0;
		int result = -1;
		while(start <= end)
		{
			mid = (end + start) / 2;
			if(table[mid] < a)
			{
				start=mid+1;
				result = mid;
				
			}else if(table[mid] == a) {
				return len-1;
			}else {
				end = mid-1;
			}
		}
		return result;
	}		

	public static void main(String[] args) {        

		int seq[] = {5, 19, 5, 81, 50, 28, 29, 1, 83, 23};
		
		//Input sorted by 37%
//		int seq [] ={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int table[] = new int[seq.length]; 
		       
		table[0] = seq[0];
		int len = 1; 
		for (int i = 1; i < seq.length; i++) 
		{
			if(table[0] > seq[i])
			{
				table[0] = seq[i];
				
			}else if(table[len-1] < seq[i]) 
			{
				table[len++]=seq[i];
				
			}else 
			{
				table[binarySearch(table, seq[i],len) + 1] = seq[i];
			}            
		}
		
		int count = 0;
		for (int i = 1; i < seq.length; i++) 
		{ 
			if(table[i] != 0) {
				System.out.println("Table " + table[i]);
				count++;
			}
		}
		int seqLength = (count*100)/seq.length;
		System.out.println(seqLength + "%");
	}    

	
	static public void sort() {
		
		int P[] = {5, 19, 5, 81, 50, 28, 29, 1, 83, 23};
		int M[] = {5, 19, 5, 81, 50, 28, 29, 1, 83, 23};
	}
}
