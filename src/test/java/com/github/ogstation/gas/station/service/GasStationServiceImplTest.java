package com.github.ogstation.gas.station.service;

import com.github.ogstation.gas.station.dao.GasStationDao;
import com.github.ogstation.gas.station.domain.Station;
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

public class GasStationServiceImplTest
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
        when(gasStationDao.get(anyString())).thenReturn(new Station());

        // when
        Station station = gasStationService.get("key");

        // then
        assertThat(station, notNullValue());
    }

    @Test
    public void should_be_able_to_get_stations() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);
        when(gasStationDao.get(pageable)).thenReturn(Arrays.asList(new Station()));

        // when
        List<Station> stations = gasStationService.get(pageable);

        // then
        assertThat(stations.isEmpty(), is(false));
    }

    @Test
    public void should_be_able_to_create() throws Exception
    {
        // given
        Station station = new Station();
        when(gasStationDao.create(station)).thenReturn(station);

        // when
        Station result = gasStationService.create(station);

        // then
        assertThat(result, notNullValue());
    }

    @Test
    public void should_be_able_to_update() throws Exception
    {
        // given
        Station station = new Station();
        when(gasStationDao.update(station)).thenReturn(new Station());

        // when
        Station update = gasStationService.update(station);

        // then
        assertThat(update, notNullValue());
    }

    @Test
    public void should_be_able_delete() throws Exception
    {
        // given
        when(gasStationDao.delete(anyString())).thenReturn(new Station());

        // when
        Station station = gasStationService.delete("key");

        // then
        assertThat(station, notNullValue());
    }
}