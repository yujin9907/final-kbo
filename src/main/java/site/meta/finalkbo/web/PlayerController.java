package site.meta.finalkbo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.meta.finalkbo.domain.expulsion.Expulsion;
import site.meta.finalkbo.domain.player.Player;
import site.meta.finalkbo.service.PlayerService;
import site.meta.finalkbo.service.TeamService;
import site.meta.finalkbo.web.dto.response.CMRespDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;


    @DeleteMapping("/player/delete/{id}")
    public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
        playerService.선수삭제(id);
        return new CMRespDto<>(1, "성공", null);
    }
    @PutMapping("/player/update/{id}")
    public @ResponseBody CMRespDto<?> update(@PathVariable Integer id, @RequestBody Player player){
        playerService.선수업데이트(id, player);
        return new CMRespDto<>(1, "1", null);
    }
    @GetMapping("/player/update/{id}")
    public String updateForm(Model model, @PathVariable Integer id){
        model.addAttribute("team", teamService.팀목록보기());
        model.addAttribute("player", playerService.선수한건보기(id));
        return "player/playerUpdateForm";
    }

    @GetMapping("/player")
    public String playerview(Model model){
        model.addAttribute("players", playerService.선수목록보기());
        return "player/playerList";
    }

    @GetMapping("/player/insert")
    public String insertForm(Model model){
        model.addAttribute("team", teamService.팀목록보기());
        return "player/playerSaveForm";
    }
    @PostMapping("/player")
    public @ResponseBody CMRespDto<?> insert(@RequestBody Player player){
        Player player1 = new Player(player.getName(), player.getTeamId(), player.getPosition());
        playerService.선수등록(player1);
        return new CMRespDto<>(1, "성공", null);
    }

    @GetMapping("/position")
    public String position(Model model){
        model.addAttribute("position", playerService.포지션별보기());
        return "player/playerPosition";
    }



    @GetMapping("/explusion")
    public String explusion(Model model){
        model.addAttribute("team", teamService.팀목록보기());
        return "player/explusion";
    }
    @GetMapping("/explusion/{teamId}")
    public @ResponseBody CMRespDto<?> explusionteam(@PathVariable Integer teamId){
        List<PlayerViewDto> player = playerService.구단별목록보기(teamId);
        return new CMRespDto<>(1, "1", player);
    }





    @GetMapping("/explusionForm")
    public String explusionForm(Model model){
        model.addAttribute("player", playerService.선수목록보기());
        model.addAttribute("reasons", playerService.퇴출보기());
        return "player/explusionSaveForm";
    }
    @PostMapping("/exclusion")
    public String saveExplusion(@RequestBody Expulsion expulsion){
        Expulsion expulsion1 = new Expulsion(expulsion.getId(), expulsion.getReason());
        playerService.퇴출등록(expulsion1);
        return "redirect:/explusion/1";
    }
}
