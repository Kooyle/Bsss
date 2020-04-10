package com.evan.bs.dao;

import com.evan.bs.pojo.Usermsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsermsgDAO extends JpaRepository<Usermsg,Integer> {

    Usermsg findById(int uid);
}
