package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.statusEnums.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.apiPayload.exception.handler.StoreCategoryHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.domain.StoreCategory;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreCategoryRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final StoreCategoryRepository storeCategoryRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDto request) {
        Store newStore = StoreConverter.toStore(request);
        newStore.setStoreCategory(storeCategoryRepository.findById(request.getStoreCategoryId())
                .orElseThrow(() -> new StoreCategoryHandler(ErrorStatus.STORE_CATEGORY_NOT_FOUND)));
        newStore.setRegion(regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)));
        return storeRepository.save(newStore);
    }

    @Override
    @Transactional
    public Mission addMission(StoreRequestDTO.AddMissionDto request){
        Mission newMission = StoreConverter.toStoreMission(request);

        newMission.setStore(storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)));

        return missionRepository.save(newMission);
    }
}