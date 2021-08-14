package j2kb.swc.shallwecode.user.api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserModel {

    private String email;
    private String nickname;
    private String phoneNumber;

}
