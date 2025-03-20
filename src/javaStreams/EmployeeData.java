package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {

    public static List<Employee> get() {
        return new ArrayList<>(Arrays.asList(
                new Employee(1, "Sai", "Kaitha", "Dev", "SE", 150000.5, 26) ,
                new Employee(2, "John", "Doe", "IT", "Manager", 200000.0, 35),
                new Employee(3, "Jane", "Smith", "HR", "HR Executive", 120000.0, 30),
                new Employee(4, "Robert", "Williams", "Finance", "Analyst", 100000.0, 40),
                new Employee(5, "Emily", "Davis", "Marketing", "Lead", 160000.5, 28),
                new Employee(6, "Michael", "Brown", "Sales", "Sales Executive", 110000.0, 32)
                
        ));
    }
}
