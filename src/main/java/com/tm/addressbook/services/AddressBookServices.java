package main.java.com.tm.addressbook.services;

import main.java.com.tm.addressbook.contracts.IAddressBookServices;
import main.java.com.tm.addressbook.domain.Person;

import java.util.NoSuchElementException;

/**
 * Created by Aktorius on 08/05/2017.
 */
public class AddressBookServices implements IAddressBookServices {
    @Override
    public int numberOfPersons() {
        return 0;
    }

    @Override
    public int countMales() {
        return 0;
    }

    @Override
    public Person findOldestPerson() throws NoSuchElementException {
        return null;
    }

    @Override
    public Person findPersonByName(String name) throws NoSuchElementException {
        return null;
    }
}
