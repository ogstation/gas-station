package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.dao.GasStationDao;
import com.github.ogstation.gas.station.domain.GasStation;
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
    public GasStation get(String key)
    {
        return gasStationDao.get(key);
    }

    @Override
    public GasStation getByName(String name)
    {
        return gasStationDao.getByName(name);
    }

    @Override
    public List<GasStation> get(Pageable pageable)
    {
        return gasStationDao.get(pageable);
    }

    @Override
    public GasStation create(GasStation gasStation)
    {
        return gasStationDao.create(gasStation);
    }

    @Override
    public GasStation update(GasStation gasStation)
    {
        return gasStationDao.update(gasStation);
    }

    @Override
    public GasStation delete(String key)
    {
        return gasStationDao.delete(key);
    }

    @Override
    public GasStation search(GasStation gasStation)
    {
        return gasStationDao.search(gasStation);
    }
}
