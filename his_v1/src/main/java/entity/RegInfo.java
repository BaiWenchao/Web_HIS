package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegInfo {
    private int id;
    private int regId;
    private String chiefComplaint;
    private String currentHistory;
    private String currentSituation;
    private String pastHistory;
    private String allergiesHistory;
    private String bodyCheck;
}
