package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class StoreRequestDTO {
    @Setter // @ModelAttribute를 사용하려면 추가해줘야 함!!
    @Getter
    public static class ReviewRequestDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
        MultipartFile reviewPicture;
    }
    @Getter
    public static class MissionAddDTO{
        Integer reward;
        String missionSpec;
        LocalDate deadline;
    }
}
