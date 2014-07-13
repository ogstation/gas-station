package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService
{
    @Override
    public Station get(String key)
    {
        return null;
    }

    @Override
    public List<Station> get(Pageable pageable)
    {
        return null;
    }

    @Override
    public Station create(Station station)
    {
        return null;
    }

    @Override
    public Station update(Station station)
    {
        return null;
    }

    @Override
    public Station delete(String key)
    {
        return null;
    }
}
