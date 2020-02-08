package com.user.service.api.service;

import com.alibaba.fastjson.JSON;
import com.course.common.UserInfo;
import com.user.service.api.Application;
import com.user.service.api.dto.CreateUserRequest;
import com.user.service.api.entity.UserCourse;
import com.user.service.api.repository.UserCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Autowired
  private UserCourseRepository userCourseRepository;

  @Test
  @Ignore
  public void testCreateUser() {
    CreateUserRequest request = new CreateUserRequest();
    request.setEmail("test@test.com");
    request.setUsername("Test User 1");

    UserInfo user = userService.createUser(request);
    log.info(JSON.toJSONString(user));
  }

  @Test
  public void tesGetUserInfo() {
    UserInfo userInfo = userService.getUserInfo(6L);
    log.info(JSON.toJSONString(userInfo));
  }

  @Test
  @Ignore
  public void testCreateUserCourse() {
    UserCourse course1 = new UserCourse();
    course1.setCourseId(6L);
    course1.setUserId(6L);

    UserCourse course2 = new UserCourse();
    course2.setCourseId(7L);
    course2.setUserId(6L);

    userCourseRepository.saveAll(Arrays.asList(course1, course2));
  }

}
