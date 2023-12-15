package umc.spring.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class WriteDto{
        Float score;
        String contents;
        Long memberId;
        Long storeId;
        List<String> attachList;
    }
}
