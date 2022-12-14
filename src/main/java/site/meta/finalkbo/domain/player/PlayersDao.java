package site.meta.finalkbo.domain.player;

import org.apache.ibatis.annotations.Param;
import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;

import java.util.List;
import java.util.Map;

public interface PlayersDao {
    public void insert(Player player);
    public List<PlayerViewDto> findAll();
    public Player findById(Integer id);
    public void deleteById(Integer id);
    public void update(Integer id, Player player);



    public List<PlayerViewDto> playerTeamExplusion(Integer teamId);
    public void deleteByTeamId(Integer playerId);

    public List<Map<String, Object>> findPositionByTeam(List<Team> team);
}
