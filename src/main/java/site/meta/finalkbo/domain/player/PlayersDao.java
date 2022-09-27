package site.meta.finalkbo.domain.player;

import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.web.dto.response.PositionDto;

import java.util.List;

public interface PlayersDao {
    public void insert(Player player);
    public List<Player> findAll();
    public Player findById(Integer id);
    public void deleteById(Integer id);
    public void update(Integer id, Player player);


    public List<PositionDto> positionView(List<Team> teams);
    public List<Player> findByTeamId(Integer teamId);
    public void deleteToTeam(Integer teamId);
}
