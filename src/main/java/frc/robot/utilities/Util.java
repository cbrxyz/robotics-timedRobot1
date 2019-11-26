package frc.robot.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Util {
    public static void log(String message) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss-SSS");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date = new Date();
        System.out.println("[" + dateFormat.format(date) + "] " + message);
    }
}