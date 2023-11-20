package com.dating.model.comment;

import com.dating.model.account.Account;
import com.dating.model.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private String content;
    private boolean idDeleted;
    @ManyToOne
    private Account account;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
}
