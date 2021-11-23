package test;

import java.time.*;
import java.time.temporal.ChronoUnit;
public class DurationExample1 {
    public static void main(String[] args) {
        Duration d = Duration.ofSeconds(3);
        d = Duration.ofDays(1);
        System.out.print((long)d.getNano());
    }
}
