package java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class local_date_time {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"));
        System.out.println(format);

    }
}
