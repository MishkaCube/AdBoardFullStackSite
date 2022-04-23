package com.solarlab.project.controller;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisments;
import com.solarlab.project.service.AdsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "AdsController", description = "API контролера по работе с объявлениями")
public class AdsController {
    private final AdsService adsService;

    @Operation(description = "Получение списка объявлений")
    @GetMapping("api/get_ads")
    public ResponseEntity<Iterable<Advertisments>> getUser() {
        return ResponseEntity.ok(adsService.getAd());
    }

    @Operation(description = "Обновление объявления")
    @PutMapping(path = "api/insert_ads/{adsId}")
    public ResponseEntity<AdsDto> updateAd(
            @PathVariable("adId") Long adsId ,
            @RequestBody(required = false) UpdateAds request) {
        return ResponseEntity.ok(adsService.update(adsId, request));
    }

    @Operation(description = "Удаление объявления")
    @DeleteMapping( value = "api/deletead/{adsId}")
    public ResponseEntity<Void> deleteAd(@PathVariable("adsId") Long adId) {
        adsService.deleteById(adId);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Добавление объявления")
    @PostMapping(value = "api/addAdvert")
    public ResponseEntity<AdsDto> createAd(@RequestBody AdsCreateDto request) {
        return new ResponseEntity<>(adsService.create(request), HttpStatus.CREATED);
    }


}
