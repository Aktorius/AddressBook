package main.java.com.tm.addressbook.contracts;

import main.java.com.tm.addressbook.domain.Person;

import java.util.List;

/**
 * Created by Aktorius on 08/05/2017.
 * Contract defining the possible actions for an AddressBook
 */
public interface IAddressBook {

    /**
     * Method to get the list of persons in the address book
     * @return the list of persons in the address book
     */
    List<Person> getPersons();
}
