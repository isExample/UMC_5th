package umc.spring.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddDto{
        String name;
        String address;
        Long regionId;
        Long storeCategoryId;
    }
}
