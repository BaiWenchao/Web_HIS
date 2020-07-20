package entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int id;
    private String patientName;
    private int patientGender;
    private String idNumber;

    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    private int age;
    private String readableGender;

    public Patient(int id, String patientName, int patientGender, String idNumber, Date birthday, String address) {
        this.id = id;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.idNumber = idNumber;
        this.birthday = birthday;
        this.address = address;
    }
}
