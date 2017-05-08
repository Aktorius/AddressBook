package main.java.com.tm.addressbook.domain;

import main.java.com.tm.addressbook.domain.enums.Gender;

import java.time.LocalDate;

/**
 * Created by Aktorius on 08/05/2017.
 * Class defining the object of type Person
 */
public class Person {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;

    /**
     * Constructor that creates an instance of Person
     * @param name the full name of the Person
     * @param gender the gender of the Person
     * @param dateOfBirth the date of birth of the Person
     */
    public Person(String name, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method to get the name of the Person
     * @return the full name of the Person
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the gender of the Person
     * @return the gender of the Person
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method to get the date of birth of the person
     * @return the date of birth of the Person
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (gender != person.gender) return false;
        return dateOfBirth != null ? dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
