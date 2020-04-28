package com.evan.bs.dao;

import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.pojo.Usermsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ComusermsgDAO extends JpaRepository<Comusermsg,Integer>  {

    Comusermsg findByUsername(String username);

    Comusermsg findByCid(Integer Cid);

    List<Comusermsg> findAll();

    @Query(nativeQuery = true,value = "delete from comusermsg where cid=(:cid)")
    @Modifying
    @Transactional
    void deleteAllByCid(@Param("cid") int cid);

}

