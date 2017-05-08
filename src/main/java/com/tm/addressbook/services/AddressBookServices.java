package main.java.com.tm.addressbook.services;

import main.java.com.tm.addressbook.contracts.IAddressBook;
import main.java.com.tm.addressbook.contracts.IAddressBookServices;
import main.java.com.tm.addressbook.domain.Person;
import main.java.com.tm.addressbook.domain.enums.Gender;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by Aktorius on 08/05/2017.
 */
public class AddressBookServices implements IAddressBookServices {
    private IAddressBook addressBook;

    /**
     * Constructor that creates an address book
     * @param addressBook the address book
     */
    public AddressBookServices(IAddressBook addressBook) {
        if(addressBook == null)
            throw new IllegalArgumentException("addressBook cannot be null");

        this.addressBook = addressBook;
    }

    @Override
    public int numberOfPersons() {
        return addressBook.getPersons().size();
    }

    @Override
    public int countMales() {
        return (int) addressBook.getPersons().stream().filter(p -> p.getGender() == Gender.MALE).count();
    }

    @Override
    public Person findOldestPerson() throws NoSuchElementException {
        return addressBook.getPersons().stream().min(Comparator.comparing(Person::getDateOfBirth)).get();
    }

    @Override
    public Person findPersonByName(String name) throws NoSuchElementException {
        return addressBook.getPersons().stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
