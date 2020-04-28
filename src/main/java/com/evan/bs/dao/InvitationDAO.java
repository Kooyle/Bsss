package com.evan.bs.dao;

import com.evan.bs.pojo.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvitationDAO extends JpaRepository<Invitation,Integer> {

    Invitation findByUidAndCid(Integer uid,Integer cid);

    @Query(nativeQuery = true,value = "select u.uid,u.username,u.name,u.sex,u.date1,u.email,u.phone,u.education," +
            "u.school,u.natureofwork,u.salary,u.experience,u.credentials,u.adress,u.advantage,u.workexp1,u.workexp2,u.workexp3," +
            "n.nid,n.rid,n.cid,n.invitestate,n.invitemsg from invitation n, usermsg u  where n.uid = u.uid and cid=(:cid)")
    List<ShowinvitationDAO> findAllByCid(@Param("cid") int cid);

    @Query(nativeQuery = true,value = "select u.uid,u.username,u.name,u.sex,u.date1,u.email,u.phone,u.education, u.school,u.natureofwork,u.salary,u.experience,u.credentials,u.adress,u.advantage,u.workexp1,u.workexp2,u.workexp3," +
            "n.nid,n.rid,n.cid,n.invitestate,n.invitemsg,n.inviteresult," +
            "r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire " +
            "from invitation n, usermsg u,releaseInformation r " +
            "where n.uid = u.uid and n.rid = r.rid and n.invitestate like '已发送邀请' and n.cid=(:cid)")
    List<ShowinvitationDAO> findresultByCid(@Param("cid") int cid);


    @Query(nativeQuery = true,value="select c.cid,c.comname,c.comdate,c.comemail,c.comphone,c.finance,c.industry,c.scale,c.comadress,c.introduction," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire," +
            "n.nid,n.invitestate,n.invitemsg,n.inviteresult  " +
            "from invitation n,releaseInformation r ,comusermsg c " +
            "where n.rid=r.rid and n.cid=c.cid and n.invitestate like '已发送邀请' and uid=(:uid)")
    List<ShowinvitationDAO> findloadinvitetByUid(@Param("uid") int uid);

    List<Invitation> findAllByCidAndAndInvitestate(int cid,String invitestate);

    Invitation findByNid(int nid);

    Invitation findByNidAndInviteresult(int nid,String inviteresult);
}
