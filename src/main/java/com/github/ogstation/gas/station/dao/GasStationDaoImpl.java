package com.github.ogstation.gas.station.dao;

import com.github.ogstation.gas.station.domain.Station;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GasStationDaoImpl extends BaseDao<Station> implements GasStationDao
{
    @Override
    public Station get(String key)
    {
        return super.get("com.github.ogstation.gas.station.domain.Station.getStationById", key);
    }

    @Override
    public List<Station> get(Pageable pageable)
    {
        return super.get("com.github.ogstation.gas.station.domain.Station.getStationsByPageable", pageable);
    }

    @Override
    public Station create(Station station)
    {
        return super.create("com.github.ogstation.gas.station.domain.Station.insertStation", station);
    }

    @Override
    public Station update(Station station)
    {
        return super.update("com.github.ogstation.gas.station.domain.Station.updateStation", station);
    }

    @Override
    public Station delete(String key)
    {
        return super.delete("com.github.ogstation.gas.station.domain.Station.deleteStation", key);
    }
}
