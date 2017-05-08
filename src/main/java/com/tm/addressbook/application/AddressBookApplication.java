package main.java.com.tm.addressbook.application;

import main.java.com.tm.addressbook.contracts.IAddressBook;
import main.java.com.tm.addressbook.contracts.IAddressBookServices;
import main.java.com.tm.addressbook.contracts.IPersonServices;
import main.java.com.tm.addressbook.domain.AddressBookCsv;
import main.java.com.tm.addressbook.domain.Person;
import main.java.com.tm.addressbook.services.AddressBookServices;
import main.java.com.tm.addressbook.services.PersonServices;

import java.io.IOException;

/**
 * Created by Aktorius on 08/05/2017.
 * Entry point of the application AddressBook
 * Contains a main method that answers some questions about the persons in the address book
 */
public class AddressBookApplication {
    private static final String PATH = "resources/AddressBook";
    private static IPersonServices personServices;
    private static IAddressBook addressBook;
    private static IAddressBookServices addressBookServices;

    public static void main (String [] args){
        personServices = new PersonServices();
        try {
            addressBook = new AddressBookCsv(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addressBookServices = new AddressBookServices(addressBook);

        /* Answer to question 1 */
        System.out.println("How many males are in the address book? " + addressBookServices.countMales());

       /* Answer to question 2 */
        System.out.println("Who is the oldest person in the address book? " + addressBookServices.findOldestPerson());

       /* Answer to question 3 */
        Person bill = addressBookServices.findPersonByName("Bill McKnight");
        Person paul = addressBookServices.findPersonByName("Paul Robinson");
        System.out.println("How many days older is Bill than Paul? " + personServices.findAgeDifferenceInDaysBetween(bill, paul));
    }
}
