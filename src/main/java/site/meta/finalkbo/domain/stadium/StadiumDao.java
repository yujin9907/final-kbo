package site.meta.finalkbo.domain.stadium;

import site.meta.finalkbo.web.dto.request.InsertDto;

import java.util.List;

public interface StadiumDao {
    public void insert(String name);
    public List<Stadium> findAll();
    public Stadium findById(Integer id);
    public void deleteById(Integer id);
    public void update(Stadium stadium);

}
