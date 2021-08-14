package j2kb.swc.shallwecode.userproject.persist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.user.persist.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
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

    public UserProject() { }

    @Builder
    public UserProject(User user, Project project, LocalDateTime created) {
        this.user = user;
        this.project = project;
        this.created = created;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userproject_id")
    private Long id;


    @ManyToOne // 한명의 유저는 많은 UserProject 를 가질 수 있다.
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne // 한개의 project 는 많은 UserProject 를 가질 수 있다.
    @JoinColumn(name = "project_id")
    private Project project;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime udpated;
}
