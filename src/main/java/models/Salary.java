package models;

public class Salary {
   private  String beginPeriodDate;
   private  String endPeriodDate;
   private  String salary;

    public Salary(String salary, String beginPeriodDate, String endPeriodDate) {
        this.beginPeriodDate = beginPeriodDate;
        this.endPeriodDate = endPeriodDate;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Salary{" +
                "beginPeriodDate='" + beginPeriodDate + '\'' +
                ", endPeriodDate='" + endPeriodDate + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
