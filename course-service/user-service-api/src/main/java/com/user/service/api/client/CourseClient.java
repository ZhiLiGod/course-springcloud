package com.user.service.api.client;

import com.course.common.CourseInfo;
import com.course.common.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "eureka-client-course-service"
  , fallback = CourseClientHystrix.class)
public interface CourseClient {

  @RequestMapping(value = "/course-api/course/{id}",
      method = RequestMethod.GET)
  CourseInfo getCourseInfo(@PathVariable Long id);

  @RequestMapping(value = "/course-api/course/courses",
      method = RequestMethod.POST)
  List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);

}
