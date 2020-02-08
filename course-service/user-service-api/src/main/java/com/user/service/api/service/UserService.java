package com.user.service.api.service;

import com.course.common.UserInfo;
import com.user.service.api.dto.CreateUserRequest;
import com.user.service.api.dto.UserCourseInfoDto;

public interface UserService {

  UserInfo createUser(CreateUserRequest request);

  UserInfo getUserInfo(Long id);

  UserCourseInfoDto getUserCourseInfo(Long id);

}
