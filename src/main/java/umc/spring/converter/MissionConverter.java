package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConverter {
   public static MemberMission toMemberMission(Member member, Mission mission) {
      return MemberMission.builder()
              .member(member)
              .mission(mission)
              .status(MissionStatus.CHALLENGING)
              .build();
   }
   public static MissionResponseDTO.ChallengeResponseDto toChallengeResponse(MemberMission memberMission) {
      return MissionResponseDTO.ChallengeResponseDto.builder()
              .memberMissionId(memberMission.getId())
              .build();
   }
}
