package pl.sda.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADD_ID")
    private int id;
    @Column(name = "ADD_TOWNNAME")
    private String townName;
    @Column(name = "ADD_STREETNAME")
    private String streetName;
    @Column(name = "ADD_STREETNUMBER")
    private String streetNumber;
    @Column(name = "ADD_FLATNUMBER")
    private String flatNumber;
    @Column(name = "ADD_ZIPCODE")
    private String zipCode;

}
