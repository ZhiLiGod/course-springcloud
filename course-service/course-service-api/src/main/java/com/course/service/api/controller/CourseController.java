package com.course.service.api.controller;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;
import com.course.service.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping("/{id}")
  public CourseInfo getCourseInfo(@PathVariable final Long id) {
    return courseService.getCourseInfo(id);
  }

  @PostMapping("/courses")
  public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
    return courseService.getCourseInfos(request);
  }

}
