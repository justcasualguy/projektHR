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
}
