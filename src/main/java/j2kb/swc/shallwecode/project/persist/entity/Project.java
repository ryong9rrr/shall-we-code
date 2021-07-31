package j2kb.swc.shallwecode.project.persist.entity;

import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProject founder;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<UserProject> participants;

    @Column(name = "finished")
    private String isFinished;

    private String content;

    private String requiredSkills;

    private Long recommendedCount;

    private LocalDateTime created;

    private LocalDateTime modified;
}
