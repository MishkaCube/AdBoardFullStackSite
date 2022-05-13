package com.solarlab.project.controller;

import com.solarlab.project.advertisments.AdsCreateDto;
import com.solarlab.project.advertisments.AdsDto;
import com.solarlab.project.advertisments.UpdateAds;
import com.solarlab.project.entity.Advertisment;
import com.solarlab.project.service.AdsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ads")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "AdsController", description = "API контролера по работе с объявлениями")
public class AdsController {

    private final AdsService adsService;

    @Operation(description = "Получение списка объявлений")
    @GetMapping()
    public ResponseEntity<Iterable<Advertisment>> getAd() {
        return ResponseEntity.ok(adsService.getAd());
    }

    @Operation(description = "Обновление объявления")
    @PutMapping(value = "{adId}",
            produces = {"application/json"}
    )
    public ResponseEntity<AdsDto> updateAd(
            @PathVariable("adId") Long adId ,
            @RequestBody() UpdateAds request) {
        return ResponseEntity.ok(adsService.update(adId, request));
    }

    @Operation(description = "Удаление объявления")
//    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "{adId}")
    public ResponseEntity<Void> deleteAd(@PathVariable("adId") Long adId) {
        adsService.deleteById(adId);
        return ResponseEntity.noContent().build();
    }

    @ApiIgnore
    @Operation(description = "Получение объявления")
    @GetMapping(
            value = "/v1/ads/{adsId}",
            produces = {"application/json"}
    )
    public ResponseEntity<AdsDto> getAd(
            @Parameter(description = "Идентификатор объявления", required = true)
            @PositiveOrZero @PathVariable("adsId") Long adsId) {
        return ResponseEntity.ok(adsService.getById(adsId));
    }

    @Operation(description = "Добавление объявления")
    @PostMapping()
    public ResponseEntity<AdsDto> createAd(@RequestBody AdsCreateDto request) {
        return new ResponseEntity<>(adsService.create(request), HttpStatus.CREATED);
    }

    @ApiIgnore
    @GetMapping(
            value = "/v1/ads-by-name",
            produces = {"application/json"}
    )
    public ResponseEntity<List<AdsDto>> getAdsByTitle(
            @Parameter(description = "Строка поиска")
            @RequestParam(value = "nameLike") String nameTitle) {
        return ResponseEntity.ok(adsService.getByTitle(nameTitle));
    }


}
