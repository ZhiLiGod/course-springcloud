package com.course.service.api.service;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;

import java.util.List;

public interface CourseService {

  CourseInfo getCourseInfo(Long id);

  List<CourseInfo> getCourseInfos(CourseInfosRequest request);

}
