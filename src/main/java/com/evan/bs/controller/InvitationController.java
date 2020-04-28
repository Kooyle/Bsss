package com.evan.bs.controller;

import com.evan.bs.pojo.Invitation;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InvitationController {
    @Autowired
    InvitationService invitationService;

    @RequestMapping("api/collectperson")
    @ResponseBody
    public Result collectperson(@RequestBody Invitation invitation) {
        //获取当前的用户的username
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();

        return invitationService.invitation(s,invitation);

    }
    @RequestMapping("api/sendmsg")
    @ResponseBody
    public Result sendmsg(@RequestBody Invitation invitation) {
        //获取当前的用户的username
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String sh = u.getUsername();

        return invitationService.snedinvitation(sh,invitation);

    }

    @RequestMapping("api/invitereply")
    @ResponseBody
    public Result invitereply(@RequestBody Invitation invitation) {
        //获取当前的用户的username
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();


        return invitationService.invitereply(s,invitation);

    }

    @RequestMapping("api/delnid")
    @ResponseBody
    public Result delnid(@RequestBody Invitation invitation) {
        return invitationService.delnid(invitation);
    }
}
