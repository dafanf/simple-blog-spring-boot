package com.blog.simpleblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PostPageController {
    
    @RequestMapping("/page/index")
    public String getIndexPage() {
        return "index";
    }
    
}
