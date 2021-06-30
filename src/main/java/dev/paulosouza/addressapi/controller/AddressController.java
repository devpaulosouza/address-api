package dev.paulosouza.addressapi.controller;


import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> update(
            @RequestBody AddressRequest addressRequest,
            @PathVariable Long addressId,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .ok(null);
    }

    @GetMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> get(
            @RequestBody AddressRequest addressRequest,
            @PathVariable Long addressId,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .ok(null);
    }

    @GetMapping
    public ResponseEntity<AddressResponse> get(
            @RequestBody AddressRequest addressRequest,
            Pageable pageable,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .ok(null);
    }

    @DeleteMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> delete(
            @RequestBody AddressRequest addressRequest,
            @PathVariable Long addressId,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .ok(null);
    }

}
