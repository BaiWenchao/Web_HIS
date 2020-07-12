package entity;

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
    private Date birthday;
    private String address;
}
