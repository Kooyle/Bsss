package com.evan.bs.controller;



import com.evan.bs.pojo.Carousel;
import com.evan.bs.pojo.Msglist;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.CarouselService;
import com.evan.bs.service.MsglistService;
import com.evan.bs.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class IndexController {
@Autowired
CarouselService carouselService;

@Autowired
MsglistService msglistService;



    @RequestMapping("api/carousel")
    @ResponseBody
    public Result carousel(@RequestBody Carousel carousel) {

        return carouselService.pictueraddorupdate(carousel);
    }

    @RequestMapping("api/loadcarousel")
    @ResponseBody
    public Result carouselshow(){

        return ResultFactory.buildSuccessResult(carouselService.list());
    }

    // 对文件的操作，对接收到的文件重命名，但保留原始的格式
    @CrossOrigin
    @PostMapping("api/carousel/picture")
    @ResponseBody
    public String coversUpload(MultipartFile file) {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder,
                StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @RequestMapping("api/msglist")
    @ResponseBody
    public Result updatemsglist(@RequestBody Msglist msglist){

        return msglistService.msgaddorupdate(msglist);
    }


    @RequestMapping("api/loadmsglist")
    @ResponseBody
    public Result msglistshow(){

        return ResultFactory.buildSuccessResult(msglistService.list());
    }
}

