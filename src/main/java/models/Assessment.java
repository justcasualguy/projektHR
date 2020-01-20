package models;

public class Assessment {

    private String date;
    private String commentary;
    private String addedBy;

    public Assessment(){

    }

    public Assessment(String date, String commentary, String addedBy) {
        this.date = date;
        this.commentary = commentary;
        this.addedBy = addedBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
}
