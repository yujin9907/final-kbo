package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.meta.finalkbo.domain.expulsion.Expulsion;
import site.meta.finalkbo.domain.expulsion.ExpulsionDao;
import site.meta.finalkbo.domain.player.PlayersDao;
import site.meta.finalkbo.web.dto.request.ExclusionInsertDto;
import site.meta.finalkbo.web.dto.request.PlayerInsertDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;
import site.meta.finalkbo.web.dto.response.PositionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PlayerService {
    private final PlayersDao playersDao;
    private final ExpulsionDao expulsionDao;

    public List<PlayerViewDto> 선수목록보기(){
        return playersDao.findAll();
    };
    public void 선수등록(PlayerInsertDto playerInsertDto){
        playersDao.insert(playerInsertDto);
    }
    public List<PositionDto> 포지션별보기(){
        return playersDao.positionView();
    }

    public List<PlayerViewDto> 구단별목록보기(Integer teamId){
        return playersDao.findByTeamId(teamId);
    }
    public void 퇴출등록(ExclusionInsertDto exclusionInsertDto){
        expulsionDao.insert(exclusionInsertDto);
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
