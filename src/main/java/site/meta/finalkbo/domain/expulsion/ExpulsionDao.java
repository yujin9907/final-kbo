package site.meta.finalkbo.domain.expulsion;

import site.meta.finalkbo.web.dto.request.ExclusionInsertDto;

import java.util.List;

public interface ExpulsionDao {
    public void insert(ExclusionInsertDto exclusionInsertDto);
    public List<Expulsion> findAll();
    public void findById(Integer id);
    public void deleteById(Integer id);
    public void update();
}
