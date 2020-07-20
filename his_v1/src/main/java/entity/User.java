package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String userName;
    private String pwd;
    private String realName;
    private int userCate;
    private int doctorTitle;
    private String isScheduling;
    private int deptId;
    private int regLevel;
    private int isDelete;
}
