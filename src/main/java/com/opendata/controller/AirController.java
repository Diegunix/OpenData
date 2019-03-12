package com.opendata.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opendata.dao.domain.Air;
import com.opendata.dao.domain.Estacion;
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

    @GetMapping(value = "/air")
    public @ResponseBody Iterable<Air> getAllAir() {
        return this.airRepository.findAll();
    }

    @GetMapping(value = "/air/ano/{ano}/mes/{mes}/dia/{dia}")
    public @ResponseBody Iterable<Air> getAllAirByDate(@PathVariable("ano") int ano, @PathVariable("mes") int mes,
            @PathVariable("dia") int dia) {
        return this.airRepository.findAllByAnoAndMesAndDia(ano, mes, dia);
    }

    @GetMapping(value = "/air/estacion/{estacion}/ano/{ano}/mes/{mes}/dia/{dia}")
    public @ResponseBody Iterable<Air> getAllAirByEstacionAndDate(@PathVariable("estacion") Long estacion, @PathVariable("ano") int ano,
            @PathVariable("mes") int mes, @PathVariable("dia") int dia) {
        return this.airRepository.findAllByEstacionAndAnoAndMesAndDia(Estacion.builder().id(estacion).build(), ano, mes, dia);
    }

    @GetMapping(value = "/importData")
    public @ResponseBody Iterable<Air> getData() throws IOException {
        this.service.getData();
        return null;
    }

}