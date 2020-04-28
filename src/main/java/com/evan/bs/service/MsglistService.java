package com.evan.bs.service;

import com.evan.bs.dao.MsglistDAO;
import com.evan.bs.pojo.Msglist;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsglistService {
    @Autowired
    MsglistDAO msglistDAO;

    public Result msgaddorupdate(Msglist msglist){


        Msglist msglist1 = msglistDAO.findByMid(msglist.getMid());
        if (msglist1 != null){
            msglist.setMid(msglist1.getMid());
        }

        msglistDAO.save(msglist);

        return ResultFactory.buildSuccessResult(msglist);
    }

    // 按照升序排列
    public List<Msglist> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "mid");
        return msglistDAO.findAll(sort);
    }
}
