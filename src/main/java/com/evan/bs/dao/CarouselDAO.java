package com.evan.bs.dao;

import com.evan.bs.pojo.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarouselDAO extends JpaRepository<Carousel,Integer> {

    Carousel getByIdAndAndImgAndLinkAndTittle(Integer id,String img,String link,String tittle);
}
