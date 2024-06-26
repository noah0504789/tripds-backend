package com.ssafy.tripds.streetlight.controller;

import com.ssafy.tripds.streetlight.model.dto.StreetlightCoordinateDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightDto;
import com.ssafy.tripds.streetlight.model.dto.StreetlightSearchDto;
import com.ssafy.tripds.streetlight.model.service.StreetlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/light")
@RequiredArgsConstructor
@Slf4j
public class StreetlightController {

    private final StreetlightService streetlightService;

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyStreetLights(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("radius") long radius) {

        StreetlightCoordinateDto streetlightCoordinateDto = new StreetlightCoordinateDto(latitude, longitude, radius);
        List<StreetlightDto> streetlightDto = streetlightService.getNearbyStreetLights(streetlightCoordinateDto);

        return new ResponseEntity<>(streetlightDto, HttpStatus.OK);
    }

    @GetMapping("/map")
    public ResponseEntity<?> getStreetlightFromMap(
            @RequestParam("swLat") double swLat,
            @RequestParam("swLng") double swLng,
            @RequestParam("neLat") double neLat,
            @RequestParam("neLng") double neLng) {

        StreetlightSearchDto streetlightSearchDto = new StreetlightSearchDto(swLat, swLng, neLat, neLng);
        List<StreetlightDto> streetlightDtoList = streetlightService.getStreetlightFromMap(streetlightSearchDto);

        return new ResponseEntity<>(streetlightDtoList, HttpStatus.OK);
    }
}
