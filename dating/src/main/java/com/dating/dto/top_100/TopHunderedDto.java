package com.dating.dto.top_100;

import com.dating.model.update_account.AccountTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TopHunderedDto {
    private int id;
    private String name;
    private String avatar;
    private AccountTypes accountTypes;
    private double money;
}
