package com.github.ogstation.gas.station.controller;

import com.github.ogstation.gas.station.domain.Station;
import com.github.ogstation.gas.station.service.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static com.github.ogstation.gas.station.helper.RestURIConstants.CREATE_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.DELETE_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.GET_ALL_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.GET_STATION;
import static com.github.ogstation.gas.station.helper.RestURIConstants.UPDATE_STATION;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class GasStationController
{
    @Autowired
    private GasStationService gasStationService;

    @RequestMapping(value = GET_ALL_STATION, method = GET)
    public ResponseEntity<List<Station>> getAll(@PageableDefault Pageable pageable)
    {
        return new ResponseEntity<List<Station>>(OK);
    }

    @RequestMapping(value = GET_STATION, method = GET)
    public ResponseEntity<Station> get(@PathVariable String id)
    {
        Station station = gasStationService.get(id);
        if (station == null) {
            return new ResponseEntity<Station>(NOT_FOUND);
        }
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = CREATE_STATION, method = POST)
    public ResponseEntity<Station> create(@Valid @RequestBody Station station)
    {
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = UPDATE_STATION, method = PUT)
    public ResponseEntity<Station> update(@Valid @RequestBody Station station)
    {
        Station update = gasStationService.update(station);
        if (update == null) {
            return new ResponseEntity<Station>(NOT_FOUND);
        }
        return new ResponseEntity<Station>(station, OK);
    }

    @RequestMapping(value = DELETE_STATION, method = DELETE)
    public ResponseEntity<Station> delete(@PathVariable String id)
    {
        Station station = gasStationService.delete(id);
        if (station == null) {
            return new ResponseEntity<Station>(NOT_FOUND);
        }
        return new ResponseEntity<Station>(station, OK);
    }

}
