package j2kb.swc.shallwecode.domain;

import java.util.List;

public class Project {
    private Long id;
    private String title;
    private User maker;
    private List<UserProject> participants;
    private String finished;
    private String content;
    private String required_skills;
    private int recommend_count;
}
