package com.github.ogstation.gas.station.controller;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.github.ogstation.gas.station.helper.RestURIConstants.CREATE_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.DELETE_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.GET_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.UPDATE_STATION;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class GasStationController
{
    @RequestMapping(value = CREATE_STATION, method = POST)
    public ResponseEntity<Station> create(@Valid @RequestBody Station station)
    {
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = GET_STATION, method = GET)
    public ResponseEntity<Station> get()
    {
        Station station = new Station();
        station.setName("station name");
        station.setProvinceCode("province");
        station.setCityCode("city");
        station.setCountryCode("country");
        station.setAddressDetails("address");
        station.setContact("contact");
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = UPDATE_STATION, method = PUT)
    public ResponseEntity<Station> update(@Valid @RequestBody Station station)
    {
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = DELETE_STATION, method = DELETE)
    public ResponseEntity<Station> delete()
    {
        Station station = new Station();
        station.setName("station name");
        station.setProvinceCode("province");
        station.setCityCode("city");
        station.setCountryCode("country");
        station.setAddressDetails("address");
        station.setContact("contact");
        return new ResponseEntity<Station>(station, OK);
    }

}
