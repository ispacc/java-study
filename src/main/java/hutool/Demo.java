package hutool;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;

public class Demo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTimeUtil.now();
        System.out.println(dateTime);
    }
}
