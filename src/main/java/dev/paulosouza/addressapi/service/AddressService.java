package dev.paulosouza.addressapi.service;

import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import dev.paulosouza.addressapi.mapper.AddressMapper;
import dev.paulosouza.addressapi.model.Address;
import dev.paulosouza.addressapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;


    public AddressResponse create(AddressRequest addressRequest) {
        Address address = this.addressMapper.toEntity(addressRequest);

        this.addressRepository.save(address);

        return this.addressMapper.toResponse(address);
    }

    public AddressResponse update(long addressId, AddressRequest updateRequest) {

        Optional<Address> optionalAddress = this.addressRepository.findById(addressId);

        if (optionalAddress.isEmpty()) {
            return null;
        }

        Address address = optionalAddress.get();

        BeanUtils.copyProperties(updateRequest, address);

        this.addressRepository.save(address);

        return this.addressMapper.toResponse(address);
    }

    public AddressResponse get(Long addressId) {
        Optional<Address> optionalAddress = this.addressRepository.findById(addressId);

        if (optionalAddress.isEmpty()) {
            return null;
        }

        Address address = optionalAddress.get();

        return this.addressMapper.toResponse(address);
    }

    public void delete(long addressId) {
        this.addressRepository.deleteById(addressId);
    }
}
