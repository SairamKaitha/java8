package ashokit_java8;

import java.util.function.Predicate;

public class predicateDemo2 {
	
	public static void main(String[]args) {
		
		String[]names = {"Abvbd","Afdf","Bccc","Cdd"};
		
		Predicate<String> p = name->name.charAt(0) == 'A';
		
		for(String name: names)
		{
			if(p.test(name))
			{
				System.out.println(name+" ");
			}
		}
	}
}
