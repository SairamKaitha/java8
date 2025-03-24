package javaStreams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamCollectors {

	public static void main(String[] args) {

		// Joining the data
		// joining the firstnames of all the employees
		List<Employee> employees = EmployeeData.get();

		String employeeByFirstNam = employees.stream()
				                             .map(e -> e.getFirstName())
				                             .collect(Collectors.joining(","));
		System.out.println(employeeByFirstNam);
		
		// partioning the data
		// split the list based on sal>120000
		Map<Boolean, List<Employee>> empsBasedOnSal = employees.stream()
				                                               .collect(Collectors.partitioningBy(e -> e.getSalary() > 120000));

		System.out.println(empsBasedOnSal);
	  
		// partioning the data
		// split the list based on sal>150000 but need count
		Map<Boolean, Long> countOfEmpBySal = employees.stream()
		                                              .collect(Collectors.partitioningBy(e->e.getSalary()>150000, Collectors.counting()));
		System.out.println(countOfEmpBySal);

		// grouping the data
		// grouping by department
		Map<String, List<Employee>> empsByDept = employees.stream()
				                                          .collect(Collectors.groupingBy(e -> e.getDept()));
		System.out.println(empsByDept);
		
		//grouping the data
		//count of of employees in each department		
		Map<String, Long> empCountByDept = employees.stream()
		          .collect(Collectors.groupingBy(e->e.getDept(), Collectors.counting()));
		System.out.println(empCountByDept);
		
		//group the employee by dept
		//List the employees names by dept
		 Map<String, List<String>> empNamesByDeptList = employees.stream()
		         .collect(Collectors.groupingBy(e->e.getDept(), 
		        		  Collectors.mapping(e->e.getFirstName(), Collectors.toList())));
		 System.out.println(empNamesByDeptList);
		 
		//group the employee by dept
		//sum of salaries of employees of each dept
		/*Map<String, Optional<Double>> employeeByDeptSalSum = employees.stream()
		          .collect(Collectors.groupingBy(e->e.getDept(), Collectors.mapping(e->e.getSalary(),
		        		                                         Collectors.reducing((a,b)->a+b))));
		System.out.println(employeeByDeptSalSum);*/
		 Map<Object, Double> employeeByDeptSalSum = employees.stream()
		                                                     .collect(Collectors.groupingBy(e->e.getDept(),
		        		                                              Collectors.summingDouble(e->e.getSalary())));
		        		 
		System.out.println(employeeByDeptSalSum);
		
		//group the employee by dept
		//summary statistics of employees of each department 
	    Map<String, DoubleSummaryStatistics> empsSalSummary =	employees.stream()
		         .collect(Collectors.groupingBy(e->e.getDept(),
		        		  Collectors.summarizingDouble(e->e.getSalary())));
	    System.out.println(empsSalSummary);
	    
	    //summary statistics of employees in dev dept only
	  DoubleSummaryStatistics dubleSummaryOfDev =  employees.stream()
	             .collect(Collectors.filtering(e->e.getDept().equals("Dev"), Collectors.summarizingDouble(e->e.getSalary())));
	  System.out.println(dubleSummaryOfDev);
	    
	    //emplopyee with highest age
	 Optional<Employee> eldestEmp =  employees.stream()
	           .collect(Collectors.maxBy((e1,e2)->e1.getAge()-e2.getAge()));
	    System.out.println(eldestEmp.get());
	    
	  Optional<Employee> eldestEmp1 =  employees.stream()
	             .collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
	    System.out.println(eldestEmp1);
	    
	    //name of the employee with high salary
	    String highestPaidEmployeeName = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(e -> e.getSalary())), 
                        empOpt -> empOpt.map(e -> e.getFirstName()).orElse(null) // Extract first name or return null
                ));
	    System.out.println(highestPaidEmployeeName);

	}

}
