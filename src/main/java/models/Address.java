package models;

import interfaces.DatabaseObject;
import org.bson.Document;


public class Address implements DatabaseObject {
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String houseUnitNumber;
    private String zipcode;

    public Address(String country, String city, String street, String houseNumber, String houseUnitNumber, String zipcode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseUnitNumber = houseUnitNumber;
        this.zipcode = zipcode;
    }

    //<editor-fold desc="Getters and setters">
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseUnitNumber() {
        return houseUnitNumber;
    }

    public void setHouseUnitNumber(String houseUnitNumber) {
        this.houseUnitNumber = houseUnitNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    //</editor-fold>

    @Override
    public Document toDocument(){
       return new Document("country",country)
               .append("street",street)
               .append("houseNumber",houseNumber)
               .append("houseUnitNumber",houseUnitNumber)
               .append("city",city)
               .append("zipcode",zipcode);

    }
}
