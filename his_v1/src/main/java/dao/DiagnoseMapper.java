package dao;

import org.apache.ibatis.annotations.Param;

public interface DiagnoseMapper {
    int insertDiagnose(@Param("regId") int regId, @Param("diseaseName") String diseaseName);
}
