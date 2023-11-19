package com.dating.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer id;
    private String content;
    private String image;
    private Boolean isDeleted;
    private Integer privacyPostId;
}
