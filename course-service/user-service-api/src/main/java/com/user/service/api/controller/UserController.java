package com.user.service.api.controller;

import com.course.common.UserInfo;
import com.user.service.api.dto.CreateUserRequest;
import com.user.service.api.dto.UserCourseInfoDto;
import com.user.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  @ResponseStatus(value =  HttpStatus.OK)
  public UserInfo createUser(@RequestBody @Valid CreateUserRequest request) {
    return userService.createUser(request);
  }

  @GetMapping("/{id}")
  public UserInfo getUserInfo(@PathVariable final Long id) {
    return userService.getUserInfo(id);
  }

  @GetMapping("/{id}/course")
  public UserCourseInfoDto getUserCourseInfo(@PathVariable final Long id) {
    return userService.getUserCourseInfo(id);
  }

}
