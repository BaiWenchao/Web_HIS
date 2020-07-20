package dao;

import java.util.List;

public interface ConstantItemMapper {
    String getConstantItemById(int id);

    List<String> getConstantItemListByTypeId(int id);
}
