package org.uw.sort.sortedness;

import org.uw.sort.datasets.RealData;
import org.uw.sort.datasets.SyntheticData;

/**
 * 
 * @author Sonam Gupta
 *
 */

public class LongestIncreasingSubSequence {

    /**
     * Returns index in T for ceiling of s
     */
    private int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
    
    public int longestIncreasingSubSequence(int input[])
    {
        int T[] = new int[input.length];
        int R[] = new int[input.length];
        for(int i=0; i < R.length ; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for(int i=1; i < input.length; i++){
            if(input[T[0]] > input[i]){ //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
            }else if(input[T[len]] < input[i]){ //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                R[T[len]] = T[len-1];
            }else{ //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len,input[i]);
                T[index] = i;
                R[T[index]] = T[index-1];
            }
        }

        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        System.out.println();

        int index = T[len];
        
        while(index != -1) {
            System.out.print(input[index] + " ");
            index = R[index];
        }
       
        System.out.println();
        return len+1;
    }
    
    public static int [] get11PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    }
    
    public static int [] get33PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    }
    
    public static int [] get54PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    } 
    
    public static int [] get66PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    }
    
    public static int [] get88PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    } 
    
    public static int [] get100PercentSorted() 
    {
    	return new int [] {9,8,7,6,5,4,3,2,1}; //11%
    }
    
    public static void main(String args[]) 
    {
//    	 int input[] = {9,8,7,6,5,4,3,2,1}; //11%
    	
         int input[] = {97,5,7,3,4,1,22,9,15,13,0,11}; //33%
         
//       int input[] = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};//54%
        
//       int input[] = {1,2,12,4,5,10,7,0,9}; //66%

//       int input[] = {1,2,3,4,5,10,7,8,9}; //88%

//        int input[] = {1,2,3,4,5,6,7,8,9}; //100%

        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        
//        int[] dataset = SyntheticData.getLargeSyntheticDataSet(500);
        
        int[] dataset = RealData.getRealDataSet1(50);

        int length = lis.longestIncreasingSubSequence(input);
        
        System.out.println("Maximum length " + length);
        
        System.out.println("Percentage of Sortedness is :  " + (length*100)/input.length);
        
    }
}