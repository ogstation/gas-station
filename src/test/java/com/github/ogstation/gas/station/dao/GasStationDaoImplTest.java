package com.github.ogstation.gas.station.dao;

import com.github.ogstation.gas.station.domain.Station;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GasStationDaoImplTest
{
    @Mock
    private SqlSessionTemplate sqlSessionTemplate;
    @InjectMocks
    private GasStationDaoImpl gasStationDao;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        gasStationDao.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Station());
        Station station = gasStationDao.get("key");

        // then
        assertThat(station, notNullValue());
    }

    @Test
    public void should_be_able_to_get_stations_by_pageable() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);

        // when
        when(sqlSessionTemplate.selectList(anyString(), any(Pageable.class))).thenReturn(Arrays.<Object>asList(new Station()));
        List<Station> stations = gasStationDao.get(pageable);

        // then
        assertThat(stations.isEmpty(), is(false));
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.insert(anyString(), any(Station.class))).thenReturn(1);
        Station station = gasStationDao.create(new Station());

        // then
        assertThat(station, notNullValue());
    }

    @Test
    public void should_be_able_to_update_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.update(anyString(), any(Station.class))).thenReturn(1);
        Station station = gasStationDao.update(new Station());

        // then
        assertThat(station, notNullValue());
    }

    @Test
    public void should_be_able_to_delete_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.delete(anyString(), anyString())).thenReturn(1);
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Station());
        Station station = gasStationDao.delete("key");

        // then
        assertThat(station, notNullValue());
    }

    @Test
    public void should_be_able_to_return_empty_when_update() throws Exception
    {
        // when
        when(sqlSessionTemplate.update(anyString(), any(Station.class))).thenReturn(0);
        Station station = gasStationDao.update(new Station());

        // then
        assertThat(station, nullValue());
    }
}
