package com.evan.bs.controller;

import com.evan.bs.dao.ShowmagDAO;
import com.evan.bs.pojo.Companywork;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.ComusermsgService;
import com.evan.bs.service.ReleaseInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReleaseInformationController {

    @Autowired
    ReleaseInformationService releaseInformationService;

    @Autowired
    ComusermsgService comusermsgService;


    @RequestMapping("api/releaseInformation")
    @ResponseBody
    public Result add(@RequestBody ReleaseInformation releaseInformation) {

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();

        return releaseInformationService.releaseInformation(s,releaseInformation);

    }

    @RequestMapping("api/loadreleaseInformation")
    @ResponseBody
    public List<ReleaseInformation> add() throws Exception {

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = u.getUsername();


        return releaseInformationService.releaseInformationlist(s);

    }

    @RequestMapping("api/searchcompanymsg")
    @ResponseBody
    public Result searchcompanymsg(@RequestBody Companywork companywork){

        return ResultFactory.buildSuccessResult(releaseInformationService.searchcompanymsg(companywork));
    }

 /*   @RequestMapping("api/loadshowconpanymsg")
    @ResponseBody
    public List<ReleaseInformation> showmag() throws Exception {

        return releaseInformationService.showmsg();

    }*/


}
