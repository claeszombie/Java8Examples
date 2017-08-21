import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
@RunWith(JUnit4.class)
public class DateTest {

    //Clock
    //TODO

    //Timezones
    //TODO

    //LocalTime
    //TODO

    //LocalDate
    //TODO

    //LocalDateTime
    @Test
    public void localDateTest(){
        //Get current date time
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Before : " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);

        System.out.println("After : " + formatDateTime);
    }
}
