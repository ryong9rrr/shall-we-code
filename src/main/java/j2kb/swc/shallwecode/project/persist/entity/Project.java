package j2kb.swc.shallwecode.project.persist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String title;

    @JsonIgnoreProperties({"projects"})
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User founder;

//    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<UserProject> participants;

    @Column(name = "finished")
    private String isFinished;

    private String content;

    private String requiredSkills;

    private Long recommendedCount;

    private LocalDateTime created;

    private LocalDateTime modified;

    @PrePersist
    public void creatDate(){
        this.created = LocalDateTime.now();
    }

    public Project(String title, User founder, String isFinished, String content, String requiredSkills, Long recommendedCount, LocalDateTime created, LocalDateTime modified) {
        this.title = title;
        this.founder = founder;
        this.isFinished = isFinished;
        this.content = content;
        this.requiredSkills = requiredSkills;
        this.recommendedCount = recommendedCount;
        this.created = created;
        this.modified = modified;
    }
}
