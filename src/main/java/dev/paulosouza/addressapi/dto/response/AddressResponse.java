package dev.paulosouza.addressapi.dto.response;

import lombok.Data;

@Data
public class AddressResponse {

    private Long id;

    private String streetName;

    private String number;

    private String complement;

    private String neighbourhood;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private Double latitude;

    private Double longitude;

}
