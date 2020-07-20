package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disease {
    private int id;
    private String diseaseCode;
    private String diseaseName;
    private String diseaseICD;
    private int diseaseCategoryId;
    private int isDelete;
}
