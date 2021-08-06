package j2kb.swc.shallwecode.userproject.api.controller;


import com.google.gson.Gson;
import j2kb.swc.shallwecode.common.model.reponse.ApiResponse;
import j2kb.swc.shallwecode.project.persist.entity.Project;
import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.userproject.api.service.UserProjectService;
import j2kb.swc.shallwecode.userproject.persist.entity.UserProject;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserProjectController {

    private final UserProjectService userProjectService;

    @PostMapping("/api/userproject/{userId}/post/{projectId}")
    public ApiResponse<?> joinProject(@PathVariable Long userId,
                                   @PathVariable Long projectId){

        userProjectService.joinProjectService(userId, projectId);
        return new ApiResponse<>(HttpStatus.OK, "프로젝트 ID: "+projectId+"에 참가되었습니다.");
    }

    @DeleteMapping("/api/userproject/{userId}/delete/{projectId}")
    public ApiResponse<?> leaveProject(@PathVariable Long userId,
                             @PathVariable Long projectId){
        userProjectService.leaveProjectService(userId, projectId);
        return new ApiResponse<>(HttpStatus.OK, "프로젝트 ID: "+projectId+"에 참가 취소을했습니다.");
    }

    @GetMapping("/api/userproject/joineduserlist/{projectId}")
    public ApiResponse<?> joinedUserList(@PathVariable Long projectId){
        List<String> data = userProjectService.joinedUserListService(projectId); // 이것이 에러가 난다.
        String json = new Gson().toJson(data);
        return new ApiResponse<>(HttpStatus.OK, json);
    }
}
