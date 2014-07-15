package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.dao.GasStationDao;
import com.github.ogstation.gas.station.domain.GasStation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GasGasStationServiceImplTest
{
    @Mock
    private GasStationDao gasStationDao;

    @InjectMocks
    private GasStationServiceImpl gasStationService;


    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // given
        when(gasStationDao.get(anyString())).thenReturn(new GasStation());

        // when
        GasStation gasStation = gasStationService.get("key");

        // then
        assertThat(gasStation, notNullValue());
    }

    @Test
    public void should_be_able_to_get_stations() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);
        when(gasStationDao.get(pageable)).thenReturn(Arrays.asList(new GasStation()));

        // when
        List<GasStation> gasStations = gasStationService.get(pageable);

        // then
        assertThat(gasStations.isEmpty(), is(false));
    }

    @Test
    public void should_be_able_to_create() throws Exception
    {
        // given
        GasStation gasStation = new GasStation();
        when(gasStationDao.create(gasStation)).thenReturn(gasStation);

        // when
        GasStation result = gasStationService.create(gasStation);

        // then
        assertThat(result, notNullValue());
    }

    @Test
    public void should_be_able_to_update() throws Exception
    {
        // given
        GasStation gasStation = new GasStation();
        when(gasStationDao.update(gasStation)).thenReturn(new GasStation());

        // when
        GasStation update = gasStationService.update(gasStation);

        // then
        assertThat(update, notNullValue());
    }

    @Test
    public void should_be_able_delete() throws Exception
    {
        // given
        when(gasStationDao.delete(anyString())).thenReturn(new GasStation());

        // when
        GasStation gasStation = gasStationService.delete("key");

        // then
        assertThat(gasStation, notNullValue());
    }
}