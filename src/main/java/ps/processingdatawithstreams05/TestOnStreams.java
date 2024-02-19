package ps.processingdatawithstreams05;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import ps.buitlinfunctionalinterfaces04.Person;

public class TestOnStreams {

	public static void main(String[] args) {
		Set<Person> persons = new HashSet<>();

        
        persons.add(new Person(4, "Jones", 22, 6999.0));
        persons.add(new Person(6, "Tom", 42, 3999.0));
        persons.add(new Person(1, "Jerry", 12, 999.0));
        persons.add(new Person(5, "John", 32, 1999.0));
        persons.add(new Person(2, "Smith", 22, 2999.0));
        persons.add(new Person(3, "Popeye", 21, 5999.0));

        
        System.out.println("1.Print all person records:");
        persons.forEach(System.out::println);

        
        System.out.println("\n 2.Sorted Asc Id:");
        persons.stream()
                .sorted()
                .forEach(System.out::println);

       
        System.out.println("\n 3.Sorted Asc Name:");
        persons.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
        
        System.out.println("\n 4.Sorted Desc Name:");
        persons.stream()
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                .forEach(System.out::println);

       
        System.out.println("\n 5.Name start with J-----");
        persons.stream()
                .filter(person -> person.getName().startsWith("J"))
                .forEach(System.out::println);

       
        long count = persons.stream().count();
        System.out.println("\n 6.Count number of persons: " + count);

        
        OptionalDouble maxSalary = persons.stream()
                .mapToDouble(Person::getSalary)
                .max();
        System.out.println("\n 7.Max salary among all persons---");
        System.out.println(maxSalary);

        
        OptionalDouble minSalary = persons.stream()
                .mapToDouble(Person::getSalary)
                .min();
        System.out.println("\n 8.Min salary among all persons.......");
        System.out.println(minSalary);
        
        
       
        OptionalDouble averageSalary = persons.stream()
                .mapToDouble(Person::getSalary)
                .average();
        System.out.println("\n----9.Average of salaries-----");
        System.out.println(averageSalary);

        
        double sumOfSalaries = persons.stream()
                .mapToDouble(Person::getSalary)
                .sum();
        System.out.println("\n 10.Sum of all salaries");
        System.out.println(sumOfSalaries);

        
        System.out.println("\n 11.First Person whose Name start with J " +
                persons.stream()
                        .filter(person -> person.getName().startsWith("J"))
                        .findFirst()
                        .orElse(null));

      
        boolean allAgesGreaterThan10 = persons.stream()
                .allMatch(person -> person.getAge() > 10);
        System.out.println("\n 12.Return true if All person age greater than 10.");
        System.out.println(allAgesGreaterThan10);
        
        
        boolean allAgesGreaterThan50 = persons.stream()
                .noneMatch(person -> person.getAge() > 50);
        System.out.println("\n 13.Return true if All person age greater than 50");
        System.out.println(allAgesGreaterThan50);

       
        double averageSalaryUsingCollectors = persons.stream()
                .collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("\n--14.Average salaries to Double");
        System.out.println(averageSalaryUsingCollectors);

        
        System.out.println("\n -15.Group By Salary-");
        Map<Double, List<Person>> personsGroupedBySalary = persons.stream()
                .collect(Collectors.groupingBy(Person::getSalary));

        personsGroupedBySalary.forEach((salary, personsList) -> {
            System.out.println("Person Grouped By: " + salary);
            personsList.forEach(System.out::println);
        });

        
        System.out.println("\n 16.Joining all the names whose age is greater than 18");
        String namesJoining = persons.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getName)
                .collect(Collectors.joining(", ", "In Germany ", " are of legal age."));
        System.out.println(namesJoining);

       
        System.out.println("\n 17.Statistics object...... " +
                persons.stream()
                        .collect(Collectors.summarizingDouble(Person::getSalary)));

        System.out.println("Minimum is: " + persons.stream().mapToDouble(Person::getSalary).min().orElse(0));
        System.out.println("Maximum is: " + persons.stream().mapToDouble(Person::getSalary).max().orElse(0));
        System.out.println("Count is: " + persons.stream().count());
        System.out.println("Average is: " + persons.stream().collect(Collectors.averagingDouble(Person::getSalary)));
        System.out.println("Sum is: " + persons.stream().mapToDouble(Person::getSalary).sum());
    
        
        
        System.out.println("\n 18.determine the oldest person--");
        persons.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(System.out::println);

       
        
        int n = 1000000;
        Set<Person> largeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            largeSet.add(new Person(i,"Person" + i, 25,886421.09));
        }

        long startTimeSequential = System.currentTimeMillis();
        largeSet.stream().collect(Collectors.toList());
        long endTimeSequential = System.currentTimeMillis();

        System.out.println("\n 19.Performing Sequentially: " + n);
        System.out.println("Time taken with Sequential: " + (endTimeSequential - startTimeSequential));

        
        long startTimeParallel = System.currentTimeMillis();
        largeSet.parallelStream().collect(Collectors.toList());
        long endTimeParallel = System.currentTimeMillis();

        System.out.println("\n 20.Performing parallely: " + n);
        System.out.println("Time taken with parallel: " + (endTimeParallel - startTimeParallel));
   

	}

}
