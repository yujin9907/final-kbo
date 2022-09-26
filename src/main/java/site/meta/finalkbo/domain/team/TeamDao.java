package site.meta.finalkbo.domain.team;

import site.meta.finalkbo.web.dto.response.TeamViewDto;

import java.util.List;

public interface TeamDao {
    public void insert(Team team);
    public List<TeamViewDto> findAllView();
    public Team findById(Integer id);
    public void deleteById(Integer id);
    public void update(Integer id, Team team);
}
