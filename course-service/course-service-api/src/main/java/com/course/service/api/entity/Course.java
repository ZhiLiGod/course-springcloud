package com.course.service.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course implements Serializable {

  public enum Type {
    FREE, PAID;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Basic
  @Column(name = "course_name", nullable = false)
  private String courseName;

  @Basic
  @Column(name = "course_type", nullable = false)
  private Integer courseType;

  @Basic
  @Column(name = "course_icon", nullable = false)
  private String courseIcon;

  @Basic
  @Column(name = "course_intro", nullable = false)
  private String courseIntro;

  @Basic
  @Column(name = "create_time", nullable = false)
  @CreatedDate
  private LocalDateTime createTime;

  @Basic
  @Column(name = "update_time", nullable = false)
  @LastModifiedDate
  private LocalDateTime updateTime;

  public static Course invalid() {
    // @formatter:off
    return Course.builder()
        .id(-1L)
        .build();
    // @formatter:on
  }

}
