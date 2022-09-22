package site.meta.finalkbo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.meta.finalkbo.service.StadiumService;
import site.meta.finalkbo.web.dto.request.InsertDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping("/stadium")
    public String list(Model model){
        model.addAttribute("stadium", stadiumService.경기장목록보기());
        return "stadium/stadiumList";
    }

    @GetMapping("/stadium/insertForm")
    public String insertForm(){
        return "stadium/stadiumSaveForm";
    }
    @PostMapping("/stadium")
    public @ResponseBody String insert(@RequestBody InsertDto insertDto){
        stadiumService.경기장등록(insertDto.getName());
        return "stadium/stadiumList";
    }
}
