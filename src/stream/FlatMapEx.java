package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapEx {

	public static void main(String[] args) {
		
		List<String> jc = Arrays.asList("core java","advanced java","springboot");
		List<String> ui = Arrays.asList("html","css","java script");
		
		List<List<String>> combined = Arrays.asList(jc,ui);
		
		//prints two objects individually jc ui
		combined.stream().forEach(c->System.out.println(c));
		
		//prints individually
		Stream<String> flatmap = combined.stream().flatMap(c->c.stream());
		flatmap.forEach(cs->System.out.println(cs));
		
 
	}

}
