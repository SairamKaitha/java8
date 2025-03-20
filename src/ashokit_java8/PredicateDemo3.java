package ashokit_java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
}

public class PredicateDemo3 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("sai", 16),
			                               	 new Person("ram",20 ),
			                               	 new Person("sairam",24),
			                                 new Person("raj", 17)
				                            );
	    Predicate<Person> pred = p->p.age>=18;
	    for(Person person:persons) {
	    	if(pred.test(person)) {
	    		System.out.println(person.name);
	    	}
	    }
	}

}
