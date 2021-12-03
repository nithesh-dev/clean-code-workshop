package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.NEW_RELEASE), 3));

        assertEquals("Rental Record for ABC\n" +
                "\tMovie-1\t5.0\n" +
                "\tMovie-2\t4.5\n" +
                "\tMovie-2\t9.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }
}
