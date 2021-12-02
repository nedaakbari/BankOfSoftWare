package ir.maktab.HW14.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateValidateTest {
    Date date;

    @BeforeEach
    void init() {
        date = new Date();//دیتاهایی که قراره تست رو آماده کنه ..میگم این اطلاعات رو بذار اینجا من میخوام ازش استفاده کنم
        //محیط برای اجرای تست اماده بشه
        //مثلا میخوایم فایلی رو بخونیم اینجا باید بخونیم و دیتاهارو اینزرت کنیم
    }

    @BeforeAll
    static void delete() {
        //مثلا برای هر بار استفاده از دیتابیس باید این رو چک کنیم که دیتابیس ما خالی هست پس متدش رو اینجا مینویسم
    }

    @ParameterizedTest
    @CsvSource({"1389,5,0", "1389,7,0", "1399,4,32", "1399,8,32", "1395,9,31", "1390,12,30"})
    void isValidateThisDays_isValidDate_ResponseFalse(int year, int month, int day) {
        boolean validDate = date.isValidDate(year, month, day);
        assertFalse(validDate);
    }

    @ParameterizedTest
    @CsvSource({"1389,5,1", "1389,7,1", "1389,8,30", "1399,4,31", "1390,12,29", "1390,3,12"})
    void isValidateThisDays_isValidDate_ResponseTrue(int year, int month, int day) {
        boolean validDate = date.isValidDate(year, month, day);
        assertTrue(validDate);
    }


}

