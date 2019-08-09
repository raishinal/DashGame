/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.controller;

import com.dgame.dao.GameStatDao;
import com.dgame.dao.RunGameDao;
import com.dgame.models.GameStatistics;
import com.dgame.models.RunningGame;
import com.dgame.service.GameStatService;
import com.dgame.service.RunGameService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class GameController {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime before = now.minusDays(21);
    String formattedDateTime = now.format(dtf);
    String formattedBefore = before.format(dtf);

    @Autowired
    RunGameService runGameService;
    @Autowired
    RunningGame runningGame;

    @Autowired
    GameStatistics gameStatistics;

    @Autowired
    GameStatService gameStatService;

    @GetMapping("/Admin/Start")
    public ModelAndView start(ModelAndView mv) {
        mv.setViewName("start");
        return mv;
    }

    @RequestMapping(value = "/Admin/Start", method = RequestMethod.POST)
    public ModelAndView startGame(ModelAndView mv,
            @RequestParam("player1") String player1,
            @RequestParam("player2") String plaer2,
            @RequestParam("board") int board
    ) {
        runningGame.setId(board);
        runningGame.setName1(player1);
        runningGame.setName2(plaer2);
        runningGame.setTime(formattedDateTime);
        runningGame.setPoints1(0);
        runningGame.setPoints2(0);
        if (runGameService.updateRunning(runningGame)) {
            RunningGame rg = runGameService.findRunningById(board);
            mv.addObject("rg", rg);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/{id}", method = RequestMethod.POST)
    public ModelAndView liveGame(
            @PathVariable int id,
            ModelAndView mv,
            @RequestParam("player1") String player1,
            @RequestParam("player2") String plaer2,
            @RequestParam("break1") int break1,
            @RequestParam("break2") int break2,
            @RequestParam("score1") int score1,
            @RequestParam("score2") int score2
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(player1);
        runningGame.setName2(plaer2);
        runningGame.setPoints1(score1 + break1);
        runningGame.setPoints2(score2 + break2);
        runningGame.setTime(rg.getTime());
        if (runGameService.updateRunning(runningGame)) {

            mv.addObject("rg", runningGame);
        }

        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "red1", method = RequestMethod.POST)
    public ModelAndView redCue(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 1);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "yellow1", method = RequestMethod.POST)
    public ModelAndView yellow1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 2);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "green1", method = RequestMethod.POST)
    public ModelAndView green1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 3);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "orange1", method = RequestMethod.POST)
    public ModelAndView orange1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 4);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "blue1", method = RequestMethod.POST)
    public ModelAndView blue1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 5);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "pink1", method = RequestMethod.POST)
    public ModelAndView pink1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 6);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "black1", method = RequestMethod.POST)
    public ModelAndView black1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 7);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "forange1", method = RequestMethod.POST)
    public ModelAndView forange1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 4);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fblue1", method = RequestMethod.POST)
    public ModelAndView fblue1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 5);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fpink1", method = RequestMethod.POST)
    public ModelAndView fpink1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg =runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 6);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fblack1", method = RequestMethod.POST)
    public ModelAndView fblack1(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg =runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 7);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "red2", method = RequestMethod.POST)
    public ModelAndView red2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg =runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 1);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "yellow2", method = RequestMethod.POST)
    public ModelAndView yellow2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 2);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "green2", method = RequestMethod.POST)
    public ModelAndView green2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 3);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "orange2", method = RequestMethod.POST)
    public ModelAndView orange2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 4);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "blue2", method = RequestMethod.POST)
    public ModelAndView blue2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 5);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "pink2", method = RequestMethod.POST)
    public ModelAndView pink2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg =runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 6);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "black2", method = RequestMethod.POST)
    public ModelAndView black2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1());
        runningGame.setPoints2(rg.getPoints2() + 7);
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "forange2", method = RequestMethod.POST)
    public ModelAndView forange2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg =runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 4);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fblue2", method = RequestMethod.POST)
    public ModelAndView fblue2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 5);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fpink2", method = RequestMethod.POST)
    public ModelAndView fpink2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 6);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/Button/{id}", params = "fblack2", method = RequestMethod.POST)
    public ModelAndView fblack2(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        runningGame.setId(id);
        runningGame.setName1(rg.getName1());
        runningGame.setName2(rg.getName2());
        runningGame.setTime(rg.getTime());
        runningGame.setPoints1(rg.getPoints1() + 7);
        runningGame.setPoints2(rg.getPoints2());
        if (runGameService.updateRunning(runningGame)) {
            mv.addObject("rg", runningGame);
        }
        mv.setViewName("live");
        return mv;
    }

    @RequestMapping(value = "/Admin/Live/End/{id}", params = "end", method = RequestMethod.POST)
    public ModelAndView endGame(ModelAndView mv,
            @PathVariable int id
    ) {
        RunningGame rg = runGameService.findRunningById(id);
        gameStatistics.setName1(rg.getName1());
        gameStatistics.setName2(rg.getName2());
        gameStatistics.setScore1(rg.getPoints1());
        gameStatistics.setScore2(rg.getPoints2());
        gameStatistics.setEtime(formattedDateTime);
        gameStatistics.setStime(rg.getTime());

        if (gameStatService.addRunningGame(gameStatistics)) {
            runningGame.setId(id);
            runningGame.setName1("");
            runningGame.setName2("");
            runningGame.setTime("");
            runningGame.setPoints1(0);
            runningGame.setPoints2(0);
            if (runGameService.updateRunning(runningGame)) {

            }
        }

        mv.addObject("gs",gameStatService.findAllRunning());
        mv.setViewName("games");
        return mv;
    }
}
