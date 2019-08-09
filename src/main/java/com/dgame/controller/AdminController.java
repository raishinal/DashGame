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
import com.dgame.models.Upcoming;
import com.dgame.models.UserDetails;
import com.dgame.service.GameStatService;
import com.dgame.service.UpcomeService;
import com.dgame.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class AdminController {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime before= now.minusDays(21);
    String formattedDateTime = now.format(dtf);
    String formattedBefore = before.format(dtf);

    @Autowired
    private PasswordEncoder passwordEncoder;

     @Autowired
    private UserDetails user;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetails userDetails;
 
    @Autowired
    GameStatistics gameStatistics;

    @Autowired
    GameStatService gameStatService;
    
    @Autowired
    UpcomeService upcomeService;
    
    @Autowired
    Upcoming upcoming;
    
    
     @GetMapping("/Admin/Home")
    public ModelAndView adminHome(ModelAndView mv) {
        mv.setViewName("dashboard");
        return mv;
    }
  
    
    
    @GetMapping("/Admin/Register")
    public ModelAndView registerUser(ModelAndView mv) {

        mv.setViewName("register");

        return mv;
    }
    @GetMapping("/Admin/Statistics")
    public ModelAndView gameStatistics(ModelAndView mv) {
        mv.addObject("gs",gameStatService.findAllRunning());

        mv.setViewName("games");

        return mv;
    }
    @GetMapping("/Admin/Game/Delete/{id}")
    public ModelAndView deleteresult(@PathVariable int id, ModelAndView mv) {
        gameStatService.deleteRunning(id);
        mv.addObject("gs",gameStatService.findAllRunning());

        mv.setViewName("games");

        return mv;
    }
    
    @GetMapping("/Admin/Upcoming/Add")
    public ModelAndView addUpcoming(ModelAndView mv) {

        mv.setViewName("addupcoming");

        return mv;
    }
    @GetMapping("/Admin/Upcoming/Manage")
    public ModelAndView manageUpcoming(ModelAndView mv) {
        mv.addObject("uc",upcomeService.findAllUpcome());
        mv.setViewName("manageupcoming");

        return mv;
    }
    
      @RequestMapping(value = "/Admin/Upcoming/Save", method = RequestMethod.POST)
    public String addUpcomings(
            @RequestParam("name1") String name1,
            @RequestParam("name2") String name2,
            @RequestParam("start")String start
    ){
       upcoming.setName1(name1);
       upcoming.setName2(name2);
       upcoming.setStart(LocalDateTime.parse(start));
       if(upcomeService.addUpcomeGame(upcoming)){
            return "redirect:/Admin/Upcoming/Add?Success";
       }
       else{
            return "redirect:/Admin/Upcoming/Add?Failure";
       }
    }
    

    @RequestMapping(value = "/Admin/RegisterUser", method = RequestMethod.POST)
    public String registerUser(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword,
            @RequestParam("userType") String userType
    ) {

        // password
        if (password.equals(cpassword)) {
            userDetails.setPassword(passwordEncoder.encode(password));
        } else {
            return "redirect:/Admin/Register?PasswordMismatch";
        }
        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/Register?ImageUploadFailed";
            }
        } else {
            return "redirect:/Admin/Register?ImageNotSelected";
        }

        // other form data
        userDetails.setFirstname(fname);
        userDetails.setLastname(lname);
        userDetails.setActive(0);
        userDetails.setEmail(email);
        userDetails.setPhone(phone);
        userDetails.setDob(LocalDate.parse(dob));
        userDetails.setCountry(country);
        userDetails.setInterest(interest);
        userDetails.setAddress(address);
        userDetails.setStartdate(formattedDateTime);
        userDetails.setUserName(username);
        userDetails.setUserType(userType);

        if (!userService.saveUser(userDetails)) {
            return "redirect:/Admin/Register?UserRegistrationFailed";
        }

        return "redirect:/Admin/Register?Success";
    }
    
    
       @RequestMapping(value="/Admin/Upcoming/Delete/{id}", method=RequestMethod.GET)
   public String deleteProduct(@PathVariable("id") int id){

        if(upcomeService.deleteUpcoming(id)){
         return "redirect:/Admin/Upcoming/Manage?Delete success"; 

    }
        else{
            return "redirect:/Admin/Upcoming/Manage?DeleteFailed"; 
        }
      
   }
    
       @RequestMapping(value="/Admin/Upcoming/Edit/{id}", method=RequestMethod.GET)
   public ModelAndView editUpcoming(@PathVariable int id,ModelAndView mv){
        mv.addObject("uc", upcomeService.findUpcommingById(id));
        mv.setViewName("editupcome");
        return mv;
    }
   
   
    
    
      @RequestMapping(value="/Admin/Upcoming/Update", method=RequestMethod.POST)
    public ModelAndView updateUser(
            @RequestParam("id") int id,
            @RequestParam("name1") String name1,
            @RequestParam("name2") String name2,
            @RequestParam("start") String start,
            ModelAndView mv
            ){
        upcoming.setId(id);
        upcoming.setName1(name1);
        upcoming.setName2(name2);
        upcoming.setStart(LocalDateTime.parse(start));
       
        if(upcomeService.updateUpcoming(upcoming)){
       mv.addObject("success","success");
       }
        mv.addObject("uc",upcomeService.findAllUpcome());
       mv.setViewName("manageupcoming");
       return mv;
    }
    
}
