package dao;

import entity.ChargeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChargeInfoMapper {
    List<ChargeInfo> getChargeInfoByRegId(int id);

    int insertChargeInfo(@Param("id") int id, @Param("regId") int regId, @Param("patientName") String patientName, @Param("itemName") String itemName, @Param("itemPrice") float itemPrice, @Param("amount") int amount, @Param("openTime") String opemTime, @Param("drugStatus") String drugStatus);

    List<ChargeInfo> getDeliveredInfo(int id);
}
