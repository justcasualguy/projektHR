package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validators {
    public static String dateFormat = "yyyy-MM-dd";

    public static boolean validateDate(String date) {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            System.out.println(sdf);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean validateName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateSurname(String surname) {
        return surname.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
    }

    public static boolean validateAddress(String address) {
        return address.matches("([a-zA-Z]+|[a-zA-Z]+s[a-zA-Z]+)s+d+");
    }


    public static boolean validateCity(String city) {
        return city.matches("([a-zA-Z]+|[a-zA-Z]+s[a-zA-Z]+)");
    }

    public static boolean validateZip(String zip) {
        return zip.matches("d{5}");
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("[0-9]{9}");
    }

    public static boolean validateSalary(String salary){
        return salary.matches("[1-9]{1}[0-9]{0,},[0-9]{2}");
    }
    public static boolean validateContractType(String contractType){
        return !(contractType==null);
    }
}
