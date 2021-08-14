package j2kb.swc.shallwecode.userproject.persist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.user.persist.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_project",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id", "project_id"}
                )
        }
)
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userproject_id")
    private Long id;


    @JsonIgnoreProperties({"participants", "projects"})
    @ManyToOne // 한명의 유저는 많은 UserProject 를 가질 수 있다.
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({"participants"})
    @ManyToOne // 한개의 project 는 많은 UserProject 를 가질 수 있다.
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDateTime created;

    @PrePersist
    public void creatDate(){
        this.created = LocalDateTime.now();
    }

    public UserProject(User user, Project project, LocalDateTime created) {
        this.user = user;
        this.project = project;
        this.created = created;
    }
}
