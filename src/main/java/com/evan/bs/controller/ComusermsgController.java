package com.evan.bs.controller;

import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.ComusermsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComusermsgController {

    @Autowired
    ComusermsgService comusermsgService;

    @CrossOrigin(allowCredentials ="true")
    @RequestMapping("api/company/comusermsg")
    @ResponseBody
    public Result add(@RequestBody Comusermsg comusermsg) {

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comusermsg.setUsername( u.getUsername());
        return comusermsgService.comaddorupdate(comusermsg);

    }
    @RequestMapping( value = "api/loadcomusermsg", method = RequestMethod.GET)
    @ResponseBody
    public Result loadcomusermsg() {

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String keywords = u.getUsername();
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(comusermsgService.list());
        } else {
            return ResultFactory.buildSuccessResult(comusermsgService.Search(keywords));
        }

    }

    @RequestMapping("api/loadcompany")
    @ResponseBody
    public Result loadcompany() {

        return ResultFactory.buildSuccessResult(comusermsgService.loadcompany());

    }

    @RequestMapping("api/searchcid")
    @ResponseBody
    public Result searchuid(@RequestBody Comusermsg comusermsg){

        return ResultFactory.buildSuccessResult(comusermsgService.searchcid(comusermsg));
    }

    @RequestMapping("api/editcompay")
    @ResponseBody
    public Result editcompay(@RequestBody Comusermsg comusermsg){

        return ResultFactory.buildSuccessResult(comusermsgService.editcompany(comusermsg));
    }

    @RequestMapping("api/delectcid")
    @ResponseBody
    public void delcid(@RequestBody Comusermsg comusermsg) throws Exception{


         comusermsgService.delectcid(comusermsg);
    }



/*
    @RequestMapping("api/loadshowconpanymsg")
    @ResponseBody
    public List<Comusermsg> showmsg() {


        return comusermsgService.show();

    }
*/
}
