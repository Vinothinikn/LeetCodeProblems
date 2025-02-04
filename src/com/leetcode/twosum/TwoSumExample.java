package com.leetcode.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumExample {

	public static void main(String a[]) {
		two_sum();
		two_sum_List();
		two_sum_hashMap();
	}
	
	public static void two_sum() {
		//find the indices of two numbers whose sum up to target - O(N^2)
		int arr[] = {3,2,4};
		int target = 6;
		List<Integer> indices = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int temp = arr[i]+arr[j];
				if(temp == target) {
					indices.add(i);
					indices.add(j);
					break;
				}
			}
		}
		System.out.println("TwoSum with O(N^2): "+indices);
	}
	
	public static void two_sum_List() {
		//find the indices of two numbers whose sum up to target using ArrayList - O(N^2)
//		int arr[] = {1,5,6,7,8,9,4};
//		int target = 9;
		int arr[] = {3,2,4};
		int target = 6;
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());   // O(N)
		List<Integer> output = new ArrayList<>();
		HashMap<Integer, Integer> maps = new HashMap<>();
		for(int i = 0;i<arr.length;i++) {                           // O(N)
			int comp = target- arr[i];
			if(list.contains(comp)) {
				output.add(i);
			}
		}
		System.out.println("Using ArrayList: "+output);
	}
	
	public static void two_sum_hashMap() {
		//find the indices of two numbers whose sum up to target Using HashMap - O(N)
		int arr[] = {3,2,4};
		int target = 6;
		List<Integer> output = new ArrayList<>();
		HashMap<Integer, Integer> maps = new HashMap<>(); 
		for(int i = 0;i<arr.length;i++) {           //O(N)
			int comp = target- arr[i];
			if(maps.containsKey(comp)) {
				output.add(maps.get(comp));
				output.add(i);
			}
			maps.put(arr[i], i);
		}
		int[] outputArray = output.stream().mapToInt(Integer::valueOf).toArray();
		System.out.println("Using HashMap: "+output);
	}
	
}
