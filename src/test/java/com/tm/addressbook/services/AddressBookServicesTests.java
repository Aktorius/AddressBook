package test.java.com.tm.addressbook.services;

import main.java.com.tm.addressbook.contracts.IAddressBook;
import main.java.com.tm.addressbook.contracts.IAddressBookServices;
import main.java.com.tm.addressbook.domain.AddressBook;
import main.java.com.tm.addressbook.domain.Person;
import main.java.com.tm.addressbook.services.AddressBookServices;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Aktorius on 08/05/2017.
 */
public class AddressBookServicesTests {
    @Test
    public void numberOfPersonsShoulsReturnTheNumberOfPersonsInTheAddressBook(){
        // Given
        List<Person> persons = new ArrayList<>();

        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);
        Person mockPerson3 = mock(Person.class);
        Person mockPerson4 = mock(Person.class);
        Person mockPerson5 = mock(Person.class);

        persons.add(mockPerson1);
        persons.add(mockPerson2);
        persons.add(mockPerson3);
        persons.add(mockPerson4);
        persons.add(mockPerson5);

        IAddressBook addressBook = new AddressBook(persons);
        IAddressBookServices addressBookServices = new AddressBookServices(addressBook);

        // When
        int expectedNumberOfPersons = addressBookServices.numberOfPersons();

        // Then
        assertEquals("numberOfPersons should return 5", 5, expectedNumberOfPersons);
    }

    @Test (expected = NoSuchElementException.class)
    public void findOldestPersonShouldThrowAnExceptionWhenAddressBookIsEmpty(){
        // Given
        List<Person> persons = new ArrayList<>();
        IAddressBook addressBook = new AddressBook(persons);
        IAddressBookServices addressBookServices = new AddressBookServices(addressBook);

        // When
        addressBookServices.findOldestPerson();

        // Then an exception should have been thrown
    }

    @Test
    public void findOldestPersonShouldReturnTheOldestInTheAddressBook() throws IOException {
        // Given
        LocalDate now = LocalDate.now();
        List<Person> persons = new ArrayList<>();

        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);
        Person mockPerson3 = mock(Person.class);
        Person mockPerson4 = mock(Person.class);
        Person mockPerson5 = mock(Person.class);

        when(mockPerson1.getDateOfBirth()).thenReturn(now);
        when(mockPerson2.getDateOfBirth()).thenReturn(now.plusDays(10));
        when(mockPerson3.getDateOfBirth()).thenReturn(now.plusDays(20));
        when(mockPerson4.getDateOfBirth()).thenReturn(now.plusDays(30));
        when(mockPerson5.getDateOfBirth()).thenReturn(now.plusDays(40));


        persons.add(mockPerson1);
        persons.add(mockPerson2);
        persons.add(mockPerson3);
        persons.add(mockPerson4);
        persons.add(mockPerson5);

        IAddressBook addressBook = new AddressBook(persons);
        IAddressBookServices addressBookServices = new AddressBookServices(addressBook);

        //When
        Person oldest = addressBookServices.findOldestPerson();

        //Then
        assertEquals("findOldestPerson should return mockPerson1", mockPerson1, oldest);
    }

    @Test (expected = NoSuchElementException.class)
    public void findPersonByNameWithNobodyOfThatNameShouldThrowAnException() throws IOException {
        // Given
        List<Person> persons = new ArrayList<>();

        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);
        Person mockPerson3 = mock(Person.class);
        Person mockPerson4 = mock(Person.class);
        Person mockPerson5 = mock(Person.class);

        when(mockPerson1.getName()).thenReturn("mock person1");
        when(mockPerson2.getName()).thenReturn("mock person2");
        when(mockPerson3.getName()).thenReturn("mock person3");
        when(mockPerson4.getName()).thenReturn("mock person4");
        when(mockPerson5.getName()).thenReturn("mock person5");


        persons.add(mockPerson1);
        persons.add(mockPerson2);
        persons.add(mockPerson3);
        persons.add(mockPerson4);
        persons.add(mockPerson5);

        IAddressBook addressBook = new AddressBook(persons);
        IAddressBookServices addressBookServices = new AddressBookServices(addressBook);

        // When
        addressBookServices.findPersonByName("non existing");

        // Then an exception should have been thrown
    }

    @Test
    public void findPersonByNameShouldReturnThePersonWithTheSearchedName() throws IOException {
        // Given
        List<Person> persons = new ArrayList<>();

        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);
        Person mockPerson3 = mock(Person.class);
        Person mockPerson4 = mock(Person.class);
        Person mockPerson5 = mock(Person.class);

        when(mockPerson1.getName()).thenReturn("mock person1");
        when(mockPerson2.getName()).thenReturn("mock person2");
        when(mockPerson3.getName()).thenReturn("mock person3");
        when(mockPerson4.getName()).thenReturn("mock person4");
        when(mockPerson5.getName()).thenReturn("mock person5");


        persons.add(mockPerson1);
        persons.add(mockPerson2);
        persons.add(mockPerson3);
        persons.add(mockPerson4);
        persons.add(mockPerson5);

        IAddressBook addressBook = new AddressBook(persons);
        IAddressBookServices addressBookServices = new AddressBookServices(addressBook);

        // When
        Person found = addressBookServices.findPersonByName("mock person3");

        // Then
        assertEquals("findPersonByName shouls return mockPerson3", mockPerson3, found);
    }
}
