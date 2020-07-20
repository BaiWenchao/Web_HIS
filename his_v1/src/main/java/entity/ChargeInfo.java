package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeInfo {
    private int id;
    private int regId;
    private String patientName;
    private String itemName;
    private float itemPrice;
    private int amount;
    private String opentime;
    private String DrugStatus;
}
