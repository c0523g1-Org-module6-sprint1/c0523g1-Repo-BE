package com.dating.dto.update_account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PackageDto {
    private int money;
    private LocalDate expire;
    private String name;
}
