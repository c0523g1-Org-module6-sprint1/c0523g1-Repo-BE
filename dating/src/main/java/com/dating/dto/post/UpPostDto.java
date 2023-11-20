package com.dating.dto.post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpPostDto {
    private String content;
    private String image;
    private Integer privacyPostId;
    private Integer accountId;
}
