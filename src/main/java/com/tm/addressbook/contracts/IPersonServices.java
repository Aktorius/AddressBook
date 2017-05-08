package main.java.com.tm.addressbook.contracts;

import main.java.com.tm.addressbook.domain.Person;

/**
 * Created by Aktorius on 08/05/2017.
 * Contract that exposes the possible actions on an object of type Person
 */
public interface IPersonServices {

    /**
     * Method calculation the age difference in days between two persons
     * @param firstPerson the first person
     * @param otherPerson the second person
     * @return an integer representing the number of days between the two persons date of birth
     */
    int findAgeDifferenceInDaysBetween(Person firstPerson, Person otherPerson);
}
