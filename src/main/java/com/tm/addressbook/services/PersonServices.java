package main.java.com.tm.addressbook.services;

import main.java.com.tm.addressbook.contracts.IPersonServices;
import main.java.com.tm.addressbook.domain.Person;

import java.time.Period;

/**
 * Created by Aktorius on 08/05/2017.
 * Class that implements the contracts exposed in IPersonServices
 */
public class PersonServices implements IPersonServices {
    @Override
    public int findAgeDifferenceInDaysBetween(Person firstPerson, Person otherPerson) {
        if (firstPerson == null) throw new IllegalArgumentException("firstPerson cannot be null");
        if(otherPerson == null) throw new IllegalArgumentException("otherPerson cannot be null");

        Period period = Period.between(firstPerson.getDateOfBirth(), otherPerson.getDateOfBirth());
        return period.getDays();
    }
}
