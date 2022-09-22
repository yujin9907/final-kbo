package site.meta.finalkbo.domain.team;

import site.meta.finalkbo.web.dto.request.TeamInsertDto;
import site.meta.finalkbo.web.dto.response.TeamViewDto;

import java.util.List;

public interface TeamDao {
    public void insert(TeamInsertDto teamInsertDto);
    public List<TeamViewDto> findAllView();
    public void findById(Integer id);
    public void deleteById(Integer id);
    public void update();
}
