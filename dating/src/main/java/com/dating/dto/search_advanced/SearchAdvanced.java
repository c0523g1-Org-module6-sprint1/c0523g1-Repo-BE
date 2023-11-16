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
public class SearchAdvanced implements Validator {
    private int id;
    private String name;
    private String avatar;
    private String location;
    private String job;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SearchAdvanced searchAdvanced = (SearchAdvanced) target;
        if (searchAdvanced.getName() == "") {
            errors.rejectValue(name, "", "Không được để trống tên!");
        }
    }
}
