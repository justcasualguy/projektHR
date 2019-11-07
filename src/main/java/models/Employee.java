package models;
import interfaces.DatabaseObject;
import org.bson.Document;

import java.time.LocalDate;
import java.util.LinkedList;


public class Employee implements DatabaseObject {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate employedSince;
    private JobPosition jobPosition;
    private Address address;
    private LinkedList<JobPosition> careerPath;                                     //nie dodane do toDocument
    private LinkedList<Rating> ratings;                 //nie dodane do toDocument
    private LinkedList<Qualification> qualifications;                   //nie dodane do toDocument

    public Employee(String name, String surname,  LocalDate birthDate, LocalDate employedSince, JobPosition jobPosition, Address address, LinkedList<JobPosition> careerPath, LinkedList<Rating> ratings, LinkedList<Qualification> qualifications) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.employedSince = employedSince;
        this.jobPosition = jobPosition;
        this.address = address;
        this.careerPath = careerPath;
        this.ratings = ratings;
        this.qualifications = qualifications;
    }

    public Employee(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    //<editor-fold desc="Getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmployedSince() {
        return employedSince;
    }

    public void setEmployedSince(LocalDate employedSince) {
        this.employedSince = employedSince;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LinkedList<JobPosition> getCareerPath() {
        return careerPath;
    }

    public void setCareerPath(LinkedList<JobPosition> careerPath) {
        this.careerPath = careerPath;
    }

    public LinkedList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(LinkedList<Rating> ratings) {
        this.ratings = ratings;
    }

    public LinkedList<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(LinkedList<Qualification> qualifications) {
        this.qualifications = qualifications;
    }
    //</editor-fold>

    @Override
    public Document toDocument() {
        return new Document("name",name)
                .append("surname",surname)
                .append("birth date",birthDate.toString());
                //.append("employed since",employedSince.toString())
              //  .append("job position: ",jobPosition.toDocument());
                //.append("address",address.toDocument());
    }

    @Override
    public String toString() {
        return String.format("Name: %s Surname: %s BirthDate: %s",name,surname,birthDate);
    }
}
