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

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
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

        AddressRequest addressRequest = mockAddressCreateRequest();

        AddressResponse addressResponse = this.addressService.get(1L);
        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse).isEqualTo(mockAddressResponse);
    }

    @Test
    void delete() {
        this.addressService.delete(1L);
    }

    private AddressRequest mockAddressUpdateRequest() {
        return AddressRequest.builder()
                .streetName("Av. Amazonas")
                .number("73")
                .neighbourhood("Centro")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("Brasil")
                .zipCode("30180-001")
                .latitude(-19.9192439)
                .longitude(-43.9392882)
                .build();
    }

    private AddressResponse mockAddressUpdateResponse() {
        return AddressResponse.builder()
                .id(1L)
                .streetName("Av. Amazonas")
                .number("73")
                .neighbourhood("Centro")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("Brasil")
                .zipCode("30180-001")
                .latitude(-19.9192439)
                .longitude(-43.9392882)
                .build();
    }

    private AddressResponse mockAddressCreateResponse() {
        return AddressResponse.builder()
                .id(1L)
                .streetName("Av. Amazonas")
                .number("478")
                .neighbourhood("Centro")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("Brasil")
                .zipCode("30180-001")
                .latitude(-19.9192439)
                .longitude(-43.9392882)
                .build();
    }

    private AddressRequest mockAddressCreateRequest() {
        return AddressRequest.builder()
                .streetName("Av. Amazonas")
                .number("478")
                .neighbourhood("Centro")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("Brasil")
                .zipCode("30180-001")
                .latitude(-19.9192439)
                .longitude(-43.9392882)
                .build();
    }

    private Optional<Address> mockAddressCreate() {
        return Optional.of(
                Address.builder()
                    .id(1L)
                    .streetName("Av. Amazonas")
                    .number("478")
                    .neighbourhood("Centro")
                    .city("Belo Horizonte")
                    .state("Minas Gerais")
                    .country("Brasil")
                    .zipCode("30180-001")
                    .latitude(-19.9192439)
                    .longitude(-43.9392882)
                    .build()
        );
    }
}