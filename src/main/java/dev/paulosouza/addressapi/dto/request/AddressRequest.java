package dev.paulosouza.addressapi.dto.request;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AddressRequest {

    @NotNull
    @Length(min = 1, max = 150)
    private String streetName;

    @NotNull
    @Length(min = 1, max = 20)
    private String number;

    @Length(max = 20)
    private String complement;

    @NotNull
    @Length(min = 1, max = 50)
    private String neighbourhood;

    @NotNull
    @Length(min = 1, max = 50)
    private String city;

    @NotNull
    @Length(min = 1, max = 50)
    private String country;

    @NotNull
    @Length(min = 1, max = 50)
    private String state;

    /*
    * Considerando CEPs no Brasil, temos válido números como 319000-031 ou 319000031
    * */
    @NotNull
    @Length(min = 8, max = 9)
    private String zipCode;

    private Double latitude;

    private Double longitude;

}
