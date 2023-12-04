package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberResponseDTO.ChallengeDTO toChallengeDto(MemberMission memberMission){
        return MemberResponseDTO.ChallengeDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
