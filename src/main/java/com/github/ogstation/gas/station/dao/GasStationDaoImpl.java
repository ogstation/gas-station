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
    public GasStation getByName(String name)
    {
        return super.get("getGasStationByName", name);
    }

    @Override
    public List<GasStation> get(Pageable pageable)
    {
        return super.get("getGasStationsByPageable", pageable);
    }

    @Override
    public GasStation create(GasStation gasStation)
    {
        int insertGasStation = super.create("insertGasStation", gasStation);
        return get(String.valueOf(insertGasStation));
    }

    @Override
    public GasStation update(GasStation gasStation)
    {
        int updateGasStation = super.update("updateGasStation", gasStation);
        return get(String.valueOf(updateGasStation));
    }

    @Override
    public GasStation delete(String key)
    {
        int deleteGasStation = super.delete("deleteGasStation", key);
        return get(String.valueOf(deleteGasStation));
    }

    @Override
    public GasStation search(GasStation gasStation)
    {
        return super.search("searchGasStation", gasStation);
    }
}
