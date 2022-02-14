package com.ag.controller;

import com.ag.common.ResultInfo;
import com.ag.domain.EstateManager;
import com.ag.domain.Owner;
import com.ag.service.EstateManagerService;
import com.ag.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private EstateManagerService estateManagerService;

    @Resource
    private UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public ResultInfo login(@RequestParam("username") String loginName, @RequestParam("password") String password,HttpSession session  ) {
//        System.out.println(loginName);
//        System.out.println(password);
        EstateManager estateManager = estateManagerService.login(loginName, password);
        if (estateManager != null) {
            session.getServletContext().setAttribute("user",estateManager);
        }
//         System.out.println(flag);
        return new ResultInfo(estateManager == null ? false : true, "账号或密码错误");
    }


    @PostMapping("/user/findByUserName")
    @ResponseBody
    public EstateManager showLoginName(HttpSession session) {
        EstateManager estateManager = (EstateManager) session.getServletContext().getAttribute("user");
//        System.out.println(estateManager);
        return  estateManager;
    }


    @RequestMapping("/user/exit")
    public String exitName(HttpSession session,HttpServletRequest request) {
//        System.out.println(request.getSession());
        request.getSession().invalidate();
        return  "redirect:/login.html";
    }

    @PostMapping("/user/findByUserImg")
    @ResponseBody
    public Owner showLoginImg(HttpSession session) {
        EstateManager estateManager = (EstateManager) session.getServletContext().getAttribute("user");
        String name = estateManager.getName();
        Owner owner = userService.findByUserImg(name);
        return owner;
    }
    @PostMapping("/user/findByUserId")
    @ResponseBody
    public EstateManager showLoginID(HttpSession session) {
        EstateManager estateManager = (EstateManager) session.getServletContext().getAttribute("user");
            return estateManager;
    }
    @PostMapping("/user/findByCount")
    @ResponseBody
    public int findByCount() {
        return userService.findByCount(String.valueOf(1));
    }



}