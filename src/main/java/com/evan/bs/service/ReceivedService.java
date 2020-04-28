package com.evan.bs.service;

import com.evan.bs.dao.*;
import com.evan.bs.pojo.*;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceivedService {

    @Autowired
    ReceivedDAO receivedDAO;

    @Autowired
    UsermsgDAO usermsgDAO;

    @Autowired
    ComusermsgDAO comusermsgDAO;

    public Result received(String s, Received received){

        Usermsg usermsg = usermsgDAO.findByUsername(s);

        if(receivedDAO.findAllByRidAndUid(received.getRid(),usermsg.getUid())!=null){
            String message = "该岗位已收藏，请勿重复收藏！";
            return ResultFactory.buildFailResult(message);
        }
        else{
            received.setUid(usermsg.getUid());
            receivedDAO.save(received);
            return ResultFactory.buildSuccessResult(received);
        }
    }

    public List<ShowreceivedDAO> showreceived(String s){
        Usermsg usermsg = usermsgDAO.findByUsername(s);
        int i = usermsg.getUid();

        return receivedDAO.findByUid(i);
    }

    public Result deliver(Received received ){

        if (receivedDAO.findAllByReidAndState(received.getReid(),received.getState())!=null){
            String message = "您已经投递，请勿重复操作！";
            return ResultFactory.buildFailResult(message);
        }
        else{
            receivedDAO.save(received);

            return ResultFactory.buildSuccessResult(received);
        }


    }

    public List<ShowreceivedDAO> showreceivedmsg(String s){

        Usermsg usermsg = usermsgDAO.findByUsername(s);
        int i = usermsg.getUid();

        return receivedDAO.findresultByUid(i);
    }

    public List<ShowinvitationDAO> comreceived(String s){
        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        int i = comusermsg.getCid();

        return receivedDAO.findreciviedByCid(i);
    }

    public Result aggordisreceived(String s,Received received){
        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        if (receivedDAO.findAllByReidAndResultstate(received.getReid(),"已回复")!=null){
            String message = "请勿重复操作！";
            return ResultFactory.buildFailResult(message);
        }
        else{
            received.setCid(comusermsg.getCid());
            receivedDAO.save(received);
            return ResultFactory.buildSuccessResult(received);
        }
    }

    public Result delreid(Received received){
       receivedDAO.delete(received);
        String message = "已删除！";
       return ResultFactory.buildFailResult(message);
    }



}
