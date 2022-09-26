package site.meta.finalkbo.domain.player;

import site.meta.finalkbo.web.dto.request.PlayerInsertDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;
import site.meta.finalkbo.web.dto.response.PositionDto;
import site.meta.finalkbo.web.dto.response.TeamViewDto;

import java.util.List;

public interface PlayersDao {
    public void insert(PlayerInsertDto playerInsertDto);
    public List<PlayerViewDto> findAll();
    public Player findById(Integer id);
    public void deleteById(Integer id);
    public void update(Integer id, Player player);


    public List<PositionDto> positionView(List<TeamViewDto> teams);
    public List<PlayerViewDto> findByTeamId(Integer teamId);
    public List<PlayerViewDto> playerTeamExplusion(Integer teamId);

}
