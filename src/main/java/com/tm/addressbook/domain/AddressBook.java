package main.java.com.tm.addressbook.domain;

import main.java.com.tm.addressbook.contracts.IAddressBook;

import java.util.List;

/**
 * Created by Aktorius on 08/05/2017.
 * Class defining an object of type AddressBook
 */
public class AddressBook implements IAddressBook {
    private List<Person> persons;

    /**
     * Constructor that creates an instance of AddressBook based on a list of persons
     * @param persons the list of persons to include in the address book
     */
    public AddressBook(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }
}
