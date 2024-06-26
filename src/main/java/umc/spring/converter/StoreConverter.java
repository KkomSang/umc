package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StoreConverter {
    private final StoreRepository storeRepository;
    public static StoreResponseDTO.ReviewResultDTO toReviewResponseDTO(Review review){
        return StoreResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

    public static Review toReview(StoreRequestDTO.ReviewRequestDTO review){
        return Review.builder()
                .body(review.getBody())
                .title(review.getTitle())
                .score(review.getScore())
                .build();
    }
    public static StoreResponseDTO.MissionAddResultDTO missionAddResultDTO(Mission mission) {
        return StoreResponseDTO.MissionAddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static Mission mission(StoreRequestDTO.MissionAddDTO request) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .deadline(mission.getDeadline())
                .reward(mission.getReward())
                .build();
    }
    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
