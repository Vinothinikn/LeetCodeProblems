package com.leetcode.arrayex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayExample {

	public static void main(String a[]) {
		secondLargestElement();
		findDuplicates();
	}
	
	public static void secondLargestElement() {
		//Find the second largest element from the array
		int arr[] = {23,-42,56,1000,2090,45};
		// use bubble sort - o(N^2)
		boolean swapped;		
		for(int i=0;i<arr.length;i++) {
			swapped = false;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]> arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		for(int k =0;k<arr.length;k++) {
			System.out.println(arr[k]);
		}
	}

	public static void findDuplicates() {
		//Brute force comparison - o(N^2)
		int arr[] = {23,45,1,34,23,3};
		List<Integer> duplicates = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					duplicates.add(arr[i]);
				}
			}
		}
		System.out.println(duplicates);
		
		//Using hashSet - o(N)
		Set<Integer> uniqueSet = new HashSet<>();
		List<Integer> dupList =  Arrays.stream(arr).boxed().filter(x->!uniqueSet.add(x)).collect(Collectors.toList());
		System.out.println("Unique Elements : "+uniqueSet+" Duplicates : "+dupList);
		
		if(arr.length ==uniqueSet.size()) {
			System.out.println(" The given list is unique");
		}else {
			System.out.println(" The given list is duplicate");
		}
	}
}
