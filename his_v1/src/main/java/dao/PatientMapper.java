package dao;

import entity.Patient;
import org.apache.ibatis.annotations.Param;

public interface PatientMapper {
    Patient getPatientByName(String name);

    Patient getPatientById(int id);

    int insertPatient(@Param("id") int id, @Param("name") String name, @Param("gender") int gender, @Param("idNumber") String idNumber, @Param("birthday") String birthday, @Param("address") String address);

}
