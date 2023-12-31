package com.example.dtos;

import com.example.models.User;
import com.example.utils.Constants;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {

    private String name;

    @NotBlank
    private String mobile;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public User to(){
        return User.builder()
                .name(this.name)
                .mobile(this.mobile)
                .email(this.email)
                .password(this.password)
                .authorities(Constants.USER_AUTHORITY)
                .build();
    }
}
