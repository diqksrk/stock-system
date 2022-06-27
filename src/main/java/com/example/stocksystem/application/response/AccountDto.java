/**
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Phoenix Co., Ltd.
 * Phoenix Co., Ltd., owns the intellectual property rights in and to this program.
 * <p>
 * (Copyright ⓒ 2019 Phoenix Co., Ltd. All Rights Reserved Confidential)
 */
package com.example.stocksystem.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountDto {
    private Integer id;

    private String accountNo;
}
