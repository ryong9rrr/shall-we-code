package j2kb.swc.shallwecode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
//    private List<User> friends;
//    private List<UserProject> finished_project;
//    private List<UserProject> running_project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<User> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<User> friends) {
//        this.friends = friends;
//    }
//
//    public List<UserProject> getFinished_project() {
//        return finished_project;
//    }
//
//    public void setFinished_project(List<UserProject> finished_project) {
//        this.finished_project = finished_project;
//    }
//
//    public List<UserProject> getRunning_project() {
//        return running_project;
//    }
//
//    public void setRunning_project(List<UserProject> running_project) {
//        this.running_project = running_project;
//    }
}
