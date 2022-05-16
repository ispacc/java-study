package java8.local_date_time;

import java.time.format.DateTimeFormatter;

public class LocalDateTime {
    public static void main(String[] args) {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"));
        System.out.println(format);

    }
}
