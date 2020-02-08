package com.course.service.api.service;

import com.alibaba.fastjson.JSON;
import com.course.service.api.Application;
import com.course.service.api.entity.Course;
import com.course.service.api.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceTest {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseService courseService;

  @Test
  @Ignore
  public void testCreateCourseInfo() {
    Course course1 = new Course();
    course1.setCourseName("JDK 11");
    course1.setCourseType(Course.Type.FREE.ordinal());
    course1.setCourseIcon("icon 1");
    course1.setCourseIntro("Intro JDK 11");

    Course course2 = new Course();
    course2.setCourseName("MICRO SERVICES");
    course2.setCourseType(Course.Type.PAID.ordinal());
    course2.setCourseIcon("icon 2");
    course2.setCourseIntro("Intro MICROSERVICES");

    List<Course> result = courseRepository.saveAll(Arrays.asList(course1, course2));
    log.info("" + result.size());
  }

  @Test
  public void testGetById() {
    log.info(JSON.toJSONString(courseService.getCourseInfo(6L)));
  }

}
