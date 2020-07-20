package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstantType {
    private int id;
    private String constantTypeCode;
    private String constantTypeName;
    private int isDelete;
}
