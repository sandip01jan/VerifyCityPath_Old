package com.verify.city.path.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.verify.city.path.services.VerifyCitiesPathService;

@RunWith(MockitoJUnitRunner.class)
public class VerifyCitiesPathControllerTest {


    private MockMvc mockmvc;

    @InjectMocks
    private VerifyCitiesPathController controller;


    @Mock
    private VerifyCitiesPathService service;


    @Before
    public void setUp() throws Exception {
        mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
      //  customer = new Customer("Hello","World");

    }

    

    @Test
    public void testFindCitiesPathPass_Yes() throws Exception{

        when(service.findCitiesPath("Philadelphia", "Newark")).thenReturn("Yes");

        mockmvc.perform(get("/connected?origin=Philadelphia&destination=Newark"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Yes"));

    }

    @Test
    public void testFindCitiesPathPass_blank() throws Exception{

        when(service.findCitiesPath("Philadelphia", "")).thenReturn("No");

        mockmvc.perform(get("/connected?origin=Philadelphia&destination="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("No"));

    }

    @Test
    public void testFindCitiesPathPass_invalid_input() throws Exception{

        when(service.findCitiesPath("Philadelphia", "FGIUGJHGJ")).thenReturn("No");

        mockmvc.perform(get("/connected?origin=Philadelphia&destination=FGIUGJHGJ"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("No"));

    }
}
