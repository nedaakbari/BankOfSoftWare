package ir.maktab.HW14.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateLastDaysMonthTest {
    Date date;

    @BeforeEach
    void init() {
        date = new Date();
    }

    //all test in one method
    @ParameterizedTest
    @CsvSource({"2,31", "1,31", "6,31", "7,30", "9,30", "11,30", "12,29"})
    void oneMonthInYear_getMonthLastDay_ResponseLastDay(int month, int expected) {
        int monthLastDay = date.getMonthLastDay(month);
        assertEquals(expected, monthLastDay);
    }

    @ParameterizedTest
    @CsvSource({"1,31", "2,31", "6,31", "4,31"})
    void sixFirstMonth_getMonthLastDay_ResponseLastDay(int month, int expected) {
        int monthLastDay = date.getMonthLastDay(month);
        assertEquals(expected, monthLastDay);
    }

    @ParameterizedTest
    @CsvSource({"7,30", "9,30", "8,30", "10,30", "11,30"})
    void fiveSecondMonth_getMonthLastDay_ResponseLastDay(int month, int expected) {
        int monthLastDay = date.getMonthLastDay(month);
        assertEquals(expected, monthLastDay);
    }

    @Test
    void lastMonthOfYear_getMonthLastDay_ResponseLastDay() {
        int monthLastDay = date.getMonthLastDay(12);
        assertEquals(29, monthLastDay);
    }


}
