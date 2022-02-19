package pl.sda.bank;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {

    private String townName;
    private String streetName;
    private String streetNumber;
    private String flatNumber;
    private String zipCode;

}
