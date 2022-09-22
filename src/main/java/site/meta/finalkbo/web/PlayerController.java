package site.meta.finalkbo.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.meta.finalkbo.service.PlayerService;
import site.meta.finalkbo.web.dto.request.ExclusionInsertDto;
import site.meta.finalkbo.web.dto.request.InsertDto;
import site.meta.finalkbo.web.dto.request.PlayerInsertDto;
import site.meta.finalkbo.web.dto.response.PlayerViewDto;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/player")
    public String playerview(Model model){
        model.addAttribute("players", playerService.선수목록보기());
        return "player/playerList";
    }

    @GetMapping("/playerInserform")
    public String insertForm(Model model){
        model.addAttribute("players", playerService.선수목록보기());
        return "player/playerSaveForm";
    }
    @PostMapping("/player")
    public @ResponseBody String insert(@RequestBody PlayerInsertDto playerInsertDto){
        System.out.println(playerInsertDto.getName());
        playerService.선수등록(playerInsertDto);
        return "redirect:/player";
    }

    @GetMapping("/position")
    public String position(Model model){
        model.addAttribute("position", playerService.포지션별보기());
        return "player/playerPosition";
    }

    @GetMapping("/explusion/{teamId}")
    public String explusion(@PathVariable Integer teamId, Model model){
        model.addAttribute("player", playerService.구단별목록보기(teamId));
        model.addAttribute("explusion", playerService.퇴출보기());
        return "player/explusion";
    }

    @GetMapping("/explusionForm")
    public String explusionForm(Model model){
        model.addAttribute("player", playerService.선수목록보기());
        return "player/explusionSaveForm";
    }
    @PostMapping("/exclusion")
    public String saveExplusion(@RequestBody ExclusionInsertDto exclusionInsertDto){
        playerService.퇴출등록(exclusionInsertDto);
        return "redirect:/explusion/1";
    }
}
