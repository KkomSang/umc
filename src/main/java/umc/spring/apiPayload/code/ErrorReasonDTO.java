package umc.spring.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorReasonDTO {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private Boolean isSuccess;
}
