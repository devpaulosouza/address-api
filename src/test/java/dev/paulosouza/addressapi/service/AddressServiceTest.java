package dev.paulosouza.addressapi.service;

import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import dev.paulosouza.addressapi.mapper.AddressMapper;
import dev.paulosouza.addressapi.model.Address;
import dev.paulosouza.addressapi.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressMapper addressMapper;

    @Test
    void create() {
        AddressResponse mockAddressResponse = mockAddressCreateResponse();

        when(addressRepository.save(any())).thenReturn(mockAddressCreate().get());
        when(addressMapper.toEntity(any())).thenReturn(mockAddressCreate().get());
        when(addressMapper.toResponse(any())).thenReturn(mockAddressResponse);

        AddressRequest addressRequest = mockAddressCreateRequest();

        AddressResponse addressResponse = this.addressService.create(addressRequest);
        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse).isEqualTo(mockAddressResponse);
    }

    @Test
    void update() {
        AddressResponse mockUpdateResponse = mockAddressUpdateResponse();
        when(addressRepository.findById(1L)).thenReturn(mockAddressCreate());
        when(addressMapper.toResponse(any())).thenReturn(mockUpdateResponse);

        AddressRequest updateRequest = mockAddressUpdateRequest();

        AddressResponse addressResponse = addressService.update(1L, updateRequest);

        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse).isEqualTo(mockUpdateResponse);
    }

    @Test
    void get() {
        AddressResponse mockAddressResponse = mockAddressCreateResponse();

        when(addressRepository.findById(1L)).thenReturn(mockAddressCreate());
        when(addressMapper.toResponse(any())).thenReturn(mockAddressResponse);

        AddressResponse addressResponse = this.addressService.get(1L);
        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse).isEqualTo(mockAddressResponse);
    }

    @Test
    void delete() {
        this.addressService.delete(1L);
    }

    private AddressRequest mockAddressUpdateRequest() {
        AddressRequest addressRequest = new AddressRequest();

        addressRequest.setStreetName("Av. Amazonas");
        addressRequest.setNumber("73");
        addressRequest.setNeighbourhood("Centro");
        addressRequest.setCity("Belo Horizonte");
        addressRequest.setState("Minas Gerais");
        addressRequest.setCountry("Brasil");
        addressRequest.setZipCode("30180-001");
        addressRequest.setLatitude(-19.9192439);
        addressRequest.setLongitude(-43.9392882);

        return addressRequest;
    }

    private AddressResponse mockAddressUpdateResponse() {
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId(1L);
        addressResponse.setStreetName("Av. Amazonas");
        addressResponse.setNumber("73");
        addressResponse.setNeighbourhood("Centro");
        addressResponse.setCity("Belo Horizonte");
        addressResponse.setState("Minas Gerais");
        addressResponse.setCountry("Brasil");
        addressResponse.setZipCode("30180-001");
        addressResponse.setLatitude(-19.9192439);
        addressResponse.setLongitude(-43.9392882);

        return addressResponse;
    }

    private AddressResponse mockAddressCreateResponse() {
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId(1L);
        addressResponse.setStreetName("Av. Amazonas");
        addressResponse.setNumber("478");
        addressResponse.setNeighbourhood("Centro");
        addressResponse.setCity("Belo Horizonte");
        addressResponse.setState("Minas Gerais");
        addressResponse.setCountry("Brasil");
        addressResponse.setZipCode("30180-001");
        addressResponse.setLatitude(-19.9192439);
        addressResponse.setLongitude(-43.9392882);

        return addressResponse;
    }

    private AddressRequest mockAddressCreateRequest() {
        AddressRequest addressRequest = new AddressRequest();

        addressRequest.setStreetName("Av. Amazonas");
        addressRequest.setNumber("478");
        addressRequest.setNeighbourhood("Centro");
        addressRequest.setCity("Belo Horizonte");
        addressRequest.setState("Minas Gerais");
        addressRequest.setCountry("Brasil");
        addressRequest.setZipCode("30180-001");
        addressRequest.setLatitude(-19.9192439);
        addressRequest.setLongitude(-43.9392882);

        return addressRequest;
    }

    private Optional<Address> mockAddressCreate() {
        Address address = new Address();

        address.setId(1L);
        address.setStreetName("Av. Amazonas");
        address.setNumber("478");
        address.setNeighbourhood("Centro");
        address.setCity("Belo Horizonte");
        address.setState("Minas Gerais");
        address.setCountry("Brasil");
        address.setZipCode("30180-001");
        address.setLatitude(-19.9192439);
        address.setLongitude(-43.9392882);

        return Optional.of(address);
    }
}