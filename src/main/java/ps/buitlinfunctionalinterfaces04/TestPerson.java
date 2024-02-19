package ps.buitlinfunctionalinterfaces04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class TestPerson {

	public static void main(String[] args) {
		 Set<Person> personSet = new TreeSet<>();

	        
	        for (int i = 1; i <= 10; i++) {
	            Person person = new Person(i, "Person" + i, 25 + i, 50000 + i * 1000);
	            personSet.add(person);
	        }
	        System.out.println("Print all Person details based on ID");
	        System.out.println();
	        for (Person person : personSet) {
	            System.out.println(person);
	        }
	        
	        Person[] per= {new Person(1,"Person11",31,378482),
	        		new Person(2,"Person12",32,376282),
	        		new Person(3,"Prson13",33,378052),
	        		new Person(4,"Person14",34,378432),
	        		new Person(5,"Perso15",35,3784432),
	        		new Person(6,"Persun16",36,378212),
	        		new Person(7,"Perstn17",46,37892),
	        		new Person(8,"Persowd18",38,670482),
	        		new Person(9,"Perswdn19",41,332482),
	        		new Person(10,"Pefson20",51,378092)
	        		
	        };
	        Arrays.sort(per, new NamesAscendingOrder());
	        System.out.println();
	        System.out.println("Sorting Person deatils based on names");
	        for (Person person : per) {
	            System.out.println(person);
	        }
	        
	        
	        
	        List<Person> persons = new ArrayList<>();
            for(int i=9;i>=0;i--) {
               persons.add(per[i]);
            }
	        

	       	          
	        System.out.println("Sorted Desc Name:");
	        persons.forEach(System.out::println);

	        
	        Predicate<Person> ageGreaterThan25 = person -> person.getAge() > 25;

	        System.out.println("\nPersons whose Age greater than 25:");
	        persons.stream().filter(ageGreaterThan25).forEach(System.out::println);
	        
	        
	        Consumer<Person> printDetails = person ->
            System.out.println(person.getId() + "|" + person.getName() + "|" + person.getSalary() + "|");

		    
		    System.out.println("Print id, name, and salary:");
		    persons.forEach(printDetails);
		
		   
		    Function<Person, String> UpperCase = person -> person.getName().toUpperCase();
		
		    
		    System.out.println("all the names in uppercase:");
		    persons.stream().map(UpperCase).forEach(System.out::println);
		
		    
		    ToDoubleFunction<Person> applyAppraisal = person -> person.getSalary() * 10.1;
		
		   
		    System.out.println("\n applying appraisal to salary:");
		    persons.forEach(person ->
		            System.out.println("Name is: " + person.getName() +
		                    " and Salary is: " + applyAppraisal.applyAsDouble(person)));
	    }
	        
	}


