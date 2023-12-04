package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.AddDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toStoreMission(StoreRequestDTO.AddMissionDto request){
        return Mission.builder()
                .contents(request.getContents())
                .deadline(LocalDate.parse(request.getDeadline()))
                .reward(request.getReward())
                .build();
    }

    public static StoreResponseDTO.AddMissionDTO toAddMissionDTO(Mission mission){
        return StoreResponseDTO.AddMissionDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
