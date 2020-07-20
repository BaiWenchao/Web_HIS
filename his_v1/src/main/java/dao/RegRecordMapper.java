package dao;

import entity.Patient;
import entity.RegRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegRecordMapper {
    int getRegCount(@Param("id") int id, @Param("date") String date);
    int insertRegRecord(RegRecord regRecord);

    // 根据医生Id, 当前日期选中已诊患者记录：
    List<RegRecord> getRegRecords_fore(@Param("id") int id, @Param("date") String date);
    // 根据医生Id, 当前日期选中未诊患者记录
    List<RegRecord> getRegRecords_after(@Param("id") int id, @Param("date") String date);
    // 根据医生Id, 当前日期选中非退号患者记录
    List<RegRecord> getRegRecords(@Param("id") int id, @Param("date") String date);
    // 根据患者挂号ID，更新患者挂号状态
    int updateRegRecord(@Param("regId") int regId, @Param("status") int status);
    // 通过挂号ID获得患者姓名：
    int getPatientId(int id);
    // 通过挂号ID获得挂号记录
    RegRecord getRegRecord(int id);
}
