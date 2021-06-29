package dev.paulosouza.addressapi.service;

import dev.paulosouza.addressapi.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class AddressServiceTests {

    private final AddressRepository addressRepository = Mockito.mock(AddressRepository.class);

    private AddressService addressService;

    @BeforeEach
    void setup() {
        this.addressService = new AddressService(addressRepository);
    }

}
