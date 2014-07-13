package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.domain.Station;

import java.util.List;

public interface GasStationService
{
    Station get(String key);
    List<Station> get();
    Station create(Station station);
    Station update(Station station);
    Station delete(String key);
}
