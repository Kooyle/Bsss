package com.evan.bs.dao;

import com.evan.bs.pojo.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarouselDAO extends JpaRepository<Carousel,Integer> {

    Carousel findByPid(Integer pid);

    List<Carousel> findAll();

}
