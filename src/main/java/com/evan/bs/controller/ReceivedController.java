package com.evan.bs.controller;

import com.evan.bs.pojo.Invitation;
import com.evan.bs.pojo.Received;
import com.evan.bs.result.Result;
import com.evan.bs.service.ReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReceivedController {
    @Autowired
    ReceivedService receivedService;

    @RequestMapping("api/collectcompany")
    @ResponseBody
    public Result collectcompany(@RequestBody Received received) {
        //获取当前的用户的username
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();

        return receivedService.received(s,received);

    }

    @RequestMapping("api/deliver")
    @ResponseBody
    public Result deliver(@RequestBody Received received) {

        return receivedService.deliver(received);

    }

    @RequestMapping("api/aggordisreceived")
    @ResponseBody
    public Result aggordisreceived(@RequestBody Received received) {

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();

        return receivedService.aggordisreceived(s,received);

    }
    @RequestMapping("api/delreid")
    @ResponseBody
    public Result delreid(@RequestBody Received received) {


        return receivedService.delreid(received);

    }
}
