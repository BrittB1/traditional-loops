package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Smith", 25));
        people.add(new Person("Sarah", "Johnson", 32));
        people.add(new Person("Michael", "Williams", 41));
        people.add(new Person("Emily", "Brown", 28));
        people.add(new Person("David", "Jones", 35));
        people.add(new Person("Jessica", "Garcia", 29));
        people.add(new Person("Christopher", "Miller", 45));
        people.add(new Person("Amanda", "Davis", 23));
        people.add(new Person("Matthew", "Rodriguez", 38));
        people.add(new Person("Ashley", "Martinez", 27));

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome. Search by a FIRST or LAST name to begin: ");
        String search = keyboard.nextLine();

            /* converting list into stream. filter is like the 'if'.
            // -> means 'goes' or 'becomes. Everything AFTER it is the condition to test */
        List<Person> searchResults = people.stream().filter(person -> person.getFirstName().equalsIgnoreCase(search) ||
                person.getLastName().equalsIgnoreCase(search)).collect(Collectors.toList());

        if (searchResults.isEmpty()) {
            System.out.println("Oops! No matches found");

        } else {
            for (Person person : searchResults) {
                System.out.println(person.getFirstName() + " " +
                        person.getLastName() + ", Age: " + person.getAge());
            }
        }
        int sum = 0;
        for (Person p : people) {
            sum += p.getAge();
        }
            /* .map - Transforms each person into their age.
               .reduce - combines all values into a single result, with 0 as the starting value
                Person :: getAge - calls getAge on each person */

        double averageAge = people.stream()
                .map(Person::getAge).reduce(0, Integer::sum) / (double) people.size();
        System.out.println("Average age: " + averageAge);

             /* 1. (Person :: getAge - gets ages
                2. .boxed() - Turns primitive int to Integer objects (necessary to sort)
                3. .sorted() - sorts the ages
                4. .findFirst() - Get first element after sorting
                5. .orElse () - defaults in case its empty (similar to 'else') */

        int maxAge = people.stream()
                .mapToInt(Person::getAge).max().orElse(0);

        System.out.println("Oldest person's age: " + maxAge);


        int minAge = people.stream().
                mapToInt(Person::getAge).min().orElse(0);

        System.out.println("Youngest person's age: " + minAge);

    }
}
