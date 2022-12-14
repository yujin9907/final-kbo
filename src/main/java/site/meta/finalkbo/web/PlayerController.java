package site.meta.finalkbo.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.meta.finalkbo.domain.expulsion.Expulsion;
import site.meta.finalkbo.domain.player.Player;
import site.meta.finalkbo.service.PlayerService;
import site.meta.finalkbo.service.TeamService;
import site.meta.finalkbo.web.dto.response.CMRespDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;


    @GetMapping("/position")
    public String position(Model model){
        model.addAttribute("position", playerService.포지션별목록보기());
        return "player/playerPosition";
    }


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
        playerService.선수등록(player);
        return new CMRespDto<>(1, "성공", null);
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
        playerService.퇴출등록(expulsion);
        return "redirect:/explusion/1";
    }
}
