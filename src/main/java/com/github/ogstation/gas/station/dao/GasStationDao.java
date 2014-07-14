package com.github.ogstation.gas.station.dao;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GasStationDao
{
    Station get(String key);

    List<Station> get(Pageable pageable);

    Station create(Station station);

    Station update(Station station);

    Station delete(String key);
}
