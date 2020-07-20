package dao;

import entity.Disease;

public interface DiseaseMapper {
    Disease getDiseaseByName(String name);
}
