package com.solarlab.project.mapper;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsDto adsToAds(Advertisments entity);
    Advertisments adsUpdate(UpdateAds dto, Long id);
    Advertisments toAds(AdsCreateDto dto);
}
