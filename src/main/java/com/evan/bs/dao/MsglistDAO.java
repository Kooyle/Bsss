package com.evan.bs.dao;

import com.evan.bs.pojo.Msglist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsglistDAO extends JpaRepository<Msglist,Integer> {


    Msglist findByMid(Integer mid);

    List<Msglist> findAll();



}
