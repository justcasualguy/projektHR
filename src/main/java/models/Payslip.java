package models;
import interfaces.DatabaseObject;
import org.bson.Document;

import java.time.LocalDate;

public class Payslip implements DatabaseObject {

    private double netPay; //netto
    private double grossPay; //brutto
    private String currency;
    private LocalDate paymentDate;
    private String documentPath;

    public Payslip(double netPay, double grossPay, String currency, LocalDate paymentDate, String documentPath) {
        this.netPay = netPay;
        this.grossPay = grossPay;
        this.currency = currency;
        this.paymentDate = paymentDate;
        this.documentPath = documentPath;
    }

    //<editor-fold desc="Getters and setters">
    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
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
        return new Document("net pay",Double.toString(netPay)+' '+currency)
                .append("grossPay",Double.toString(grossPay)+' '+currency)
                .append("paymentDate",paymentDate)
                .append("documentPath",documentPath);
    }
}
