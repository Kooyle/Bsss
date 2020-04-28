package com.evan.bs.service;

import com.evan.bs.dao.ComusermsgDAO;
import com.evan.bs.dao.InvitationDAO;
import com.evan.bs.dao.ShowinvitationDAO;
import com.evan.bs.dao.UsermsgDAO;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.Invitation;
import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {
    @Autowired
    InvitationDAO invitationDAO;
    @Autowired
    ComusermsgDAO comusermsgDAO;
    @Autowired
    UsermsgDAO usermsgDAO;


    public Result invitation(String s, Invitation invitation) {

        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);

        if (invitationDAO.findByUidAndCid(invitation.getUid(), comusermsg.getCid()) != null) {
            String message = "该用户已在收藏内，请勿重复收藏！";
            return ResultFactory.buildFailResult(message);
        } else {
            invitation.setCid(comusermsg.getCid());
            invitationDAO.save(invitation);
            return ResultFactory.buildSuccessResult(invitation);
        }
    }

    public Result snedinvitation(String sh, Invitation invitation) {
        Comusermsg comusermsg = comusermsgDAO.findByUsername(sh);


        if (invitationDAO.findByUidAndCid(invitation.getUid(), comusermsg.getCid()) != null) {
            Invitation oldmsg = invitationDAO.findByUidAndCid(invitation.getUid(), comusermsg.getCid());
            invitation.setNid(oldmsg.getNid());
            invitation.setCid(comusermsg.getCid());
            invitationDAO.save(invitation);
            return ResultFactory.buildSuccessResult(invitation);
        } else {

            String message = "数据出错！！！";
            return ResultFactory.buildFailResult(message);
        }


    }

    public List<ShowinvitationDAO> showinvitation(String s) {
        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        Integer i = comusermsg.getCid();

        return invitationDAO.findAllByCid(i);
    }

    public List<ShowinvitationDAO> showinvitationresult(String s) {
        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        Integer i = comusermsg.getCid();

        return invitationDAO.findresultByCid(i);
    }

    public List<ShowinvitationDAO> loadinvite(String s) {
        Usermsg usermsg = usermsgDAO.findByUsername(s);
        Integer i = usermsg.getUid();

        return invitationDAO.findloadinvitetByUid(i);
    }

    public Result invitereply(String s,Invitation invitation) {
        Usermsg usermsg = usermsgDAO.findByUsername(s);


        if (invitationDAO.findByNidAndInviteresult(invitation.getNid(),"同意")!=null ||invitationDAO.findByNidAndInviteresult(invitation.getNid(),"拒绝")!=null ){
            String message = "您已回复，请勿重新回复！";
            return ResultFactory.buildFailResult(message);

        }
        else{
            invitation.setUid(usermsg.getUid());
            invitationDAO.save(invitation);
            return ResultFactory.buildSuccessResult(invitation);
        }


    }

    public Result delnid(Invitation invitation){
        invitationDAO.delete(invitation);
        return ResultFactory.buildSuccessResult(invitation);
    }
}
