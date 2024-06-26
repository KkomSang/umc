package umc.spring.service.StoreService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewRequestDTO request);
    Mission createMission(Long storeId, StoreRequestDTO.MissionAddDTO request);
}
