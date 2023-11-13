package com.dating.service.post;

import java.time.LocalDateTime;

public interface IPostService {
    void create (LocalDateTime date, String content, String image, Integer accountId,Integer privacyId);
}
