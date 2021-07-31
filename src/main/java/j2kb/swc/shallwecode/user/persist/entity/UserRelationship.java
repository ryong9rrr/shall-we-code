package j2kb.swc.shallwecode.user.persist.entity;

import javax.persistence.*;

@Entity
public class UserRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User friend;

}
