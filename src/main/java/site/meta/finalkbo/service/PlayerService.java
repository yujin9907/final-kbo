package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.meta.finalkbo.domain.expulsion.Expulsion;
import site.meta.finalkbo.domain.expulsion.ExpulsionDao;
import site.meta.finalkbo.domain.player.Player;
import site.meta.finalkbo.domain.player.PlayersDao;
import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.domain.team.TeamDao;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;
import site.meta.finalkbo.web.dto.response.PositionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PlayerService {
    private final TeamDao teamDao;
    private final PlayersDao playersDao;
    private final ExpulsionDao expulsionDao;



    public List<Map<String, Object>> 포지션별목록보기(){
        List<Team> team1 = teamDao.findAllView();
        return playersDao.findPositionByTeam(team1);
    }



    public void 선수삭제(Integer id){
        playersDao.deleteById(id);
    }
    public void 선수업데이트(Integer id, Player player){
        playersDao.update(id, player);
    }
    public Player 선수한건보기(Integer id){
        return playersDao.findById(id);
    }
    public List<PlayerViewDto> 선수목록보기(){
        return playersDao.findAll();
    };
    public void 선수등록(Player player){
        playersDao.insert(player);
    }

    public List<PlayerViewDto> 구단별목록보기(Integer teamId){
        return playersDao.playerTeamExplusion(teamId);
    }
    // t-p-e 조인으로 dto를 한번에 가져오려 했으나, 그러면 p 목록이 다 나오지 않ㅇㅁ
    // 그래서 dto에 p 목록을 받아오고 e-reason을 넣기 위한 로직 구성
    public Expulsion 퇴출사유보기(Integer playerId){
        // 그러면, plaerview를 합치면 되지 않냐
        return expulsionDao.findByPlayerId(playerId);
    }
    public void 퇴출등록(Expulsion expulsion){
        playersDao.deleteByTeamId(expulsion.getPlayerId());
        expulsionDao.insert(expulsion);
    }
    public List<Expulsion> 퇴출보기(){
        return expulsionDao.findAll();
    }

    public Map<String, List<PlayerViewDto>> 구단별선수목록보기2(){
        List<PlayerViewDto> playerPS = playersDao.findAll();

        List<PlayerViewDto> dusanList = new ArrayList<>();
        List<PlayerViewDto> NCList = new ArrayList<>();
        List<PlayerViewDto> lotteList = new ArrayList<>();

        for(PlayerViewDto player : playerPS) {
            if(player.getTeamId()==1){
                dusanList.add(player);
            } else if (player.getTeamId()==2){
                NCList.add(player);
            } else {
                lotteList.add(player);
            }
        }
        Map<String, List<PlayerViewDto>> result = new HashMap<>();
        result.put("dusan", dusanList);
        result.put("ns", NCList);
        result.put("lotte", lotteList);

        return result;
    }
}
