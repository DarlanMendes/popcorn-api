package com.example.popcorn_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.popcorn_api.dto.request.SeriesRequestDTO;
import com.example.popcorn_api.models.Series;
import com.example.popcorn_api.repository.SeriesRepository;

@Service
public class SeriesService {
    
    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAll(){
        return seriesRepository.findAll();
    }

    public Series create(SeriesRequestDTO serie){
        Series newSerie = new Series();

        return seriesRepository.save(newSerie);
    }
    //
}
