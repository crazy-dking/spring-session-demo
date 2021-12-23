package com.cn.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangdakai
 * @Date: 2021/12/21
 */
@Controller
@RequestMapping(value = "/")
public class HelloController {
    @ResponseBody
    @RequestMapping(value = "/session")
    public Map<String, Object> getSession(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
        if(ObjectUtils.isEmpty(request.getSession().getAttribute("userName"))){
            request.getSession().setAttribute("userName", "glmapper");
        }else{
            System.out.println(request.getSession().getAttribute("userName"));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public String get(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("userName").toString());
        String userName = (String) request.getSession().getAttribute("userName");
        System.out.println(userName==null);
        return userName;
    }
}
