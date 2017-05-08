package test.java.com.tm.addressbook.services;

import main.java.com.tm.addressbook.contracts.IPersonServices;
import main.java.com.tm.addressbook.domain.Person;
import main.java.com.tm.addressbook.services.PersonServices;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Aktorius on 08/05/2017.
 *
 */
public class PersonServicesTests {

    @Test
    public void findAgeDifferenceInDaysWithTwoCorrectPersonsShouldReturnTheNumberOfDaysDifference() {
        // Given
        LocalDate now = LocalDate.now();
        IPersonServices personServices = new PersonServices();
        Person mockPerson1 = mock(Person.class);
        Person mockPerson2 = mock(Person.class);

        // When
        when(mockPerson1.getDateOfBirth()).thenReturn(now);
        when(mockPerson2.getDateOfBirth()).thenReturn(now.plusDays(10));

        int days = personServices.findAgeDifferenceInDaysBetween(mockPerson1, mockPerson2);

        // Then
        assertEquals("mockPerson1 should be 10 days older than mockPerson2", 10, days);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAgeDifferenceInDaysWhenFirstPersonIsNullShouldThrowAnException() {
        // Given
        IPersonServices personServices = new PersonServices();
        Person mockPerson = mock(Person.class);

        // When
        int days = personServices.findAgeDifferenceInDaysBetween(null, mockPerson);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAgeDifferenceInDaysWhenOtherPersonIsNullShouldThrowAnException() {
        // Given
        IPersonServices personServices = new PersonServices();
        Person mockPerson = mock(Person.class);

        // When
        int days = personServices.findAgeDifferenceInDaysBetween(null, mockPerson);
    }
}