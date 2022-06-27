package com.example.stocksystem.presentation.users.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegistrationResquest {
    @NotBlank(message = "유저이름을 입력해주세요.")
    @Length(min = 3, max = 20)
    @ApiModelProperty(example = "강민준")
    private String name;

    @NotBlank(message = "핸드폰번호를 입력해주세요.")
    @Length(max = 11)
    @ApiModelProperty(example = "01025627727")
    private String handPhone;

    @NotBlank(message = "생년월일을 입력해주세요.")
    @Length(max = 8)
    @ApiModelProperty(example = "19921016")
    private String birth;

    @Length(max = 3, message = "올바른 나이를 입력해주세요.")
    @ApiModelProperty(example = "31")
    private String age;
}
