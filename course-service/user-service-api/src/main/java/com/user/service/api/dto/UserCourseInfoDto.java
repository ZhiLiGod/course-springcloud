package com.user.service.api.dto;

import com.course.common.CourseInfo;
import com.course.common.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCourseInfoDto {

  private UserInfo userInfo;
  private List<CourseInfo> courseInfos;

  public static UserCourseInfoDto invalid() {
    return new UserCourseInfoDto(UserInfo.invalid(), Collections.emptyList());
  }

}
