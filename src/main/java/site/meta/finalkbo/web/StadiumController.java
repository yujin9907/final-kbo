package site.meta.finalkbo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.meta.finalkbo.domain.stadium.Stadium;
import site.meta.finalkbo.service.StadiumService;
import site.meta.finalkbo.web.dto.request.InsertDto;
import site.meta.finalkbo.web.dto.response.CMRespDto;


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
    public @ResponseBody CMRespDto<?> insert(@RequestBody InsertDto insertDto){
        stadiumService.경기장등록(insertDto.getName());
        return new CMRespDto<>(1, "성공", null);
    }


    @DeleteMapping("/stadium/delete/{id}")
    public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
        stadiumService.경기장삭제(id);
        return new CMRespDto<>(1, "성공", null);
    }

    @GetMapping("/stadium/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("stadium", stadiumService.경기장하나보기(id));
        return "stadium/stadiumUpdateForm";
    }
    @PutMapping("/stadium/update/{id}")
    public @ResponseBody CMRespDto<?> update(@PathVariable Integer id, @RequestBody Stadium stadium){
        stadiumService.업데이트(id, stadium.getName());
        return new CMRespDto<>(1, "1", null);
    }

}
