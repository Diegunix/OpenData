package com.opendata.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;
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

  
  @RequestMapping(value = "/data", method = RequestMethod.GET)
  public @ResponseBody Iterable<Air> getAllWeather() {
      return this.airRepository.findAll();
  }
  
  
  @RequestMapping(value = "/importData", method = RequestMethod.GET)
  public @ResponseBody Iterable<Air> getData() throws JsonSyntaxException, IOException, ParseException {
      this.service.getData();
      return null;
  }
  
  
}