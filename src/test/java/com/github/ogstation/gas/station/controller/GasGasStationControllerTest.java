package com.github.ogstation.gas.station.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ogstation.gas.station.domain.GasStation;
import com.github.ogstation.gas.station.service.GasStationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GasGasStationControllerTest
{

    private MockMvc mockMvc;

    @Mock
    private GasStationService gasStationService;

    @InjectMocks
    private GasStationController gasStationController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(gasStationController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(new ViewResolver()
                {
                    @Override
                    public View resolveViewName(String viewName, Locale locale) throws Exception
                    {
                        return new MappingJackson2JsonView();
                    }
                }).build();
    }

    @Test
    public void should_be_able_to_get_stations_by_pagesize() throws Exception
    {
        // when
        when(gasStationService.get(any(Pageable.class))).thenReturn(Arrays.asList(buildStation()));

        // then
        this.mockMvc.perform(get("/api/stations/?page=2&size=50")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("station name")));
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // when
        when(gasStationService.get(anyString())).thenReturn(buildStation());

        // then
        this.mockMvc.perform(get("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_be_able_to_search_station() throws Exception
    {
        // when
        when(gasStationService.search(any(GasStation.class))).thenReturn(buildStation());

        // then
        this.mockMvc.perform(post("/api/stations/search")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildStation())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // when
        when(gasStationService.create(any(GasStation.class))).thenReturn(buildStation());

        // then
        this.mockMvc.perform(post("/api/stations")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildStation())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_raise_error_when_get_station_is_not_exist() throws Exception
    {
        // when
        when(gasStationService.get(anyString())).thenReturn(null);

        // then
        this.mockMvc.perform(get("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_be_able_to_update_station() throws Exception
    {
        // when
        when(gasStationService.update(any(GasStation.class))).thenReturn(buildStation());

        // then
        this.mockMvc.perform(put("/api/stations/1")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildStation())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_raise_error_when_update_station_is_not_exist() throws Exception
    {
        // when
        when(gasStationService.update(any(GasStation.class))).thenReturn(null);

        // then
        this.mockMvc.perform(put("/api/stations/1")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildStation())))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_be_able_to_delete_station() throws Exception
    {
        // when
        when(gasStationService.delete(anyString())).thenReturn(buildStation());

        // then
        this.mockMvc.perform(delete("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_raise_error_when_delete_station_is_not_exist() throws Exception
    {
        // when
        when(gasStationService.delete(anyString())).thenReturn(null);

        // then
        this.mockMvc.perform(delete("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private GasStation buildStation()
    {
        GasStation gasStation = new GasStation();
        gasStation.setName("station name");
        gasStation.setProvinceCode("province_code");
        gasStation.setCityCode("city_code");
        gasStation.setCountryCode("country_code");
        gasStation.setAddressDetails("address details");
        gasStation.setContact("contact");
        gasStation.setPhone("phone");
        gasStation.setEmail("test@test.com");
        return gasStation;
    }
}
