package org.example.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "user_address")
public class UserAddress {
    @Id
   @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private int id;

    private String city;

    private String street;
    private int house;
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }

    public UserAddress(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }
}

