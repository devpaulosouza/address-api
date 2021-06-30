package dev.paulosouza.addressapi.api;

import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.GeoLocationCoordinatesResponse;
import dev.paulosouza.addressapi.dto.response.GeoLocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Slf4j
@Component
public class GeoLocationApi {

    private final String apiKey;

    public GeoLocationApi(@Value("${geolocation.apiKey}") String apiKey) {
        this.apiKey = apiKey;
    }

    public GeoLocationCoordinatesResponse fetchGeoLocation(AddressRequest addressRequest) {
        RestTemplate restTemplate = new RestTemplate();

        String googleApiUri = "https://maps.googleapis.com/maps/api/geocode/json";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        String addressSearch = buildAddressSearch(addressRequest);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(googleApiUri)
                .queryParam("address", addressSearch)
                .queryParam("key", this.apiKey);

        HttpEntity<?> entity = new HttpEntity<>(headers);


        ResponseEntity<GeoLocationResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                GeoLocationResponse.class
        );

        boolean isSuccessful = response.getStatusCode().is2xxSuccessful();
        boolean containsLocation = Objects.nonNull(response.getBody())
                && !CollectionUtils.isEmpty(response.getBody().getResults())
                && Objects.nonNull(response.getBody().getResults().get(0).getGeometry())
                && Objects.nonNull(response.getBody().getResults().get(0).getGeometry().getLocation());

        if (isSuccessful && containsLocation) {
            return response.getBody().getResults().stream().findFirst().get().getGeometry().getLocation();
        }


        return null;
    }

    private String buildAddressSearch(AddressRequest addressRequest) {
        return addressRequest.getStreetName()
                .concat(",")
                .concat(addressRequest.getNumber())
                .concat(",")
                .concat(addressRequest.getNeighbourhood())
                .concat(",")
                .concat(addressRequest.getCity())
                .concat(",")
                .concat(addressRequest.getState())
                .concat(",")
                .concat(addressRequest.getCountry());
    }

}
