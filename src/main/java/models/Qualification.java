package models;

import interfaces.DatabaseObject;
import org.bson.Document;

public class Qualification implements DatabaseObject {
   private String qualificationName;
   private String documentPath;

    public Qualification(String qualificationName, String documentPath) {
        this.qualificationName = qualificationName;
        this.documentPath = documentPath;
    }

    //<editor-fold desc="Getters and setters">
    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
    //</editor-fold>


    @Override
    public Document toDocument() {
        return new Document("qualification name",qualificationName)
                .append("document path:",documentPath);
    }
}
