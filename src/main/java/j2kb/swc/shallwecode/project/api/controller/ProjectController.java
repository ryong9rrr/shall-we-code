package j2kb.swc.shallwecode.project.api.controller;


import j2kb.swc.shallwecode.common.model.reponse.ApiResponse;
import j2kb.swc.shallwecode.project.api.controller.dto.ProjectDto;
import j2kb.swc.shallwecode.project.api.service.ProjectService;
import j2kb.swc.shallwecode.project.persist.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/api/project/{userId}/post")
    public ApiResponse<?> createProjectApi(@PathVariable Long userId,
                                           @RequestBody ProjectDto projectDto){
        Project projectEntity = projectService.createProjectService(projectDto, userId);
        return new ApiResponse<>(HttpStatus.OK, projectEntity);
    }


    @DeleteMapping("/api/project/{projectId}/delete")
    public ApiResponse<?> deleteProjectApi(@PathVariable Long projectId){
        projectService.deleteProjectService(projectId);
        return new ApiResponse<>(HttpStatus.OK, "project를 삭제했습니다.");
    }
}
