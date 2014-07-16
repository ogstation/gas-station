package com.github.ogstation.gas.station.controller;

import com.github.ogstation.gas.station.domain.GasStation;
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
import static com.github.ogstation.gas.station.helper.RestURIConstants.GET_STATION_BY_NAME;
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
    public ResponseEntity<List<GasStation>> getGasStationsByPageable(@PageableDefault Pageable pageable)
    {
        List<GasStation> gasStations = gasStationService.get(pageable);
        return new ResponseEntity<List<GasStation>>(gasStations, OK);
    }

    @RequestMapping(value = GET_STATION, method = GET)
    public ResponseEntity<GasStation> get(@PathVariable String id)
    {
        GasStation gasStation = gasStationService.get(id);
        if (gasStation == null) {
            return new ResponseEntity<GasStation>(NOT_FOUND);
        }
        return new ResponseEntity<GasStation>(gasStation, OK);
    }

    @RequestMapping(value = GET_STATION_BY_NAME, method = GET)
    public ResponseEntity<GasStation> getByName(@PathVariable String name)
    {
        GasStation gasStation = gasStationService.getByName(name);
        if (gasStation == null) {
            return new ResponseEntity<GasStation>(NOT_FOUND);
        }
        return new ResponseEntity<GasStation>(gasStation, OK);
    }

    @RequestMapping(value = CREATE_STATION, method = POST)
    public ResponseEntity<GasStation> create(@Valid @RequestBody GasStation gasStation)
    {

        GasStation created = gasStationService.create(gasStation);
        if (created == null) {
            return new ResponseEntity<GasStation>(NOT_FOUND);
        }
        return new ResponseEntity<GasStation>(gasStation, OK);
    }

    @RequestMapping(value = UPDATE_STATION, method = PUT)
    public ResponseEntity<GasStation> update(@Valid @RequestBody GasStation gasStation)
    {
        GasStation update = gasStationService.update(gasStation);
        if (update == null) {
            return new ResponseEntity<GasStation>(NOT_FOUND);
        }
        return new ResponseEntity<GasStation>(gasStation, OK);
    }

    @RequestMapping(value = DELETE_STATION, method = DELETE)
    public ResponseEntity<GasStation> delete(@PathVariable String id)
    {
        GasStation gasStation = gasStationService.delete(id);
        if (gasStation == null) {
            return new ResponseEntity<GasStation>(NOT_FOUND);
        }
        return new ResponseEntity<GasStation>(gasStation, OK);
    }

}
