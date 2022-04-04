package com.solarlab.project.controller;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisments;
import com.solarlab.project.service.AdsService;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
public class AdsController {
    private final AdsService adsService;

    @GetMapping("v3/api/get_ads")
    public ResponseEntity<Iterable<Advertisments>> getUser() {
        return ResponseEntity.ok(adsService.getAd());
    }

    @PutMapping(path = "v3/api/insert_ads/{adsId}")
    public ResponseEntity<AdsDto> updateAd(
            @PathVariable("adId") Long adsId ,
            @RequestBody(required = false) UpdateAds request) {
        return ResponseEntity.ok(adsService.update(adsId, request));
    }

    @DeleteMapping( value = "/v3/api/deletead/{adsId}")
    public ResponseEntity<Void> deleteAd(@PathVariable("adsId") Long adId) {
        adsService.deleteById(adId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v3/api/addAdvert")
    public ResponseEntity<AdsDto> createAd(@RequestBody AdsCreateDto request) {
        return new ResponseEntity<>(adsService.create(request), HttpStatus.CREATED);
    }


}
