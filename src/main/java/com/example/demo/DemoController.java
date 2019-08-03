package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishal Kotecha
 */
@RestController("/")
public class DemoController {

  @Autowired
  private DemoDao demoDao;

  @GetMapping
  public List<User> showRecords(){
    List<User> users = demoDao.findAllUsers();
    return users;
  }

}
