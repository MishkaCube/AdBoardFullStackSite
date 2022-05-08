package com.solarlab.project.mapper;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsDto adsToAds(Advertisment entity);
    Advertisment adsUpdate(UpdateAds dto, Long id, String owner);
    Advertisment toAds(AdsCreateDto dto, String owner);

}
