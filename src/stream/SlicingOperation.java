package stream;

import java.util.Arrays;
import java.util.List;

public class SlicingOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList("sai", "ram", "rajesh", "mahesh", "cnu","charan");
		
		//print after 4 names
		names.stream().skip(4).forEach(name->System.out.println(name));
		
		//print first 2 names
		names.stream().limit(2).forEach(n->System.out.println(n));
		
		//print distinct names
		System.out.println("-----------------------------------------------------------");
		List<String> n = Arrays.asList("sai", "sai", "rajesh", "ram", "ram","charan");
		n.stream().distinct().forEach(nam->System.out.println(nam));

	}

}
