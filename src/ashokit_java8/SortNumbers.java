package ashokit_java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortNumbers {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(5,4,3,1,2);
		
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i));	
		}
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		nums.forEach(num->System.out.println(num));
		//Collections.sort(nums, (i,j)->i.compareTo(j));
		
		Collections.sort(nums, (i,j)->(i>j)?-1:1);
		
		System.out.println("after sort "+ nums);

	}

}
