package test.java.com.tm.addressbook.domain;

import main.java.com.tm.addressbook.contracts.IAddressBook;
import main.java.com.tm.addressbook.domain.AddressBook;
import main.java.com.tm.addressbook.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Aktorius on 08/05/2017.
 */
public class AddressBookTests {

    @Test (expected = IllegalArgumentException.class)
    public void createAddressBookWithNullParameterShouldThrowAnException(){
        // Given
        IAddressBook addressBook;

        // When
        addressBook = new AddressBook(null);

        // Then an exception must have been thrown
    }

    @Test
    public void getPersonsWhenAddressBookCreatedWithCorrectParamatersShouldReturnAListAPersons(){
        // Given
        List<Person> persons = new ArrayList<>();
        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);

        persons.add(mockPerson1);
        persons.add(mockPerson2);

        IAddressBook addressBook = new AddressBook(persons);

        // When
        List<Person> result = addressBook.getPersons();

        // Then
        assertNotNull("The list of persons should not be null", result);
    }

}
