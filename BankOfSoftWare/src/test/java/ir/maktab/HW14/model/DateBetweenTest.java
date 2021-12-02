package ir.maktab.HW14.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateBetweenTest {
    static Date borrowDate;

    @BeforeAll
    static void beforeAll() {
        borrowDate = new Date(1382, 6, 25);
    }

    //all test in one method
    @ParameterizedTest
    @CsvSource({"1382,6,31,6", "1382,7,2,8", "1382, 12, 29,185", "1383, 2, 1,217"})
    void deliveryDate_CallBetweenMethod_calculateDeliveryAndBorrow(int year, int month, int day, int expected) {
        Date deliveryDate = new Date(year, month, day);
        int between = deliveryDate.between(borrowDate);
        assertEquals(between, expected);
    }


    @ParameterizedTest
    @CsvSource({"1382,6,31,6", "1382,6,26,1", "1382,6,30,5"})
    void deliveryDateBorrowDateSameMonth_CallBetweenMethod_calculateDaysBetween(int year, int month, int day, int expected) {
        Date deliveryDate = new Date(year, month, day);
        int between = deliveryDate.between(borrowDate);
        assertEquals(between, expected);
    }


    @ParameterizedTest
    @CsvSource({"1382,7,2,8", "1382,7,30,36", "1382,8,1,37"})
    void deliveryDateBorrowDateDifferentMonth_CallBetweenMethod_calculateDaysBetween(int year, int month, int day, int expected) {
        Date deliveryDate = new Date(year, month, day);
        int between = deliveryDate.between(borrowDate);
        assertEquals(between, expected);
    }

    // BorrowDate => in last day of year
    @ParameterizedTest
    @CsvSource({"1382,12,29,185", "1382,12,1,157"})
    void deliveryDateLastMonthOfYear_CallBetweenMethod_calculateDaysBetween(int year, int month, int day, int expected) {
        Date deliveryDate = new Date(year, month, day);
        int between = deliveryDate.between(borrowDate);
        assertEquals(between, expected);
    }

    //deliveryDate BorrowDate => in different year
    @ParameterizedTest
    @CsvSource({"1383,1,1,186", "1383,1,31,216", "1383,7,30,401"})
    void deliveryDateNextYear_CallBetweenMethod_calculateDaysBetween(int year, int month, int day, int expected) {
        Date deliveryDate = new Date(year, month, day);
        int between = deliveryDate.between(borrowDate);
        assertEquals(between, expected);
    }
}
