package models;

import interfaces.DatabaseObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity(value = "Employees",noClassnameStored = true)
public class Employee implements DatabaseObject {

    @Id
    public ObjectId id;

    private String name;
    private String surname;
    //private String gender;
    @Property("birth date")
    private String birthDate;
    private String personalIdentityNumber;
    private String idCardNumber;
    private String employedSince;
    private String contractType;
    private String salary;
    private String addedBy;
    private String phoneNumber;
    @Embedded
    private JobPosition jobPosition;
    @Embedded
    private Address address;
    private LinkedList<JobPosition> careerPath;                                     //nie dodane do toDocument
    private LinkedList<Rating> ratings;                 //nie dodane do toDocument
    private List<String> qualifications = new ArrayList<>();                   //nie dodane do toDocument

    public Employee() {
    }

    public Employee(String name, String surname, String birthDate, String employedSince, JobPosition jobPosition, Address address, LinkedList<JobPosition> careerPath, LinkedList<Rating> ratings) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.employedSince = employedSince;
        this.jobPosition = jobPosition;
        this.address = address;
        this.careerPath = careerPath;
        this.ratings = ratings;
    }

    public Employee(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Employee(String name, String surname, String birthDate, String personalIdentityNumber,String idCardNumber, String employedSince, JobPosition jobPosition,String salary,String contractType, Address address,List<String> qual, String addedBy) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.personalIdentityNumber = personalIdentityNumber;
        this.employedSince = employedSince;
        this.jobPosition = jobPosition;
        this.address = address;
        this.idCardNumber=idCardNumber;
        this.contractType=contractType;
        this.addedBy=addedBy;
        this.salary=salary;
        this.qualifications = qual;
    }


    public Employee(String name, String surname, String birthDate, String personalIdentityNumber,String idCardNumber, String employedSince, JobPosition jobPosition,String salary,String phoneNumber,String contractType, Address address,String addedBy) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.personalIdentityNumber = personalIdentityNumber;
        this.employedSince = employedSince;
        this.jobPosition = jobPosition;
        this.address = address;
        this.idCardNumber=idCardNumber;
        this.contractType=contractType;
        this.addedBy=addedBy;
        this.salary=salary;
        this.phoneNumber=phoneNumber;
    }
    //<editor-fold desc="Getters and setters">
    public ObjectId getId() {
        return id;
    }



    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public void setPersonalIdentityNumber(String personalIdentityNumber) {
        this.personalIdentityNumber = personalIdentityNumber;
    }

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



    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmployedSince() {
        return employedSince;
    }

    public void setEmployedSince(String employedSince) {
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

    public List<String> getQualifications(){ return qualifications;}

    public void setQualifications(){ this.qualifications = qualifications;}

    //</editor-fold>

    @Override
    public Document toDocument() {
        return new Document("name",name)
                .append("surname",surname)
                .append("birth date", birthDate);
                //.append("employed since",employedSince.toString())
              //  .append("job position: ",jobPosition.toDocument());
                //.append("address",address.toDocument());
    }

    @Override
    public String toString() {
        return String.format("Name: %s Surname: %s BirthDate: %s",name,surname,birthDate);
    }
}
