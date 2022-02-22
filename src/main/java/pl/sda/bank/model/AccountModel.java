package pl.sda.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.bank.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACC_ID")
    private int id;
    @Column(name = "ACC_NUMBER")
    private String accountNumber;
    @Column(name = "ACC_CURRENCYY")
    private Currency currency;
    @Column(name = "ACC_BALANCE")
    private BigDecimal accountBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_CLI_ID", referencedColumnName = "ACC_ID")
    private ClientModel clientList;
}
