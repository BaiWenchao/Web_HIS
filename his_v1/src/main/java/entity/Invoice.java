package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private int id;
    private int invoiceNum;
    private double invoiceAmt;
    private double invoiceRealGet;
    private double invoiceBalance;
    private int invoiceStatus;
    private String invoiceTime;
    private int operatorId;
    private int regId;
}
