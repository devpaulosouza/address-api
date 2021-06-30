package dev.paulosouza.addressapi.controller;


import dev.paulosouza.addressapi.dto.request.AddressRequest;
import dev.paulosouza.addressapi.dto.response.AddressResponse;
import dev.paulosouza.addressapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> create(
            @RequestBody @Valid AddressRequest addressRequest,
            HttpServletRequest request
    ) {
        AddressResponse addressResponse = this.addressService.create(addressRequest);

        return ResponseEntity
                .created(URI.create(request.getRequestURI()))
                .body(addressResponse);
    }

    @PutMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> update(
            @RequestBody @Valid AddressRequest addressRequest,
            @PathVariable Long addressId
    ) {
        AddressResponse addressResponse = this.addressService.update(addressId, addressRequest);
        return ResponseEntity.ok(addressResponse);
    }

    @GetMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> get(@PathVariable Long addressId) {
        this.addressService.get(addressId);
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<Page<AddressResponse>> get(Pageable pageable) {
//        this.addressService.get(pageable);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{addressId}")
    public ResponseEntity<AddressResponse> delete( @PathVariable Long addressId) {
        this.addressService.delete(addressId);
        return ResponseEntity.ok(null);
    }

}
