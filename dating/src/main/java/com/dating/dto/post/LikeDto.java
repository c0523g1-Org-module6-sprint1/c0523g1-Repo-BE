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
public class LikeDto {
    private Integer id;
    private Integer accountId;
    private Integer postId;
    private LocalDateTime date;
    private Boolean isDeleted;

    public LikeDto(Integer accountId, Integer postId) {
        this.accountId = accountId;
        this.postId = postId;
    }
}
