package com.evan.bs.service;

import com.evan.bs.dao.CarouselDAO;
import com.evan.bs.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselService {
    @Autowired
    CarouselDAO carouselDAO;

    /*public List<Carousel> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return CarouselDAO.findAll(sort);
    }*/
}
