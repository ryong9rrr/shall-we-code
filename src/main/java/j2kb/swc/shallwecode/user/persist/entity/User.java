package j2kb.swc.shallwecode.user.persist.entity;

import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class User {

    public User() {}

    @Builder
    public User(String email, String phoneNumber, String nickName, String skills, String password) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.skills = skills;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String phoneNumber;

    @Column(name = "nickname")
    private String nickName;

    private String skills;

    private String password;

    @OneToMany(mappedBy = "friend")
    private List<UserRelationship> friends;

    @OneToMany(mappedBy = "project")
    private List<UserProject> projects;

    private LocalDateTime created;

    private LocalDateTime modified;


}
