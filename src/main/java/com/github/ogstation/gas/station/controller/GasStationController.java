package com.github.ogstation.gas.station.controller;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.github.ogstation.gas.station.helper.RestURIConstants.CREATE_STATION;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GasStationController
{
    @RequestMapping(value = CREATE_STATION, method = POST)
    public ResponseEntity<Station> create(@Valid @RequestBody Station station)
    {
        return new ResponseEntity<Station>(station, OK);
    }
}
