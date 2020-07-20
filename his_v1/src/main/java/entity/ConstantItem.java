package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstantItem {
    private int id;
    private int constantTypeId;
    private String constantCode;
    private String constantName;
    private int isDelete;
}