package com.course.service.api.service.impl;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;
import com.course.service.api.entity.Course;
import com.course.service.api.repository.CourseRepository;
import com.course.service.api.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public CourseInfo getCourseInfo(Long id) {
    Optional<Course> course = courseRepository.findById(id);
    return buildCourseInfo(course.orElse(Course.invalid()));
  }

  @Override
  public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
    if (CollectionUtils.isEmpty(request.getIds())) {
      return Collections.emptyList();
    }

    List<Course> courses = courseRepository.findAllById(request.getIds());

    // @formatter:off
    return courses.stream()
        .map(this::buildCourseInfo)
        .collect(Collectors.toList());
    // @formatter:on
  }

  private CourseInfo buildCourseInfo(Course course) {
    // @formatter:off
    return CourseInfo.builder()
        .id(course.getId())
        .courseName(course.getCourseName())
        .courseIcon(course.getCourseIcon())
        .courseType(course.getCourseType() == 0 ? Course.Type.FREE.name() : Course.Type.PAID.name())
        .courseIntro(course.getCourseIntro())
        .build();
    // @formatter:on
  }

}
