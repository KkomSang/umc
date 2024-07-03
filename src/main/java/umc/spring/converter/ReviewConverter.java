package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;

public class ReviewConverter {
    public static ReviewImage toReviewImage(String pictureUrl, Review review) {
        return ReviewImage.builder()
                .review(review)
                .imageUrl(pictureUrl)
                .build();
    }
}
