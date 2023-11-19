package com.dating.dto.search_advanced;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchAdvanced {

    private Integer id;
    private Integer birthdayFrom;
    private Integer birthdayEnd;
    private Integer gender;
    private String name;
    private String avatar;
    private Integer location;
    private Integer job;
    private Integer hobby;
}
