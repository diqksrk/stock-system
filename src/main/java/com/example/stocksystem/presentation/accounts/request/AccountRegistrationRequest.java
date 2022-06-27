package com.example.stocksystem.presentation.accounts.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountRegistrationRequest {
    @NotNull(message = "유저 아이디를 입력해주세요.")
    @ApiModelProperty(example = "10")
    private Integer userId;

    @NotBlank(message = "계좌번호를 입력해주세요.")
    @Length(max = 14)
    @ApiModelProperty(example = "1000-08")
    private String accountNo;
}
