package com.github.ogstation.gas.station.dao;

import com.github.ogstation.gas.station.domain.GasStation;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GasStationDao
{
    GasStation get(String key);

    GasStation getByName(String name);

    List<GasStation> get(Pageable pageable);

    GasStation create(GasStation gasStation);

    GasStation update(GasStation gasStation);

    GasStation delete(String key);
}
