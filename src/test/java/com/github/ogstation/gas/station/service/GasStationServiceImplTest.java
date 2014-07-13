package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.domain.Station;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GasStationServiceImplTest
{

    private GasStationServiceImpl gasStationService;

    @Before
    public void setUp() throws Exception
    {
        gasStationService = new GasStationServiceImpl();
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // given

        // when
        gasStationService.get("key");

        // then
    }

    @Test
    public void should_be_able_to_get_stations() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);

        // when
        gasStationService.get(pageable);

        // then
    }

    @Test
    public void should_be_able_to_create() throws Exception
    {
        // given

        // when
        gasStationService.create(new Station());

        // then
    }

    @Test
    public void should_be_able_to_update() throws Exception
    {
        // given

        // when
        gasStationService.update(new Station());

        // then
    }

    @Test
    public void should_be_able_delete() throws Exception
    {
        // given

        // when
        gasStationService.delete("key");

        // then
    }
}