package dao;

import entity.DrugTemplate;

public interface DrugTemplateMapper {
    DrugTemplate getTemplateByName(String name);
}
