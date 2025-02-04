package com.leetcode.arrayex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayMissingNumber {

	public static void main(String a[]) {
		missingNumber_WithoutDuplicates();
		missingNumber_withDuplicates();
	}
	
	public static void missingNumber_WithoutDuplicates() {
		//Missing multiple numbers - o(N)
		int arr[] = {0,1,3,5};
		List<Integer> missingElement = new ArrayList<>();
	    int lastElement = arr[arr.length - 1];
	    int index = 0;

	    for (int i = 0; i <= lastElement; i++) {
	        if (index < arr.length && arr[index] == i) {
	            // If the current number exists in the array, move to the next array element.
	            index++;
	        } else {
	            // If the number is not in the array, add it to the missing list.
	            missingElement.add(i);
	        }
	    }
	    
		System.out.println("missingNumber_WithoutDuplicates: "+missingElement);
	}
	
	public static void missingNumber_withDuplicates() {
		//Missing all numbers with the given input that contains duplicates - O(1)
		int arr[] = {1,2,2,4,7,8};
		Set<Integer> uniqueSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		Integer lastElement = uniqueSet.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		List<Integer> missingNumbers = new ArrayList<>();
		for(int i=1;i<=lastElement;i++) {
			if(!uniqueSet.contains(i)) {
				missingNumbers.add(i);
			}
		}
		
		int missingArray[] = missingNumbers.stream().mapToInt(Integer::intValue).toArray();
		
		for(int j=0;j<missingArray.length;j++) {
			System.out.println(missingArray[j]);
		}
	
	}
}
