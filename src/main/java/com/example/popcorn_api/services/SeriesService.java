package com.example.popcorn_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.popcorn_api.dto.request.SeriesRequestDTO;
import com.example.popcorn_api.models.Series;
import com.example.popcorn_api.repository.SeriesRepository;

@Service
public class SeriesService {
    
    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    public List<Series> getAll() {
        return seriesRepository.findAll();
    }

    public Series create(SeriesRequestDTO serie, MultipartFile file) {
        Series newSerie = new Series();
        newSerie.setTitle(serie.getTitle());
        newSerie.setDescription(serie.getDescription());
        newSerie.setGenres(serie.getGenres());
        String urlImg ="";
        if(!file.isEmpty()){
            urlImg = cloudinaryService.uploadFile(file, "series");
            newSerie.setPoster(urlImg);
            return seriesRepository.save(newSerie);
        }
        newSerie.setPoster(urlImg);
        return seriesRepository.save(newSerie);
    }
}
