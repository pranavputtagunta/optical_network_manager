package com.example.optical_network_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// These allow us to write readable tests like "get()" and "status().isOk()"
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // tells spring to set up a fake browser environment
class OpticalNetworkManagerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
        // checks if app loads without crashing 
	}

    @Test
    void shouldReturnDevices() throws Exception{
        mockMvc.perform(get("/api/devices")
            .contentType(MediaType.APPLICATION_JSON))
            // check if the status is 200 ok
            .andExpect(status().isOk())
            // check if the return is a JSON
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)); 

            // Optional: If you have data, you can check for specific values
            // .andExpect(jsonPath("$[0].name").value("Switch-01"));
    }

    @Test
    void shouldCreateDevice() throws Exception{
        String newDeviceJson = "{\"name\":\"Test-Switch\",\"type\":\"ROADM\",\"status\":\"Active\"}";

        mockMvc.perform(post("/api/devices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(newDeviceJson))
            .andExpect(status().isOk());
    }
}
