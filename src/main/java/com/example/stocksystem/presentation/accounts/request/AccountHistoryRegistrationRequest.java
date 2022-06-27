package com.example.stocksystem.presentation.accounts.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountHistoryRegistrationRequest {
    @NotBlank(message = "계좌번호를 입력해주세요.")
    @Length(max = 14)
    @ApiModelProperty(example = "1000-08")
    private String accountNo;

    @NotNull(message = "입출금 여부를 입력해주세요.")
    @ApiModelProperty(example = "Y")
    private boolean depositWithdrawalYn;

    @NotNull(message = "금액을 입력해주세요.")
    @ApiModelProperty(example = "10000")
    private Integer depositAmt;
}
