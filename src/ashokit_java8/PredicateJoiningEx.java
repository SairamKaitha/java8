package ashokit_java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Employee{
	String name;
	String dept;
	String location;
	public Employee(String name, String dept, String location) {
		super();
		this.name = name;
		this.dept = dept;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", location=" + location + "]";
	}
	
	
}
public class PredicateJoiningEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> emps = Arrays.asList(
				                         new Employee("sai", "dev", "hyd"),
				                         new Employee("ram", "testing", "banglore"),
				                         new Employee("raj", "devops", "hyd"),
				                         new Employee("rani", "DB", "chenni")				                         
				                           );
		Predicate<Employee> p1 = e->e.location.equals("hyd");
		Predicate<Employee> p2 = e->e.dept.equals("dev");
		
		//predicate joining
		Predicate<Employee> p = p1.and(p2);
		
		for(Employee e:emps) {
			if(p.test(e)) {
				System.out.println(e.name);
			}			
		}		
	}

}
