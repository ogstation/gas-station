package com.github.ogstation.gas.station.dao;

import com.github.ogstation.gas.station.domain.GasStation;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GasStationDaoImpl extends BaseDao<GasStation> implements GasStationDao
{
    @Override
    public GasStation get(String key)
    {
        return super.get("getGasStationById", key);
    }

    @Override
    public List<GasStation> get(Pageable pageable)
    {
        return super.get("getGasStationsByPageable", pageable);
    }

    @Override
    public GasStation create(GasStation gasStation)
    {
        return super.create("insertGasStation", gasStation);
    }

    @Override
    public GasStation update(GasStation gasStation)
    {
        return super.update("updateGasStation", gasStation);
    }

    @Override
    public GasStation delete(String key)
    {
        return super.delete("deleteGasStation", key);
    }
}
