package j2kb.swc.shallwecode.user.api.service;

import j2kb.swc.shallwecode.user.api.controller.dto.request.UserCreateRequest;
import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.converter.UserConverter;
import j2kb.swc.shallwecode.user.persist.entity.User;
import j2kb.swc.shallwecode.user.persist.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    @BeforeEach
    public void beforeEach() {
        userService = new UserService(userRepository, converter);
    }

    @Test
    public void createUser_기본성공테스트() {
        //given
        UserCreateRequest request = UserCreateRequest.builder()
                .email("email")
                .password("password")
                .phoneNumber("01012341234")
                .nickname("nickname")
                .build();

        User savedUser = User.builder()
                .email("email")
                .password("password")
                .phoneNumber("01012341234")
                .nickName("nickname")
                .build();
        when(userRepository.save(any())).thenReturn(savedUser);
        //when
        UserModel returnedAUser = userService.createUser(request);

        //then
        assertThat(returnedAUser.getEmail()).isEqualTo(request.getEmail());
        assertThat(returnedAUser.getNickname()).isEqualTo(request.getNickname());
        assertThat(returnedAUser.getPhoneNumber()).isEqualTo(request.getPhoneNumber());
    }
}
