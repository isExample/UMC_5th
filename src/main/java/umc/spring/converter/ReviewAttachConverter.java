package umc.spring.converter;

import umc.spring.domain.ReviewAttach;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewAttachConverter {
    public static List<ReviewAttach> toReviewAttachList(List<String> attachNameList){
        return attachNameList.stream()
                .map(attachName ->
                        ReviewAttach.builder()
                                .name(attachName)
                                .build()
                ).collect(Collectors.toList());
    }
}
