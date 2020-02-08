package com.user.service.api.service.impl;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;
import com.course.common.UserInfo;
import com.user.service.api.client.CourseClient;
import com.user.service.api.dto.CreateUserRequest;
import com.user.service.api.dto.UserCourseInfoDto;
import com.user.service.api.entity.User;
import com.user.service.api.entity.UserCourse;
import com.user.service.api.repository.UserCourseRepository;
import com.user.service.api.repository.UserRepository;
import com.user.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserCourseRepository userCourseRepository;

  @Autowired
  private CourseClient courseClient;

  @Override
  public UserInfo createUser(CreateUserRequest request) {
    User existUser = userRepository.findByUsername(request.getUsername());

    if (null != existUser) {
      return UserInfo.invalid();
    }

    // @formatter:off
    User newUser = userRepository.save(User.builder()
        .email(request.getEmail())
        .username(request.getUsername())
        .build());
    // @formatter:on

    return convertToUserInfo(newUser);
  }

  @Override
  public UserInfo getUserInfo(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? convertToUserInfo(user.get()) : UserInfo.invalid();
  }

  @Override
  public UserCourseInfoDto getUserCourseInfo(Long id) {
    Optional<User> user = userRepository.findById(id);

    if (!user.isPresent()) {
      return UserCourseInfoDto.invalid();
    }

    UserInfo userinfo = convertToUserInfo(user.get());
    List<UserCourse> userCourses = userCourseRepository
        .findAllByUserId(id);

    if (CollectionUtils.isEmpty(userCourses)) {
      // @formatter:off
      return UserCourseInfoDto.builder()
          .userInfo(userinfo)
          .courseInfos(Collections.emptyList())
          .build();
      // @formatter:on
    }

    CourseInfosRequest request = new CourseInfosRequest();
    request.setIds(userCourses.stream().map(UserCourse::getCourseId).collect(Collectors.toList()));
    List<CourseInfo> courseInfos = courseClient.getCourseInfos(request);

    // @formatter:off
    return UserCourseInfoDto.builder()
        .userInfo(userinfo)
        .courseInfos(courseInfos)
        .build();
    // @formatter:on
  }

  private UserInfo convertToUserInfo(User user) {
    UserInfo ui = new UserInfo();
    ui.setEmail(user.getEmail());
    ui.setUsername(user.getUsername());

    return ui;
  }

}
