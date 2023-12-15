
package models.model_H;

import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;

public class test {
    public static void main(String[] args) {
        // lấy ngày hiện tại
        // convert ngày 
        Date date = Date.valueOf(LocalDate.now());
        System.out.println(date);
    }
}
