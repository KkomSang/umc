package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class ReviewRequestDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;

        String Body;
    }
}
