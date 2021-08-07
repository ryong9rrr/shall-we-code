package j2kb.swc.shallwecode.service;

import j2kb.swc.shallwecode.domain.User;
import j2kb.swc.shallwecode.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() {
        //given
        User user = new User();
        user.setEmail("spring@test.com");
        user.setPassword("test");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userRepository.findById(saveId).get();
        assertEquals(user.getEmail(), findUser.getEmail());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        User user1 = new User();
        user1.setEmail("spring@spring.com");

        User user2 = new User();
        user2.setEmail("spring@spring.com");

        //when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(user2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
