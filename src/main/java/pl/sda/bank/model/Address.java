package pl.sda.bank.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADD_ID")
    public int id;
    @Column(name = "ADD_TOWNNAME")
    public String townName;
    @Column(name = "ADD_STREETNAME")
    public String streetName;
    @Column(name = "ADD_STREETNUMBER")
    public String streetNumber;
    @Column(name = "ADD_FLATNUMBER")
    public String flatNumber;
    @Column(name = "ADD_ZIPCODE")
    public String zipCode;

    public Address(String townName, String streetName, String streetNumber, String flatNumber, String zipCode) {
        this.townName = townName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
    }
}
