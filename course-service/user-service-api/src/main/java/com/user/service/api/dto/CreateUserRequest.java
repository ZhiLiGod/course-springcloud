package com.user.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

  @NotEmpty(message = "Username cannot be empty")
  private String username;

  @NotEmpty(message = "Email cannot be empty")
  private String email;

}
