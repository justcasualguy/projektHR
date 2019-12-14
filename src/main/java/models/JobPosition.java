package models;
import interfaces.DatabaseObject;
import org.bson.Document;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class JobPosition implements DatabaseObject {
   private String since;
   private String until;
   private String positionName;
   private String department;

    public JobPosition() {
    }

    public JobPosition(String since, String until, String positionName, String department) {
        this.since = since;
        this.until = until;
        this.positionName = positionName;
        this.department = department;
    }

    //<editor-fold desc="Getters and setters">

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
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
        return new Document("since", since)
                .append("to", until)
                .append("position name",positionName)
                .append("depatment",department);
    }
}
