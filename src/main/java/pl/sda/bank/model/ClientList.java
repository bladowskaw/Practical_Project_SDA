package pl.sda.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class ClientList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private int id;
    @Column(name = "CLI_CLIENTID")
    private String clientId;
    @Column(name = "CLI_FIRSTNAME")
    private String firstName;
    @Column(name = "CLI_LASTNAME")
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLI_ADD_ID", referencedColumnName = "ADD_ID")
    private AddressList addressList;
}
