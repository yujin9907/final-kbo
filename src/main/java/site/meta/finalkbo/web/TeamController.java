package site.meta.finalkbo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.meta.finalkbo.domain.team.Team;
import site.meta.finalkbo.service.StadiumService;
import site.meta.finalkbo.service.TeamService;
import site.meta.finalkbo.web.dto.response.CMRespDto;
import site.meta.finalkbo.web.dto.response.TeamViewDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TeamController {

    private final TeamService teamService;
    private final StadiumService stadiumService;

    @GetMapping("/team")
    public String viewTeam(Model model){
        model.addAttribute("teams", teamService.팀목록보기());
        return "/team/teamList";
    }

    @GetMapping("/team/insert")
    public String viewInsertForm(Model model){
        List<TeamViewDto> teamPS = teamService.팀목록보기();
        model.addAttribute("stadium", stadiumService.경기장목록보기());
        return "team/teamSaveForm";
    }
    @PostMapping("/team")
    public @ResponseBody CMRespDto<?> insert(@RequestBody Team team){
        Team teaminsert = new Team(team.getStadiumId(), team.getName());
        teamService.팀등록(teaminsert);
        return new CMRespDto<>(1, "성공", null);
    }

    @GetMapping("/team/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("stadium", stadiumService.경기장목록보기());
        model.addAttribute("team", teamService.팀한건보기(id));
        return "team/teamUpdateForm";
    }
    @PutMapping("/team/update/{id}")
    public @ResponseBody CMRespDto<?> update(@PathVariable Integer id, @RequestBody Team team){
        teamService.팀수정(id, team);
        return new CMRespDto<>(1, "1", null);
    }
    @DeleteMapping("/team/delete/{id}")
    public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
        teamService.팀삭제(id);
        return new CMRespDto<>(1, "성공", null);
    }
}
