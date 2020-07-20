package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegRecord {
    private int id;
    private int patientId;
    private String patientName;
    private int patientGender;
    private int patientAge;
    private String regDate;
    private String regNoon;
    private int deptId;
    private int doctorId;
    private int regLevelId;
    private int calClassId;
    private int needBook;
    private int registrarId;
    private int regStatus;
    private int feeType;
}
