package com.leetcode.smallernumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumber {

	public static void main(String a[]) {
		//smaller_number();
		smaller_number_sorting();
	}
	
	public static void smaller_number() {
		//how many numbers in the array are smaller than each number at num[i] using loops - O(N^2)
		int num[] = {8,1,2,2,3};
		
		// Map to store count of smaller elements for each number.
		Map<Integer, Integer> map = new HashMap<>();
		
		  // Step 1: Iterate over each element in the array.
		for(int i = 0;i<num.length;i++) {
			int count = 0;
			for(int j=0;j<num.length;j++) {
				 // Count the numbers smaller than num[i] and ensure j != i
                if (i != j && num[j] < num[i]) {
                    count++;
                }
            }
            map.put(num[i], count);
			}
		
		// Step 2: Print the result for each element in the array.
		  for (int i = 0; i < num.length; i++) {
	            System.out.println("For " + num[i] + ", count of smaller elements: " + map.get(num[i]));
	        }
		}
		
	public static void smaller_number_sorting() {
		//how many numbers in the array are smaller than each number at num[i] - O(NlogN)
		int num[] = {8,1,2,2,3};
		
		 // Step 1: Sort the array and keep track of the original indices. -- O(NlogN)
		int sortedArray[] = num.clone();
		Arrays.sort(sortedArray);   // 1,2,2,3,8
		
		 // Step 2: Create a map to store the count of smaller elements for each number.
		Map<Integer, Integer> countMap = new HashMap<>();
		
		 // Step 3: Traverse the sorted array and assign a smaller count to each number.
		for(int i=0;i<sortedArray.length;i++) {
			
			 // Only assign a count to a number if it hasn't been assigned before.    -- O(N)
			if(!countMap.containsKey(sortedArray[i])) {
				countMap.put(sortedArray[i], i);    //[1,0],[2,1],[3,3],[8,4]
			}
		}
		
		 // Step 4: For each element in the original array, get the count of smaller elements.
		 for (int i = 0; i < num.length; i++) {
	            System.out.println("For " + num[i] + ", count of smaller elements using sorting : " + countMap.get(num[i]));
	        }
	}
	
}
