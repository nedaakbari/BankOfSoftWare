package ir.maktab.HW14.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BorrowOperationIsLateTest {
    BorrowOperation borrowOperation;

    @BeforeEach
    void init() {
        borrowOperation = new BorrowOperation(DiscType.office.getName(), new Date(1382, 1, 1));
    }

    @Test
    void DeliveryAndBorrowDaysLessThan7Days_CallIsLateMethod_ResponseFalse() {
        boolean late = borrowOperation.isLate(new Date(1382, 1, 8));
        assertFalse(late);
    }

    @ParameterizedTest
    @CsvSource({"1382,1,9", "1,2,1382", "3,8,1382", "1,2,1383"})
    void DeliveryAndBorrowDaysMoreThan7Days_CallIsLateMethod_ResponseFalse(int year, int month, int day) {
        Person mj = new Person("mj");
        mj.setLateDays(0);
        borrowOperation.setPerson(mj);
        boolean late = borrowOperation.isLate(new Date(year, month, day));
        assertTrue(late);
    }
}
