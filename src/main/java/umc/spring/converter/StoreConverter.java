package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {
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
}
