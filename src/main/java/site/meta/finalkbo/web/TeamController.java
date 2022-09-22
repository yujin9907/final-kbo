package site.meta.finalkbo.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.meta.finalkbo.domain.team.TeamDao;
import site.meta.finalkbo.service.StadiumService;
import site.meta.finalkbo.service.TeamService;
import site.meta.finalkbo.web.dto.request.TeamInsertDto;
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

    @GetMapping("/teamInsertForm")
    public String viewInsertForm(Model model){
        List<TeamViewDto> teamPS = teamService.팀목록보기();
        model.addAttribute("stadium", stadiumService.경기장목록보기());
        return "team/teamSaveForm";
    }
    @PostMapping("/team")
    public @ResponseBody String insert(@RequestBody TeamInsertDto teamInsertDto){
        teamService.팀등록(teamInsertDto);
        return "redirect:/team";
    }
}
