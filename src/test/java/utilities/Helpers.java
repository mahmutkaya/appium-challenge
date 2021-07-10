package utilities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helpers {

    public static String generateDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("ddMMHHmmss");
        return now.format(formatDate);
    }

}
