package ces.augusto108.hrpayroll.model.entities;

import java.io.Serializable;

public class Payment implements Serializable {
    private static final long serialVersionUID = 832700978057173968L;

    private String employeeName;
    private Double dailyIncome;
    private Integer numberOfDays;

    public Payment() {
    }

    public Payment(String employeeName, Double dailyIncome, Integer numberOfDays) {
        this.employeeName = employeeName;
        this.dailyIncome = dailyIncome;
        this.numberOfDays = numberOfDays;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public String getTotal() {
        return String.format("%.2f", dailyIncome * numberOfDays);
    }
}
