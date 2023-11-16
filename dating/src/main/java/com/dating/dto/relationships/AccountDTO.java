package com.dating.dto.relationships;

import com.dating.model.Role;
import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.model.message.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String birthday;
    private String email;
    private String phoneNumber;
    private Double money;
    private String regisDate;
    private String avatar;
    private String expire;
    private String maritalStatus;
    private Integer point;
}
