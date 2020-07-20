package dao;

import java.util.List;

public interface DepartmentMapper {
    List<String> getDocDepts(int userCate);

    int getDeptId(String name);
}
