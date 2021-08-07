package j2kb.swc.shallwecode.project.api.service;


import j2kb.swc.shallwecode.project.api.controller.dto.ProjectDto;
import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.project.persist.repository.ProjectRepository;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.user.persist.repository.UserRepository;
import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import j2kb.swc.shallwecode.userproject.persist.repository.UserProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserProjectRepository userProjectRepository;


    @Transactional
    public Project createProjectService(ProjectDto projectDto, Long userId){
        User userEntity = userRepository.findById(userId).orElseThrow(()->
            new IllegalArgumentException("User의 조회에 실패했습니다.")
        );
        Project project = Project.builder()
                .title(projectDto.getTitle())
                .content(projectDto.getContent())
                .founder(userEntity)
                .build();
        Project projectEntity = projectRepository.save(project);

        UserProject userProjectEntity = UserProject.builder()
                .user(userEntity)
                .project(projectEntity)
                .build();
        userProjectRepository.save(userProjectEntity);

        return projectEntity;
    }

    @Transactional
    public void deleteProjectService(Long projectId) {
        userProjectRepository.deleteAllByProject_Id(projectId);
        projectRepository.deleteById(projectId);
    }
}
