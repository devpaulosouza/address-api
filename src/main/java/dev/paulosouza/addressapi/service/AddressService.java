package dev.paulosouza.addressapi.service;

import dev.paulosouza.addressapi.api.GeoLocationApi;
import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import dev.paulosouza.addressapi.dto.response.GeoLocationCoordinatesResponse;
import dev.paulosouza.addressapi.mapper.AddressMapper;
import dev.paulosouza.addressapi.model.Address;
import dev.paulosouza.addressapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final GeoLocationApi geoLocationApi;


    public AddressResponse create(AddressRequest addressRequest) {
        Address address = this.addressMapper.toEntity(addressRequest);
        
        if (!this.containsCoordinates(addressRequest)) {
            GeoLocationCoordinatesResponse coordinates = this.geoLocationApi.fetchGeoLocation(addressRequest);

            if (Objects.nonNull(coordinates)) {
                address.setLatitude(coordinates.getLat());
                address.setLongitude(coordinates.getLng());
            }
        }

        this.addressRepository.save(address);

        return this.addressMapper.toResponse(address);
    }

    public AddressResponse update(long addressId, AddressRequest addressRequest) {

        Optional<Address> optionalAddress = this.addressRepository.findById(addressId);

        if (optionalAddress.isEmpty()) {
            return null;
        }


        Address address = optionalAddress.get();

        if (!this.containsCoordinates(addressRequest)) {
            GeoLocationCoordinatesResponse coordinates = this.geoLocationApi.fetchGeoLocation(addressRequest);

            if (Objects.nonNull(coordinates)) {
                address.setLatitude(coordinates.getLat());
                address.setLongitude(coordinates.getLng());
            }
        }

        BeanUtils.copyProperties(addressRequest, address);

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

    public Page<AddressResponse> get(Pageable pageable) {
        Page<Address> page = this.addressRepository.findAll(pageable);

        return page.map(this.addressMapper::toResponse);
    }

    private boolean containsCoordinates(AddressRequest addressRequest) {
        return Objects.nonNull(addressRequest.getLatitude())
                && Objects.nonNull(addressRequest.getLongitude());
    }
}
