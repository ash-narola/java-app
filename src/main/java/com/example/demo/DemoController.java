package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishal Kotecha
 */
@RestController
public class DemoController {

  private final DemoDao demoDao;

  @Autowired
  public DemoController(DemoDao demoDao) {
    this.demoDao = demoDao;
  }

 /* @RequestMapping(method = RequestMethod.GET, value = "/users")
  public String showRecords(Model model){
    model.addAttribute("users",demoDao.findAllUsers());
    return "index";
  }*/

  @GetMapping(value = "/users")
  public List<User> showRecords(){
    return demoDao.findAllUsers();
  }

}
