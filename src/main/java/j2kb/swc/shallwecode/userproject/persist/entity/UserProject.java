package j2kb.swc.shallwecode.userproject.persist.entity;

import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.user.persist.entity.User;

import javax.persistence.*;

@Entity
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userproject_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
