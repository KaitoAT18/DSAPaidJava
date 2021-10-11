package other;

import java.time.LocalTime;

public class Ok {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(15, 31, 24);
        time.plusMinutes(30);
        System.out.println(time);
    }
}
