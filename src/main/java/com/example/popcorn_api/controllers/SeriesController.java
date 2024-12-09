package com.example.popcorn_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.popcorn_api.dto.request.SeriesRequestDTO;
import com.example.popcorn_api.models.Series;
import com.example.popcorn_api.services.SeriesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping
    public ResponseEntity<List<Series>> getAll() {
        List<Series> allSeries = seriesService.getAll();
       return ResponseEntity.ok(allSeries);
    }
    
    @PostMapping
    public ResponseEntity<Series> create(@RequestBody SeriesRequestDTO series ) {
        Series newSerie = seriesService.create(series);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newSerie);
    }
    

}
