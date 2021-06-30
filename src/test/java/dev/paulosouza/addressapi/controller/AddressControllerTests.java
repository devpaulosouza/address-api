package dev.paulosouza.addressapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static dev.paulosouza.addressapi.AddressMock.mockAddressCreateRequest;
import static dev.paulosouza.addressapi.AddressMock.mockAddressUpdateRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddressController.class)
public class AddressControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddressService addressService;

    @Test
    void whenValidInputPost_thenReturns201() throws Exception {
        AddressRequest addressRequest = mockAddressCreateRequest();

        mockMvc.perform(
                post("/addresses")
                        .content(objectMapper.writeValueAsString(addressRequest))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());
    }

    @Test
    void whenValidInputPut_thenReturns200() throws Exception {
        AddressRequest addressRequest = mockAddressUpdateRequest();

        mockMvc.perform(
                put("/addresses/1")
                        .content(objectMapper.writeValueAsString(addressRequest))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    void whenGetAll_thenReturns200() throws Exception {
        mockMvc.perform(
                get("/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    void whenGetOne_thenReturns200() throws Exception {
        mockMvc.perform(
                get("/addresses/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    void whenDelete_thenReturns200() throws Exception {
        mockMvc.perform(
                delete("/addresses/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

}
