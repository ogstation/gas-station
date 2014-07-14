package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.dao.GasStationDao;
import com.github.ogstation.gas.station.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService
{
    @Autowired
    private GasStationDao gasStationDao;

    @Override
    public Station get(String key)
    {
        return gasStationDao.get(key);
    }

    @Override
    public List<Station> get(Pageable pageable)
    {
        return gasStationDao.get(pageable);
    }

    @Override
    public Station create(Station station)
    {
        return gasStationDao.create(station);
    }

    @Override
    public Station update(Station station)
    {
        return gasStationDao.update(station);
    }

    @Override
    public Station delete(String key)
    {
        return gasStationDao.delete(key);
    }
}
