package com.evan.bs.dao;

import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.pojo.showmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ReleaseInformationDAO extends JpaRepository<ReleaseInformation,Integer> {

    @Query(nativeQuery = true,value="select c.cid,c.comname,c.comdate,c.comemail,c.comphone,c.finance,c.industry,c.scale,c.comadress,c.introduction," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire  from releaseInformation r ,comusermsg c where r.cid=c.cid")
    List<ShowmagDAO> getshowmsg();

    @Query(nativeQuery = true,value="select c.cid,c.comname,c.comdate,c.comemail,c.comphone,c.finance,c.industry,c.scale,c.comadress,c.introduction," +
            "r.rid,r.createdate,r.job,r.comsalary,r.comexperience,r.comeducation,r.comnatureofwork,r.details,r.workrequire  " +
            "from releaseInformation r ,comusermsg c " +
            "where r.cid=c.cid and comexperience like(:comexperience) and comeducation like(:comeducation) and finance like(:finance) and scale like(:scale) and industry like(:industry) and comsalary like(:comsalary) and comnatureofwork like(:comnatureofwork)")
    List<ShowmagDAO> findAllByComexperienceAndComeducationAndFinanceAndScaleAndIndusteryAAndComsalaryAndComnatureofwork(@Param("comexperience")String comexperience,@Param("comeducation")String comeducation,@Param("finance")String finance,@Param("scale")String scale,@Param("industry")String industry,@Param("comsalary")String comsalary,@Param("comnatureofwork")String comnatureofwork);

    ReleaseInformation findAllByCid(Integer cid);

    List <ReleaseInformation> findAllByCid(int cid);
    ReleaseInformation findByRid(Integer rid);
}
