package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.meta.finalkbo.domain.stadium.Stadium;
import site.meta.finalkbo.domain.stadium.StadiumDao;
import site.meta.finalkbo.web.dto.request.InsertDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumDao stadiumDao;

    public List<Stadium> 경기장목록보기(){
        return stadiumDao.findAll();
    }
    public Stadium 경기장하나보기(Integer id) { return stadiumDao.findById(id);}
    public void 경기장등록(String name){
        stadiumDao.insert(name);
    }

    public void 업데이트(Integer id, String name){
        Stadium stadium = new Stadium(id,name);
        stadiumDao.update(stadium);
    }
    public void 경기장삭제(Integer id){
        stadiumDao.deleteById(id);
    }
}
