package com.evan.bs.dao;

import com.evan.bs.pojo.Received;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceivedDAO extends JpaRepository<Received,Integer> {
    Received findAllByReid(int reid);
    Received findAllByRidAndUid(int rid,int uid);

    @Query(nativeQuery = true,value="select c.cid,c.comname,c.comdate,c.comemail,c.comphone,c.finance,c.industry,c.scale,c.comadress,c.introduction," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire," +
            "re.state,re.uid,re.result,re.msg,re.reid  from releaseInformation r ,comusermsg c,received re where re.rid=r.rid and re.cid=c.cid and uid=(:uid)")
    List<ShowreceivedDAO> findByUid(@Param("uid")int uid);

    @Query(nativeQuery = true,value="select c.cid,c.comname,c.comdate,c.comemail,c.comphone,c.finance,c.industry,c.scale,c.comadress,c.introduction," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire," +
            "re.state,re.uid,re.result,re.msg,re.reid,re.resultstate  from releaseInformation r ,comusermsg c,received re where re.rid=r.rid and re.cid=c.cid and re.state like '已投递' and uid=(:uid)")
    List<ShowreceivedDAO> findresultByUid(@Param("uid")int uid);

    @Query(nativeQuery = true,value="select u.username,u.name,u.sex,u.date1,u.email,u.phone,u.education, u.school,u.natureofwork,u.salary,u.experience,u.credentials,u.adress,u.advantage,u.workexp1,u.workexp2,u.workexp3," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire," +
            "re.state,re.uid,re.result,re.msg,re.reid,re.resultstate " +
            "from releaseInformation r ,usermsg u,received re " +
            "where re.rid=r.rid and re.uid=u.uid and re.state like '已投递'and re.cid=(:cid)")
    List<ShowinvitationDAO> findreciviedByCid(@Param("cid")int cid);

    Received findAllByReidAndState(int reid,String state);

    Received findAllByReidAndResultstate(int reid,String resultstate);

    void deleteAllByReid(int reid);

}
