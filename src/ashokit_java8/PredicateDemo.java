package ashokit_java8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Predicate<Integer> p =   i->i>10;
           System.out.println(p.test(5));//contains only one boolen test(T t) abstract method
           
           System.out.println("===============================================================");
           BiPredicate<Integer, Integer> nums = (i,j)->(i+j)>=20;
           System.out.println(nums.test(10, 10));
           System.out.println(nums.test(1, 18));
	}

}
