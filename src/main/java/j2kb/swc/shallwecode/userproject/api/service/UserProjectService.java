package j2kb.swc.shallwecode.userproject.api.service;


import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.project.persist.repository.ProjectRepository;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.user.persist.repository.UserRepository;
import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import j2kb.swc.shallwecode.userproject.persist.repository.UserProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserProjectService {

    private final UserProjectRepository userProjectRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public void joinProjectService(Long userId, Long projectId){

        User userEntity = userRepository.findById(userId).orElseThrow(()-> {
            return  new IllegalArgumentException("User의 조회에 실패했습니다. - UserProjectService.class");
        });
        Project projectEntity = projectRepository.findById(projectId).orElseThrow(()->{
            return new IllegalArgumentException("project의 조회에 실패했습니다. - UserProjectService.class");
        });

        UserProject userProject = UserProject.builder()
                .user(userEntity)
                .project(projectEntity)
                .build();
//        System.out.println("======================================================================"+userProject);
        userProjectRepository.save(userProject);
//        System.out.println("======================================================================"+userProjectEntity);
    }

    @Transactional
    public void leaveProjectService(Long userId, Long projectId) {
        userProjectRepository.mdeleteJoinProject(userId, projectId);
    }

    @Transactional(readOnly = true)
    public List<String> joinedUserListService(Long projectId) {
        List<String> data = userProjectRepository.mselectJoinedUserList(projectId);
        data.forEach((user)->{
            System.out.println(user);
        });
        return data;
    }
}
