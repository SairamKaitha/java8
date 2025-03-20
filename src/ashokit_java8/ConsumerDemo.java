package ashokit_java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		Consumer<String> n = (name)->System.out.println(name+" "+ "good morning");
		n.accept("sai");
		n.accept("ram");
		
		List<Integer> nums = Arrays.asList(7,3,9,5,1);
		nums.forEach(i->System.out.println(i));
		
	}

}
