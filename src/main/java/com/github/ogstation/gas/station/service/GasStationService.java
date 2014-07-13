package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GasStationService
{
    List<Station> get(Pageable pageable);
    Station get(String key);
    Station create(Station station);
    Station update(Station station);
    Station delete(String key);
}
