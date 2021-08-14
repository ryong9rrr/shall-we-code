package j2kb.swc.shallwecode.common.model.reponse;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {
    private HttpStatus httpStatus;
    private T result;

    public ApiResponse(T result) {
        this(HttpStatus.OK, result);
    }

    public ApiResponse(HttpStatus httpStatus, T result) {
        this.httpStatus = httpStatus;
        this.result = result;
    }
}
