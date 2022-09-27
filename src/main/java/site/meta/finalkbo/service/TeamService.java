package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.meta.finalkbo.domain.stadium.StadiumDao;
import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.domain.team.TeamDao;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamDao teamDao;
    private final StadiumDao stadiumDao;


    public void 팀삭제(Integer id){
        teamDao.deleteById(id);
    }
    public void 팀수정(Integer id, Team team){
        // 경기장 이름이랑 팀 이름 넘겨줌
        teamDao.update(id, team);
    }
    public Team 팀한건보기(Integer id){
        return teamDao.findById(id);
    }
    public List<Team> 팀목록보기(){
        return teamDao.findAllView();
    }
    public void 팀등록(Team team){
        teamDao.insert(team);
    }
}
