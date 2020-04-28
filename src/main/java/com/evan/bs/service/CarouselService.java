package com.evan.bs.service;

import com.evan.bs.dao.CarouselDAO;
import com.evan.bs.pojo.Carousel;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselService {
    @Autowired
    CarouselDAO carouselDAO;

    public Result pictueraddorupdate(Carousel carousel){

        Carousel carousel1 = carouselDAO.findByPid(carousel.getPid());
        if (carousel1 != null){
            carousel.setPid(carousel1.getPid());
        }

        carouselDAO.save(carousel);

        return ResultFactory.buildSuccessResult(carousel);
    }

    public List<Carousel> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "pid");
        return carouselDAO.findAll(sort);
    }
}


