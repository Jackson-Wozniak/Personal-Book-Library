package internal.api.backend.users.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static internal.api.backend.users.utils.DateFormatting.*;

class DateFormattingTest {

    @Test
    void testFirstOfMonth(){
        assertEquals("January 1st, 2024", toWords(LocalDate.of(2024, 1, 1).atStartOfDay()));
        assertEquals("February 1st, 2024", toWords(LocalDate.of(2024, 2, 1)));
        assertEquals("March 1st, 2024", toWords(LocalDate.of(2024, 3, 1)));
        assertEquals("April 1st, 2024", toWords(LocalDate.of(2024, 4, 1)));
        assertEquals("May 1st, 2024", toWords(LocalDate.of(2024, 5, 1)));
        assertEquals("June 1st, 2024", toWords(LocalDate.of(2024, 6, 1)));
        assertEquals("July 1st, 2024", toWords(LocalDate.of(2024, 7, 1)));
        assertEquals("August 1st, 2024", toWords(LocalDate.of(2024, 8, 1)));
        assertEquals("September 1st, 2024", toWords(LocalDate.of(2024, 9, 1)));
        assertEquals("October 1st, 2024", toWords(LocalDate.of(2024, 10, 1)));
        assertEquals("November 1st, 2024", toWords(LocalDate.of(2024, 11, 1)));
        assertEquals("December 1st, 2024", toWords(LocalDate.of(2024, 12, 1)));
    }

    @Test
    void testSecondOfMonth(){
        assertEquals("January 2nd, 2024", toWords(LocalDate.of(2024, 1, 2).atStartOfDay()));
        assertEquals("February 2nd, 2024", toWords(LocalDate.of(2024, 2, 2)));
        assertEquals("March 2nd, 2024", toWords(LocalDate.of(2024, 3, 2)));
        assertEquals("April 2nd, 2024", toWords(LocalDate.of(2024, 4, 2)));
        assertEquals("May 2nd, 2024", toWords(LocalDate.of(2024, 5, 2)));
        assertEquals("June 2nd, 2024", toWords(LocalDate.of(2024, 6, 2)));
        assertEquals("July 2nd, 2024", toWords(LocalDate.of(2024, 7, 2)));
        assertEquals("August 2nd, 2024", toWords(LocalDate.of(2024, 8, 2)));
        assertEquals("September 2nd, 2024", toWords(LocalDate.of(2024, 9, 2)));
        assertEquals("October 2nd, 2024", toWords(LocalDate.of(2024, 10, 2)));
        assertEquals("November 2nd, 2024", toWords(LocalDate.of(2024, 11, 2)));
        assertEquals("December 2nd, 2024", toWords(LocalDate.of(2024, 12, 2)));
    }

    @Test
    void testThirdOfMonth(){
        assertEquals("January 3rd, 2024", toWords(LocalDate.of(2024, 1, 3).atStartOfDay()));
        assertEquals("February 3rd, 2024", toWords(LocalDate.of(2024, 2, 3)));
        assertEquals("March 3rd, 2024", toWords(LocalDate.of(2024, 3, 3)));
        assertEquals("April 3rd, 2024", toWords(LocalDate.of(2024, 4, 3)));
        assertEquals("May 3rd, 2024", toWords(LocalDate.of(2024, 5, 3)));
        assertEquals("June 3rd, 2024", toWords(LocalDate.of(2024, 6, 3)));
        assertEquals("July 3rd, 2024", toWords(LocalDate.of(2024, 7, 3)));
        assertEquals("August 3rd, 2024", toWords(LocalDate.of(2024, 8, 3)));
        assertEquals("September 3rd, 2024", toWords(LocalDate.of(2024, 9, 3)));
        assertEquals("October 3rd, 2024", toWords(LocalDate.of(2024, 10, 3)));
        assertEquals("November 3rd, 2024", toWords(LocalDate.of(2024, 11, 3)));
        assertEquals("December 3rd, 2024", toWords(LocalDate.of(2024, 12, 3)));
    }

    @Test
    void testFourthOfMonth(){
        assertEquals("January 4th, 2024", toWords(LocalDate.of(2024, 1, 4).atStartOfDay()));
        assertEquals("February 4th, 2024", toWords(LocalDate.of(2024, 2, 4)));
        assertEquals("March 4th, 2024", toWords(LocalDate.of(2024, 3, 4)));
        assertEquals("April 4th, 2024", toWords(LocalDate.of(2024, 4, 4)));
        assertEquals("May 4th, 2024", toWords(LocalDate.of(2024, 5, 4)));
        assertEquals("June 4th, 2024", toWords(LocalDate.of(2024, 6, 4)));
        assertEquals("July 4th, 2024", toWords(LocalDate.of(2024, 7, 4)));
        assertEquals("August 4th, 2024", toWords(LocalDate.of(2024, 8, 4)));
        assertEquals("September 4th, 2024", toWords(LocalDate.of(2024, 9, 4)));
        assertEquals("October 4th, 2024", toWords(LocalDate.of(2024, 10, 4)));
        assertEquals("November 4th, 2024", toWords(LocalDate.of(2024, 11, 4)));
        assertEquals("December 4th, 2024", toWords(LocalDate.of(2024, 12, 4)));
    }
}