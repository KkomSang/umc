package umc.spring.apiPayload.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import umc.spring.apiPayload.code.status.Code;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FoodCategoryHandler extends RuntimeException {
    public FoodCategoryHandler(Code code) {
        super(code.getValue());
    }
}
