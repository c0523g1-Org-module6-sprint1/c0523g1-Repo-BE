package com.dating.dto.GiftRecordDto;

import javax.validation.constraints.NotBlank;

public class PasswordDto {
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String newPassword;

    public PasswordDto() {
    }

    public PasswordDto(String userName, String password, String newPassword) {
        this.userName = userName;
        this.password = password;
        this.newPassword = newPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
