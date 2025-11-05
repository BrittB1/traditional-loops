package com.pluralsight;

import streams.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

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

        ArrayList<Person> searchResults = new ArrayList<>();

        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(search) ||
                    person.getLastName().equalsIgnoreCase(search)) {
                searchResults.add(person);
            }
        }
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
        double averageAge = (double) sum / people.size();
        System.out.println("Average age: " + averageAge);
    }
}