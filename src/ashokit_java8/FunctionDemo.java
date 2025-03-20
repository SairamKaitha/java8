package ashokit_java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<String, Integer> n = name->name.length();
		System.out.println(n.apply("sairam"));
		System.out.println(n.apply("hyderabad"));
		System.out.println(n.apply("warangal"));
		
		BiFunction< Integer, Integer, Integer> bifunction = (a,b)->(a+b);
		System.out.println(bifunction.apply(10, 20));
		System.out.println(bifunction.apply(30, 20));

	}

}
