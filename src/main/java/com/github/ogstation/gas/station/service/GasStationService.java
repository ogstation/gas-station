package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.domain.GasStation;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GasStationService
{
    List<GasStation> get(Pageable pageable);
    GasStation get(String key);
    GasStation create(GasStation gasStation);
    GasStation update(GasStation gasStation);
    GasStation delete(String key);
}
