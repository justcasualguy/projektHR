package models;

public class Salary {
   private  String beginPeriodDate;
   private  String endPeriodDate;
   private  String salary;

    public Salary() {
    }

    public Salary(String salary, String beginPeriodDate, String endPeriodDate) {
        this.beginPeriodDate = beginPeriodDate;
        this.endPeriodDate = endPeriodDate;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return salary +"\n za okres od "+beginPeriodDate+" do "+endPeriodDate;
    }

    public String getBeginPeriodDate() {
        return beginPeriodDate;
    }

    public void setBeginPeriodDate(String beginPeriodDate) {
        this.beginPeriodDate = beginPeriodDate;
    }

    public String getEndPeriodDate() {
        return endPeriodDate;
    }

    public void setEndPeriodDate(String endPeriodDate) {
        this.endPeriodDate = endPeriodDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
