package com.evan.bs.service;

import com.evan.bs.dao.ComusermsgDAO;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComusermsgService {

    @Autowired
    ComusermsgDAO comusermsgDAO;


    public Result comaddorupdate(Comusermsg comusermsg){
        Comusermsg oldusermsg = comusermsgDAO.findByUsername(comusermsg.getUsername());
        if (oldusermsg != null){
            comusermsg.setCid(oldusermsg.getCid());
        }
        comusermsgDAO.save(comusermsg);

        return ResultFactory.buildSuccessResult(comusermsg);
    }

    public List<Comusermsg> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return comusermsgDAO.findAll(sort);
    }

    public Comusermsg Search(String keywords) {
        return comusermsgDAO.findByUsername(keywords);
    }

    public List<Comusermsg> loadcompany(){

        return comusermsgDAO.findAll();
    }
    public Comusermsg searchcid(Comusermsg comusermsg){

        return comusermsgDAO.findByCid(comusermsg.getCid());
    }

    public Result editcompany(Comusermsg comusermsg){

        comusermsgDAO.save(comusermsg);
        return ResultFactory.buildSuccessResult(comusermsg);
    }

    public Result delectcid(Comusermsg comusermsg){

        comusermsgDAO.deleteAllByCid(comusermsg.getCid());

        return ResultFactory.buildSuccessResult(comusermsg);
    }

}
