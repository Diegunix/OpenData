package com.opendata.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opendata.dao.domain.Air;
import com.opendata.dao.repository.AirRepository;
import com.opendata.service.OpenDataService;

@RestController
public class AirController {
    
private AirRepository airRepository;
private OpenDataService service;

    
    public AirController(AirRepository airRepository, OpenDataService service) {
        this.airRepository = airRepository;
        this.service = service;
    }

  
  @GetMapping(value = "/data")
  public @ResponseBody Iterable<Air> getAllWeather() {
      return this.airRepository.findAll();
  }
  
  
  @GetMapping(value = "/importData")
  public @ResponseBody Iterable<Air> getData() throws IOException {
      this.service.getData();
      return null;
  }
  
  
}