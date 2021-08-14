package j2kb.swc.shallwecode.user.api.controller;

import j2kb.swc.shallwecode.common.model.reponse.ApiResponse;
import j2kb.swc.shallwecode.user.api.controller.dto.request.UserCreateRequest;
import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ApiResponse<UserModel> createUser(@RequestBody UserCreateRequest request) {
        return new ApiResponse(userService.createUser(request));
    }
}
