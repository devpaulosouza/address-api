package dev.paulosouza.addressapi.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GeoLocationResponse {

    private List<GeoLocationItemResponse> results;

}
