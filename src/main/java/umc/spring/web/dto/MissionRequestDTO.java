package umc.spring.web.dto;

import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class ChallengeRequestDto {
        Long memberId;
        Long missionId;

    }
}
