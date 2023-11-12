package com.dating.model.hobby_detail;

import com.dating.model.hobby.Hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "hobby_detail")
public class HobbyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "hobby_id",referencedColumnName = "id")
    private Hobby hobby;
}

