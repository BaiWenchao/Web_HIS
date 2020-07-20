package dao;

import entity.RegRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegLevelMapper {
    List<String> getRegLevelList();
    int getRegLevelId(String level);
    int getRegLimit(int id);
    List<Integer> getFee();
}
