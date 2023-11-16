package com.dating.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
