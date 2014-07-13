package com.github.ogstation.gas.station.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ogstation.gas.station.domain.Station;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static com.github.ogstation.gas.station.helper.ExceptionHandlerHelper.exceptionResolver;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GasStationControllerTest
{

    private MockMvc mockMvc;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private GasStationController gasStationController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        when(messageSource.getMessage(any(MessageSourceResolvable.class), any(Locale.class))).thenReturn("error message");
        this.mockMvc = standaloneSetup(gasStationController)
                .setHandlerExceptionResolvers(exceptionResolver(messageSource)).build();
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // given
        Station station = new Station();
        station.setName("station name");
        station.setProvinceCode("province_code");
        station.setCityCode("city_code");
        station.setCountryCode("country_code");
        station.setAddressDetails("address details");
        station.setContact("contact");
        station.setPhone("phone");
        station.setEmail("test@test.com");

        // then
        this.mockMvc.perform(post("/api/stations")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(station)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // then
        this.mockMvc.perform(get("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_be_able_to_update_station() throws Exception
    {
        // given
        Station station = new Station();
        station.setName("station name");
        station.setProvinceCode("province_code");
        station.setCityCode("city_code");
        station.setCountryCode("country_code");
        station.setAddressDetails("address details");
        station.setContact("contact");
        station.setPhone("phone");
        station.setEmail("test@test.com");

        // then
        this.mockMvc.perform(put("/api/stations/1")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(station)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("station name")));
    }

    @Test
    public void should_be_able_to_delete_station() throws Exception
    {
        // then
        this.mockMvc.perform(delete("/api/stations/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
