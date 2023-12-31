package com.dating.model.account;
import com.dating.model.Role;
import com.dating.model.comment.Comments;
import com.dating.model.gender.Gender;
import com.dating.model.hobby_detail.HobbyDetail;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.model.message.MessageStatus;
import com.dating.model.message.Messages;
import com.dating.model.post.LikeDetail;
import com.dating.model.post.Post;
import com.dating.model.relationship.Relationships;
import com.dating.model.update_account.PackageDetail;
import com.dating.model.warning_detail.WarningDetails;

import com.dating.model.gift.GiftRecord;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.model.message.MessageStatus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "accounts")



public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;
    @Column(name = "user_name",columnDefinition = "varchar(255)",unique = true)
    private String userName;
    @Column(name = "password",columnDefinition = "varchar(255)")
    private String password;
    @Column(name = "birthday",columnDefinition = "date")
    private String birthday;
    @Column(name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "phone_number",columnDefinition = "varchar(15)")
    private String phoneNumber;
    @Column(name = "money",columnDefinition = "double")
    private Double money;
    @Column(name = "regis_date",columnDefinition = "date")
    private String regisDate;
    @Column(name = "avatar",columnDefinition = "varchar(255)")
    private String avatar;
    @Column(name = "expire",columnDefinition = "date")
    private String expire;
    @Column(name = "marital_status",columnDefinition = "varchar(255)")
    private String maritalStatus;
    @Column(name = "point",columnDefinition = "int")
    private Integer point;
    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "gender_id",referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "message_status_id",referencedColumnName = "id")
    private MessageStatus messageStatus;


    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<WarningDetails> warningDetailsSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<HobbyDetail> hobbyDetailSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<PackageDetail> packageDetailSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<Comments> commentsSet;

    @OneToMany(mappedBy = "senderAccount")
    @JsonBackReference
    private Set<Messages> messagesSenderSet;


    @OneToMany(mappedBy = "receiverAccount")
    @JsonBackReference
    private Set<Messages> messagesReceiverSet;


    @OneToMany(mappedBy="account")
    @JsonBackReference
    private Set<Post>posts;

    @OneToMany(mappedBy="account")
    @JsonBackReference
    private Set<LikeDetail>likeDetails;


    @JsonBackReference
    @OneToMany(mappedBy = "accountSender")
    private Set<GiftRecord> giftRecords;
 
    @JsonBackReference
    @OneToMany(mappedBy = "accountReceiver")
    private Set<GiftRecord> giftRecord;

    @Transient
    private List<Integer> hobbies;
//a
}
