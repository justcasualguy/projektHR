package models;
import interfaces.DatabaseObject;
import org.bson.Document;

import java.time.LocalDate;


public class JobPosition implements DatabaseObject {
   private LocalDate since;
   private LocalDate to;
   private String positionName;
   private String department;

    public JobPosition(LocalDate since, LocalDate to, String positionName, String department) {
        this.since = since;
        this.to = to;
        this.positionName = positionName;
        this.department = department;
    }

    //<editor-fold desc="Getters and setters">

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    //</editor-fold>


    @Override
    public Document toDocument() {
        return new Document("since",since.toString())
                .append("to",to.toString())
                .append("position name",positionName)
                .append("depatment",department);
    }
}
