package umc.spring.service.MissionService;

import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.ChallengeResponseDto addChallengeMission(MissionRequestDTO.ChallengeRequestDto request);
}