import services.Validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Test {

    public static boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            System.out.println(sdf);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void run(){

    }
    public static void main(String[] args) {
//    String date = "2000-02-30";
//        String date2 = "2000-02-27";
//        String date3 = "31/02/2000";
//    System.out.println(isValid(date));
//        System.out.println(isValid(date2));
//        System.out.println(isValid(date3));
System.out.println(Validators.validatePhone("1234567891"));
        System.out.println(Validators.validatePhone("12345678"));



    }

}
