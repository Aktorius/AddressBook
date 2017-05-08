package main.java.com.tm.addressbook.domain;

import main.java.com.tm.addressbook.contracts.IAddressBook;
import main.java.com.tm.addressbook.domain.enums.Gender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Aktorius on 08/05/2017.
 * Class defining an AddressBookCsv.
 * An address book will be created based on a CSV file
 */
public class AddressBookCsv implements IAddressBook {
    private static final String SEPARATOR = ", ";
    private static final String FIRST_TWO_DIGITS_YEAR = "19";
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    private List<Person> persons;

    /**
     * Constructor that creates an address book based on a CSV file
     * @param filePath the path of the file
     * @throws IOException if something went wrong while reading the file
     * @throws NoSuchFileException if the file does not exist
     */
    public AddressBookCsv(String filePath) throws IOException, NoSuchFileException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        Stream<String> lines = Files.lines(Paths.get(filePath));
        Stream<String[]> arrayLines = lines.map(line -> line.split(SEPARATOR));

        List<Person> persons = arrayLines.map(arrayLine -> new Person(
                arrayLine[0],
                Gender.valueOf(arrayLine[1].toUpperCase()),
                LocalDate.parse(arrayLine[2].substring(0, 6) + FIRST_TWO_DIGITS_YEAR
                        + arrayLine[2].substring(6, arrayLine[2].length()), formatter)
        )).collect(Collectors.toList()); // Apply and Collect our transformations
        
        this.persons = persons;
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }
}
