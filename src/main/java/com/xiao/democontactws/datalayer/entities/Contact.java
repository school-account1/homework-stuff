package com.xiao.democontactws.datalayer.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="contacts_data")
@NoArgsConstructor
@Setter
@Getter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contactId;
    //If there is typo: @Column(name="tile");
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String companyName;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
