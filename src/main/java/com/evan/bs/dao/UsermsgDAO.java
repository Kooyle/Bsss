package com.evan.bs.dao;

import com.evan.bs.pojo.Usermsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsermsgDAO extends JpaRepository<Usermsg,Integer> {

    @Query(nativeQuery = true,value="select u.uid,u.username,u.name,u.sex,u.date1,u.email,u.phone,u.education, u.school,u.natureofwork,u.salary,u.experience,u.credentials,u.adress,u.advantage,u.workexp1,u.workexp2,u.workexp3 " +
            "from usermsg u " +
            "where education like(:education) and natureofwork like (:natureofwork) and experience like (:experience) and salary like (:salary)")
    List<Usermsg> findAllByExperienceAndEducationAndSalaryAndNatureofwork(@Param("experience")String experience,@Param("education")String education,@Param("salary")String salary,@Param("natureofwork")String natureofwork);

    List<Usermsg> findAll();

    Usermsg findByUid(Integer Uid);

    Usermsg findByUsername(String username);

    @Query(nativeQuery = true,value = "delete from usermsg where uid=(:uid)")
    @Modifying
    @Transactional
    void deleteAllByUid(@Param("uid") int uid);


}
