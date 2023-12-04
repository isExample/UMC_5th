package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.WriteDto request){
        return Review.builder()
                .score(request.getScore())
                .contents(request.getContents())
                .attachList(new ArrayList<>())
                .build();
    }

    public static ReviewResponseDTO.WriteResultDTO toWriteResultDTO(Review review){
        return ReviewResponseDTO.WriteResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
