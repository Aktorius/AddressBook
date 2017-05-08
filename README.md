# AddressBook - Aktorius

## Introduction

My solution to the Gumtree coding challenge from https://github.com/gumtreeuk/address-book

## Requirements

This project requires Java 8

## Structure

- pom.xml - maven configuration for building the application
- application folder - The main client
- contracts folder - The interfaces
- domain folder - All business classes
- service folder - Services classes
- test folder - All tests

## Build, Test and Run

- Build: mvn clean install
- Test: mvn test
- Run:  mvn exec:java -Dexec.mainClass="main.java.com.tm.addressbook.application.AddressBookApplication"

## Libraries

- Junit and Mockito - unit testing Frameworks to automate tests and mock objects

## Design And Technical Decisions

For this test I have decided to use an Adapter design pattern for the address book which
allows to easily create address books based on other sources if necessary ie database
