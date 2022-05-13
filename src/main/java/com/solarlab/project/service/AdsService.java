package com.solarlab.project.service;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisment;
import com.solarlab.project.exception.EditAdAccessDeniedException;
import com.solarlab.project.mapper.AdsMapper;
import com.solarlab.project.repository.AdsRepository;
import com.solarlab.project.users.UsersClientDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<AdsDto> getByTitle(String title) {
        return adsRepository.findByTitle(title).stream()
                .map(adsMapper::adsToAds).collect(Collectors.toList());
    }

    public AdsDto create(AdsCreateDto request) {
        Advertisment advertisement = adsMapper.toAds(request, getCurrentUsername());
        advertisement = adsRepository.save(advertisement);
        return adsMapper.adsToAds(advertisement);
    }

    public void deleteById(Long adId) {
        checkCurrentUserUpdatePermission(adId);
        adsRepository.deleteById(adId);
    }

    public AdsDto update(Long adId, UpdateAds request) {
        checkCurrentUserUpdatePermission(adId);
        Advertisment advertisment = adsMapper.adsUpdate(request, adId, getCurrentUsername());
        adsRepository.save(advertisment);
        return adsMapper.adsToAds(advertisment);
    }

    public AdsDto getById(Long adId) {
        return adsMapper.adsToAds(adsRepository.findById(adId).orElse(null));
    }


    private void checkCurrentUserUpdatePermission(Long adID) {
        UsersClientDto currentUser = getCurrentUser();

        Optional<Advertisment> optionalTask = adsRepository.findById(adID);
        if (optionalTask.isPresent() && !optionalTask.get().getOwner().equals(currentUser.getUsername()) && !currentUser.getRole().equals("ADMIN")) {
            throw new EditAdAccessDeniedException();
        }

    }

    private UsersClientDto getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getPrincipal().toString();
        String role = securityContext.getAuthentication().getAuthorities().stream().findAny().get().getAuthority();
        return new UsersClientDto(username, role);
    }

    private void checkEditAdPermission(Long adId) {
        adsRepository.findById(adId).ifPresent(ad -> {
            if (isCurrentUserAdmin() | !ad.getOwner().equals(getCurrentUsername()) && !isCurrentUserAdmin()) {
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
