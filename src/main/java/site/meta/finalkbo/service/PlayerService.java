package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.meta.finalkbo.domain.expulsion.Expulsion;
import site.meta.finalkbo.domain.expulsion.ExpulsionDao;
import site.meta.finalkbo.domain.player.Player;
import site.meta.finalkbo.domain.player.PlayersDao;
import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.domain.team.TeamDao;
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



    public void 선수삭제(Integer id){
        playersDao.deleteById(id);
    }
    public void 선수업데이트(Integer id, Player player){
        playersDao.update(id, player);
    }
    public Player 선수한건보기(Integer id){
        return playersDao.findById(id);
    }
    public List<Player> 선수목록보기(){
        return playersDao.findAll();
    };
    public void 선수등록(Player player){
        playersDao.insert(player);
    }
    public List<PositionDto> 포지션별보기(){
        List<Team> teams = teamDao.findAllView();
        return playersDao.positionView(teams);
    }

    public List<Player> 구단별목록보기(Integer teamId){
        return playersDao.findByTeamId(teamId);
    }
    @Transactional
    public void 퇴출등록(Expulsion expulsion){
        playersDao.deleteToTeam(expulsion.getId());
        expulsionDao.insert(expulsion);
    }
    public List<Expulsion> 퇴출보기(){
        return expulsionDao.findAll();
    }



//    public Map<String, List<PlayerViewDto>> 구단별선수목록보기2(){
//        List<PlayerViewDto> playerPS = playersDao.findAll();
//
//        List<PlayerViewDto> dusanList = new ArrayList<>();
//        List<PlayerViewDto> NCList = new ArrayList<>();
//        List<PlayerViewDto> lotteList = new ArrayList<>();
//
//        for(PlayerViewDto player : playerPS) {
//            if(player.getTeamId()==1){
//                dusanList.add(player);
//            } else if (player.getTeamId()==2){
//                NCList.add(player);
//            } else {
//                lotteList.add(player);
//            }
//        }
//        Map<String, List<PlayerViewDto>> result = new HashMap<>();
//        result.put("dusan", dusanList);
//        result.put("ns", NCList);
//        result.put("lotte", lotteList);
//
//        return result;
//    }
}
