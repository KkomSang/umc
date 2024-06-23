package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeResponseDto> MissionChallenge(@RequestBody @Valid
    MissionRequestDTO.ChallengeRequestDto request){
        MissionResponseDTO.ChallengeResponseDto responseDTO = missionCommandService.addChallengeMission(request);
        return ApiResponse.onSuccess(responseDTO);
    }
}
