package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Transactional
    @Override
    public MissionResponseDTO.ChallengeResponseDto addChallengeMission(MissionRequestDTO.ChallengeRequestDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()->new RuntimeException("해당하는 멤버가 없습니다."));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(()->new RuntimeException("해당하는 미션이 없습니다."));
        MemberMission memberMission = MissionConverter.toMemberMission(member, mission);
        MemberMission savedMemberMission = memberMissionRepository.save(memberMission);
        return MissionConverter.toChallengeResponse(savedMemberMission);
    }
}
