package com.evan.bs.controller;

import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShowmsgController {

    @Autowired
    ReleaseInformationService releaseInformationService;

    @Autowired
    UsermsgService usermsgService;

    @Autowired
    InvitationService invitationService;

    @Autowired
    ReceivedService receivedService;

    @RequestMapping("api/loadshowconpanymsg")
    @ResponseBody
    public Result loadshowconpanymsg(){

        return ResultFactory.buildSuccessResult(releaseInformationService.showmsg());
    }
    @RequestMapping("api/loadshowinvitation")
    @ResponseBody
    public Result loadshowinvitation(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(invitationService.showinvitation(s));
    }

    @RequestMapping("api/loadshowinvitationresult")
    @ResponseBody
    public Result loadshowinviteresult(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(invitationService.showinvitationresult(s));
    }


    @RequestMapping("api/loadshowusermsg")
    @ResponseBody
    public List<Usermsg> showmag() throws Exception {

        return usermsgService.showusermsg();

    }

    @RequestMapping("api/loadshowreceived")
    @ResponseBody
    public Result loadshowreceived(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(receivedService.showreceived(s));
    }

    @RequestMapping("api/loadareceivedmsg")
    @ResponseBody
    public Result loadreceivedmsg(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(receivedService.showreceivedmsg(s));
    }


    @RequestMapping("api/loadinvite")
    @ResponseBody
    public Result loadinvite(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(invitationService.loadinvite(s));
    }

    @RequestMapping("api/loadshowcomreceived")
    @ResponseBody
    public Result loadshowcomreceived(){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();
        return ResultFactory.buildSuccessResult(receivedService.comreceived(s));
    }


}
