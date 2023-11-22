package com.dating.dto.top_100;

import com.dating.model.update_account.AccountTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public interface TopHunderedDto {
    int getId();

    String getName();

    String getAvatar();

    String getAccountTypes();

    int getPoint();

    //     double getMoney();
    int getCountLike();
}
