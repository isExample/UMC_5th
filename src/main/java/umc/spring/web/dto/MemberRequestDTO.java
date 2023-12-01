package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        String name;
        int gender;
        String birth;
        String address;
        List<Long> preferList;
    }
}
