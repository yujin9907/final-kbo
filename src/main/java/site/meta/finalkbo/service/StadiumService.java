package site.meta.finalkbo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.meta.finalkbo.domain.stadium.Stadium;
import site.meta.finalkbo.domain.stadium.StadiumDao;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumDao stadiumDao;

    public List<Stadium> 경기장목록보기(){
        return stadiumDao.findAll();
    }
    public void 경기장등록(String name){
        stadiumDao.insert(name);
    }
}
