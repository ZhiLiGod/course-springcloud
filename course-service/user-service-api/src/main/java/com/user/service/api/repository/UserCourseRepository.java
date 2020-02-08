package com.user.service.api.repository;

import com.user.service.api.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

  List<UserCourse> findAllByUserId(Long userId);

}
