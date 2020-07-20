package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int id;
    private String deptCode;
    private String deptName;
    private int deptCategoryId;
    private int deptType;
    private int isDelete;
}
