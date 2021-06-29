package dev.paulosouza.addressapi.controller;


import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("addresses")
public class AddressController {

    @PostMapping
    public ResponseEntity<AddressResponse> create(
            @RequestBody AddressRequest addressRequest,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .created(URI.create(request.getRequestURI()))
                .body(null);
    }

}
