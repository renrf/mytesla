package com.ziroom.mytesla.business.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liumy  .
 * @time 2016/5/4　18:25
 * @email　 liumy46@ziroom.com
 */
@Controller
@RequestMapping("index")
public class indexController {

    @RequestMapping("index")
    public  String index(){
        return  "index/index";
    }

}
