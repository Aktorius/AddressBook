package main.java.com.tm.addressbook.contracts;

import main.java.com.tm.addressbook.domain.Person;

import java.util.NoSuchElementException;

/**
 * Created by Aktorius on 08/05/2017.
 * Contract that exposes the possible actions on an address book
 */
public interface IAddressBookServices {
    /**
     * Method that counts the number of persons in the address book
     * @return an integer represnting the number of persons in the address book
     */
    int numberOfPersons();

    /**
     * Method that count the number of males in the address book
     * @return an integer representing the number of males in the address book
     */
    int countMales();

    /**
     * Method that search the address book for the oldest person
     * @return a Person representing the oldest person in the address book
     * @throws NoSuchElementException if there is no oldest person
     */
    Person findOldestPerson() throws NoSuchElementException;

    /**
     * Method that search the address book for a person based on the name
     * @param name the full name of the person looked for
     * @return an object of type Person representing the person looked for
     * @throws NoSuchElementException if the person is not found
     */
    Person findPersonByName(String name) throws NoSuchElementException;
}
