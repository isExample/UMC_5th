package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.M;
                break;
            case 2:
                gender = Gender.F;
                break;
            case 3:
                gender = Gender.N;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .birth(LocalDate.parse(request.getBirth()))
                .gender(gender)
                .name(request.getName())
                .preferList(new ArrayList<>())
                .build();
    }

}
