package dev.paulosouza.addressapi.config;

import dev.paulosouza.addressapi.mapper.AddressMapper;
import dev.paulosouza.addressapi.repository.AddressRepository;
import dev.paulosouza.addressapi.service.AddressService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AddressConfiguration {

    @Bean
    public AddressService addressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new AddressService(addressRepository, addressMapper);
    }

}
