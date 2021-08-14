package j2kb.swc.shallwecode.user.converter;

import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.persist.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserModel convertToUserModel(User user) {
        return UserModel.builder()
                .email(user.getEmail())
                .email(user.getEmail())
                .nickname(user.getNickName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}
