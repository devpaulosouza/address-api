package dev.paulosouza.addressapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 150)
    private String streetName;

    @Column(nullable = false, length = 20)
    private String number;

    @Column(length = 20)
    private String complement;

    @Column(nullable = false, length = 50)
    private String neighbourhood;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 8)
    private String zipCode;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

}
