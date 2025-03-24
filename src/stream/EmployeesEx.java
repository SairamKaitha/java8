package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javaStreams.Employee;

class Employees{
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;
	public Employees(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	
	
	
}

public class EmployeesEx {
	public static void main(String[] args) {

		 List<Employees> list = Arrays.asList(
	                new Employees(101, "Alice", 25, "Female", "HR", 2020, 50000),
	                new Employees(102, "Bob", 30, "Male", "IT", 2018, 75000),
	                new Employees(103, "Charlie", 28, "Male", "Finance", 2019, 60000),
	                new Employees(104, "David", 35, "Male", "Marketing", 2016, 80000),
	                new Employees(105, "Emma", 26, "Female", "IT", 2021, 65000),
	                new Employees(106, "Frank", 32, "Male", "HR", 2017, 55000),
	                new Employees(107, "Grace", 27, "Female", "Finance", 2019, 70000),
	                new Employees(108, "Hannah", 29, "Female", "Marketing", 2018, 72000),
	                new Employees(109, "Ian", 31, "Male", "IT", 2016, 85000),
	                new Employees(110, "Jack", 33, "Male", "Finance", 2015, 90000),
	                new Employees(111, "Kim", 24, "Female", "HR", 2022, 48000),
	                new Employees(112, "Liam", 36, "Male", "Marketing", 2014, 95000),
	                new Employees(113, "Mia", 29, "Female", "IT", 2017, 78000),
	                new Employees(114, "Nathan", 34, "Male", "Finance", 2015, 85000),
	                new Employees(115, "Olivia", 28, "Female", "HR", 2019, 72000)
	        );
		 
		 //print gender wise count of employees
		 Map<String, Long> empsGenderCt =  list.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.counting()));
		 System.out.println(empsGenderCt);
		 System.out.println("---------------------------------------------------------------------------");
		 
		 //print name of departments in the orginisation
		  list.stream().map(e->e.department).distinct().forEach(d->System.out.println(d));
		  System.out.println("---------------------------------------------------------------------------");
		  
		 //average age of male and female employees
		 Map<String, Double> avgOfAgeByGender = list.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.averagingInt(e->e.age)));
		 System.out.println(avgOfAgeByGender);
		 System.out.println("---------------------------------------------------------------------------");
		 
		 
		 //get the details of highest paid employee details
		  Optional<Employees> empHighestSal = list.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.salary)));
		  System.out.println(empHighestSal);
		  System.out.println("---------------------------------------------------------------------------");
		  
	     //get all employees who joined after 2020
		  list.stream().filter(e->e.yearOfJoining>2020).map(e->e.name).forEach(n->System.out.println(n));
		  System.out.println("---------------------------------------------------------------------------");
		  
		 //count no employees in each department
		  Map<String, Long> deptWiseEmpsCount = list.stream().collect(Collectors.groupingBy(e->e.department, Collectors.counting()));
		  System.out.println(deptWiseEmpsCount);
		  System.out.println("---------------------------------------------------------------------------");
		  
		 //what is the average salary of each department
		 Map<String, Double> deptWiseAvgSal =  list.stream().collect(Collectors.groupingBy(e->e.department, Collectors.averagingDouble(e->e.salary)));
		 System.out.println(deptWiseAvgSal);
		 System.out.println("---------------------------------------------------------------------------");
		 
		 //youngest female employee in HR
		 Optional<Employees> youngestMaleHR = list.stream()
	                .filter(e -> e.getDepartment().equals("HR") && e.getGender().equals("Female"))
	                .min(Comparator.comparingInt(Employees::getAge));
		 if(youngestMaleHR.isPresent()) {
			 System.out.println(youngestMaleHR.get());
		 }
		 System.out.println("---------------------------------------------------------------------------");

		 //who has the most working experience in the organization		 
		Optional<Employees> empWithHighestExp = list.stream().collect(Collectors.minBy(Comparator.comparing(e->e.yearOfJoining)));
		if(empHighestSal.isPresent()) {
			System.out.println(empHighestSal.get());
		}
		 System.out.println("---------------------------------------------------------------------------");
		
		//how many male and female employees in Finance team-count
		 Map<String, Long> empCountInFin = list.stream().filter(e->e.department.equals("Finance")).collect(Collectors.groupingBy(e->e.gender, Collectors.counting()));
		 System.out.println(empCountInFin);
		 System.out.println("---------------------------------------------------------------------------");
		 
		 //List down names of employees in each dept
		 Map<String, List<String>> nameWithDept = list.stream().collect(Collectors.groupingBy(e->e.department, Collectors.mapping(e->e.name, Collectors.toList())));
		 System.out.println(nameWithDept);
		 System.out.println("---------------------------------------------------------------------------");
		 
		 //what is the average salary and total salary of whole organization
		double avgSalOfOrg = list.stream().collect(Collectors.averagingDouble(e->e.salary));
		System.out.println(avgSalOfOrg);
		
		double totalSal = list.stream().collect(Collectors.summingDouble(emp->emp.salary) );
		System.out.println(totalSal);
		System.out.println("---------------------------------------------------------------------------");
		
		 //saperate the employees who are younger or equal to 25 years from employees who older than 25 years
		Map<Boolean, List<Employees>> partionedEmps = list.stream().collect(Collectors.partitioningBy(e->e.age<=25));
		List<Employees> empsLessOrEq25 = partionedEmps.get(true);
		List<Employees> empsGretTha25 = partionedEmps.get(false);
		System.out.println(empsLessOrEq25);
		System.out.println(empsGretTha25);
		System.out.println("---------------------------------------------------------------------------");
		 
		 //who is the oldest employee in organization? what is his age which age he belongs to
		Optional<Employees> OldestEmp = list.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.age)));
		if(OldestEmp.isPresent()) {
			System.out.println(OldestEmp.get());
		}
		System.out.println("---------------------------------------------------------------------------"); 
		
         //list of employees in assending order
	     list.stream().sorted(Comparator.comparingDouble(e->e.salary)).collect(Collectors.toList()).forEach(e->System.out.println(e));
	     System.out.println("---------------------------------------------------------------------------"); 
	     
		 //employee having second highest salary
		Optional<Employees> secondHighSal = list.stream().sorted(Comparator.comparingDouble(e->-e.salary)).skip(1).findFirst();
		if(secondHighSal.isPresent()) {
			System.out.println(secondHighSal.get());
		}
		System.out.println("---------------------------------------------------------------------------"); 
		
		
	}
}
