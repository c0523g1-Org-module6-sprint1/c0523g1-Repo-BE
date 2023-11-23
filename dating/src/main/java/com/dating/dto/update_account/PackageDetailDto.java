package com.dating.dto.update_account;

import com.dating.model.account.Account;
import com.dating.model.update_account.AccountTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PackageDetailDto {
    private int account;
    private int accountTypes;
}
