package test.java.com.tm.addressbook.domain;

import main.java.com.tm.addressbook.domain.AddressBookCsv;
import main.java.com.tm.addressbook.contracts.IAddressBook;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Aktorius on 08/05/2017.
 */
public class AddressBookCsvTests {

    @Test (expected = NoSuchFileException.class)
    public void createAnAddressBookFromANonExistingUrlShouldThrowAnException() throws IOException {
        // Given
        String url = "nonExistingUrl";

        // When
        IAddressBook addressBook = new AddressBookCsv(url);

        // Then an exception should have been thrown
    }

    @Test
    public void getAddressBookWhenFileExistsShouldReturnTheCreatedAddressBook() throws IOException {
        // Given
        String url = "resources/testAddressBook1";

        // When
        IAddressBook addressBook = new AddressBookCsv(url);

        // Then
        assertNotNull(addressBook.getPersons());
    }
}
