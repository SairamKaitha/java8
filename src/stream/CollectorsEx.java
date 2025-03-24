package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    String name;
    String country;

    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", country=" + country + "]";
    }
}

public class CollectorsEx {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("sai", "Indian"),
            new Person("raj", "Chinese"),
            new Person("mahesh", "Indian"),  
            new Person("cnu", "Mongolian")
        );

        List<Person> per = persons.stream()
                                  .filter(p -> p.country.equalsIgnoreCase("Indian")) 
                                  .collect(Collectors.toList());

        per.forEach(System.out::println); 
        
        List<String> IndNam =  persons.stream()
                                      .filter(p -> p.country.equalsIgnoreCase("Indian"))
                                      .map(p->p.name)
                                      .toList();
        System.out.println(IndNam);
        
        Map<String, List<Person>> groupByCountry =  persons.stream().collect(Collectors.groupingBy(p->p.country));
        System.out.println(groupByCountry);
               
        
        
        
    }
}

