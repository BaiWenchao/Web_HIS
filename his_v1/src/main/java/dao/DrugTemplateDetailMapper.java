package dao;

import entity.DrugTemplateDetail;

import java.util.List;

public interface DrugTemplateDetailMapper {
    List<DrugTemplateDetail> getTemplateDetail(int id);
}
