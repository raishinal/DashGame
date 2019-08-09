/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.controller;

import com.dgame.service.GameStatService;
import com.dgame.service.RunGameService;
import com.dgame.service.UpcomeService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class HomeController {

    @Autowired
    UpcomeService upcomeService;
    @Autowired
    GameStatService gameStatService;
    @Autowired
    RunGameService rungameService;

    @GetMapping("/Index")
    public ModelAndView showIndex(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/Lives")
    public ModelAndView showLives(ModelAndView mv) {
       mv.addObject("rg",rungameService.findAllRunning());
        mv.setViewName("lives");
        return mv;
    }

    @GetMapping("/Results")
    public ModelAndView showResults(ModelAndView mv) {
        mv.addObject("gs", gameStatService.findAllRunning());
        mv.setViewName("results");
        return mv;
    }

    @GetMapping("/Upcoming")
    public ModelAndView showUpcoming(ModelAndView mv) {
        mv.addObject("uc", upcomeService.findAllUpcome());
        mv.setViewName("upcomings");
        return mv;
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth1);
        if (auth1 != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth1);
        }
        return "redirect:/Index";
    }

}
