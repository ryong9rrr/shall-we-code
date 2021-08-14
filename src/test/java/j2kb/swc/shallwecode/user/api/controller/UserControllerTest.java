package j2kb.swc.shallwecode.user.api.controller;

import com.google.gson.Gson;
import j2kb.swc.shallwecode.user.api.controller.dto.request.UserCreateRequest;
import j2kb.swc.shallwecode.user.api.controller.dto.response.UserModel;
import j2kb.swc.shallwecode.user.api.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.TransactionScoped;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private Gson gson;

    @BeforeEach
    public void beforeEach() {
        gson = new Gson();
    }

    @Test
    public void createUser_기본성공테스트() throws Exception {
        //given
        UserCreateRequest request = UserCreateRequest.builder()
                .email("email")
                .nickname("nickname")
                .password("password")
                .phoneNumber("01012345678")
                .build();
        UserModel created = UserModel.builder()
                .email("email")
                .nickname("nickname")
                .phoneNumber("01012345678")
                .build();
        when(userService.createUser(any())).thenReturn(created);

        //when, then
        mockMvc.perform(
                post("/user")
                        .content(gson.toJson(request))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());

    }
}
