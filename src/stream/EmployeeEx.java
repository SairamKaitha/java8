package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee{
	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

public class EmployeeEx {
	public static void main(String[] args) {
	
     List<Employee> emps = Arrays.asList(new Employee(1,"sairam", 100000),
    		                             new Employee(2,"rajesh", 50000),  
    		                             new Employee(3,"mahesh", 70000),
    		                             new Employee(4,"charan", 60000),
    		                             new Employee(5,"cnu", 80000)
    		                             );
     
     Optional<Employee> maxSal = emps.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.salary)));
     System.out.println(maxSal);
     System.out.println("---------------------------------------------------------------------------------");
     
     Optional<Employee> minSal = emps.stream().collect(Collectors.minBy(Comparator.comparing(e->e.salary)));
     System.out.println(minSal);
     System.out.println("---------------------------------------------------------------------------------");
     
     Double avgSal = emps.stream().collect(Collectors.averagingDouble(e->e.salary));
     System.out.println(avgSal);
     System.out.println("---------------------------------------------------------------------------------");
	}
}
