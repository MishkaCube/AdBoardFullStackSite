package com.solarlab.project.service;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisment;
import com.solarlab.project.exception.EditAdAccessDeniedException;
import com.solarlab.project.mapper.AdsMapper;
import com.solarlab.project.repository.AdsRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class AdsService {

    private final AdsRepository adsRepository;
    private final AdsMapper adsMapper;

    public Iterable<Advertisment> getAd() {
        return adsRepository.findAll();
    }

    public AdsDto create(AdsCreateDto request) {
        Advertisment advertisement = adsMapper.toAds(request, getCurrentUsername());
        advertisement = adsRepository.save(advertisement);
        return adsMapper.adsToAds(advertisement);
    }

    public void deleteById(Long adId) {
        adsRepository.deleteById(adId);
    }

    public AdsDto update(Long adId, UpdateAds request) {
        checkEditTaskPermission(adId);
        Advertisment advertisment = adsMapper.adsUpdate(request, adId, getCurrentUsername());
        adsRepository.save(advertisment);
        return adsMapper.adsToAds(advertisment);
    }


    private void checkEditTaskPermission(Long adId) {
        adsRepository.findById(adId).ifPresent(task -> {
            if (!task.getOwner().equals(getCurrentUsername()) && !isCurrentUserAdmin()) {
                throw new EditAdAccessDeniedException();
            }
        });
    }

    @SneakyThrows
    private String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    private List<String> getCurrentUserRole() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    private boolean isCurrentUserAdmin() {
        return getCurrentUserRole().contains("ADMIN");
    }



}
