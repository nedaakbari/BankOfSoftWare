package ir.maktab.HW14.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonGetLateDaysTest {
    BorrowOperation borrowOperation = new BorrowOperation(DiscType.office.getName(), new Date(1382, 1, 1));
    Person mj = new Person("mj");

    @Test
    public void Test() {
        borrowOperation.setPerson(mj);
        borrowOperation.isLate(new Date(1382, 1, 9));
        Assertions.assertEquals(1, mj.getLateDays());
    }
}
