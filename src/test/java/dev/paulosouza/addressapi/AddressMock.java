package dev.paulosouza.addressapi;

import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import dev.paulosouza.addressapi.model.Address;

import java.util.Optional;

public class AddressMock {


    public static AddressRequest mockAddressUpdateRequest() {
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

    public static AddressResponse mockAddressUpdateResponse() {
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

    public static AddressResponse mockAddressCreateResponse() {
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

    public static AddressRequest mockAddressCreateRequest() {
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

    public static Optional<Address> mockAddressCreate() {
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
