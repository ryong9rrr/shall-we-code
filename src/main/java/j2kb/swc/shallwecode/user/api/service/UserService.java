package j2kb.swc.shallwecode.user.api.service;

import j2kb.swc.shallwecode.user.api.controller.dto.request.UserCreateRequest;
import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.converter.UserConverter;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.user.persist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter converter;

    @Transactional
    public UserModel createUser(UserCreateRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .nickName(request.getNickname())
                .build();

        User saved = userRepository.save(user);
        return converter.convertToUserModel(saved);
    }
}
