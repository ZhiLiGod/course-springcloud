package com.user.service.api.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_course")
@EntityListeners(AuditingEntityListener.class)
public class UserCourse implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Basic
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Basic
  @Column(name = "course_id", nullable = false)
  private Long courseId;

  @Basic
  @CreatedDate
  @Column(name = "create_time", nullable = false)
  private LocalDateTime createTime;

  @Basic
  @LastModifiedDate
  @Column(name = "update_time", nullable = false)
  private LocalDateTime updateTime;

}
