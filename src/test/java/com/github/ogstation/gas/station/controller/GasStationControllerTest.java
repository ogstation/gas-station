package com.github.ogstation.gas.station.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GasStationControllerTest
{

    private MockMvc mockMvc;
    @InjectMocks
    private GasStationController gasStationController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(gasStationController).build();
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/stations")
                .contentType(APPLICATION_FORM_URLENCODED)
                .param("name", "station_name")
                .param("provinceCode", "province_code")
                .param("cityCode", "city_code")
                .param("countryCode", "country_code")
                .param("contact", "contact")
                .param("phone", "phone"))
                .andExpect(status().isOk());
    }
}
