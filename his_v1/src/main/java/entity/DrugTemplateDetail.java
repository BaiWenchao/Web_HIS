package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugTemplateDetail {
    private int id;
    private int templateId;
    private String drugName;
    private String drugFormat;
    private float drugPrice;
    private String drugUsage;
    private String drugDosage;
    private String drugFrequency;
    private int drugAmount;
}
