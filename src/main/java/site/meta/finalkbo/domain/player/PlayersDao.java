package site.meta.finalkbo.domain.player;

import site.meta.finalkbo.web.dto.request.PlayerInsertDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;
import site.meta.finalkbo.web.dto.response.PositionDto;

import java.util.List;

public interface PlayersDao {
    public void insert(PlayerInsertDto playerInsertDto);
    public List<PlayerViewDto> findAll();
    public void findById(Integer id);
    public void deleteById(Integer id);
    public void update();


    public List<PositionDto> positionView();
    public List<PlayerViewDto> findByTeamId(Integer teamId);
}
