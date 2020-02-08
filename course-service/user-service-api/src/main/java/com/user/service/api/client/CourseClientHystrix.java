package com.user.service.api.client;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CourseClientHystrix {

  public CourseInfo getCourseInfo(Long id) {
    return CourseInfo.invalid();
  }

  public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
    return Collections.emptyList();
  }

}
