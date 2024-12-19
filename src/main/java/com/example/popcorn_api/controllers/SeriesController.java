package com.example.popcorn_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.popcorn_api.dto.request.SeriesRequestDTO;
import com.example.popcorn_api.models.Series;
import com.example.popcorn_api.services.SeriesService;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    // Endpoint para listar todas as séries
    @GetMapping
    public ResponseEntity<List<Series>> getAll() {
        List<Series> allSeries = seriesService.getAll();
        return ResponseEntity.ok(allSeries);
    }

    // Endpoint para criar uma nova série com um poster
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Series> create(
            @RequestPart("series") @Valid SeriesRequestDTO series, 
            @RequestPart("poster") MultipartFile poster) throws Exception{
                System.out.println(poster);
        try {
            // Chama o serviço para salvar a série e o arquivo
            Series newSerie = seriesService.create(series, poster);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSerie);
        } catch (Exception e) {
            // Retorna um erro em caso de falha
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
