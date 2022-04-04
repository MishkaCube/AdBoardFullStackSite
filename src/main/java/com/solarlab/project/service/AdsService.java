package com.solarlab.project.service;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisments;
import com.solarlab.project.mapper.AdsMapper;
import com.solarlab.project.repository.AdsRepository;
import com.solarlab.project.user.UsersUpdate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Data
public class AdsService {

    private final AdsRepository adsRepository;
    private final AdsMapper adsMapper;

    public AdsService(AdsRepository adsRepository, AdsMapper adsMapper) {
        this.adsRepository = adsRepository;
        this.adsMapper = adsMapper;
    }

    public Iterable<Advertisments> getAd() { return adsRepository.findAll(); }

    public AdsDto create(AdsCreateDto request) {
        Advertisments advertisement = adsMapper.toAds(request);
        adsRepository.save(advertisement);
        return adsMapper.adsToAds(advertisement);
    }

    public void deleteById(Long adsId) {
        adsRepository.deleteById(adsId);
    }

    public AdsDto update(Long userId, UpdateAds request) {
        Advertisments advertisments = adsMapper.adsUpdate(request, userId);
        adsRepository.save(advertisments);
        return adsMapper.adsToAds(advertisments);
    }

}
