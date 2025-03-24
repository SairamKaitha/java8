package stream;

import java.util.Arrays;
import java.util.List;


public class StreamDemo {
	
	public static void main (String[] args) {
		
		List<String> names = Arrays.asList("sai","ram","sairam","mahesh", "charan");
		
		//print name starts with s with its length		
		 names.stream()
		      .filter(name->name.startsWith("s"))
		      .map(name->name+" - "+name.length())
		      .forEach(n->System.out.println(n));
	}

}
