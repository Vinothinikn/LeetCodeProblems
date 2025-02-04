package com.leetcode.arrayex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayList {

	public static void main(String a[]) {
		
		List<Integer> data = Arrays.asList(4,2,3,1);
		
		List<Integer> reverse = new ArrayList<>();
		
		for(int i=data.size()-1;i>=0;i--) {
			reverse.add(data.get(i));
		}
		System.out.println(reverse);
	}
}
