package umc.spring.service.storeService;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStore(StoreRequestDTO.AddDto request);

    public Mission addMission(StoreRequestDTO.AddMissionDto request);
}
