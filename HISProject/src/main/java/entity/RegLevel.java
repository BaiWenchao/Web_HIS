package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegLevel {
    private int id;
    private String regCode;
    private String regName;
    private float regFee;
    private int regLimit;
    private int isDelete;
}
