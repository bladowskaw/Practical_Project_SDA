package pl.sda.bank.model;

import lombok.*;
import pl.sda.bank.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACC_ID")
    public int id;
    @Column(name = "ACC_NUMBER")
    public String accountNumber;
    @Column(name = "ACC_CURRENCYY")
    public Currency currency;
    @Column(name = "ACC_BALANCE")
    public BigDecimal accountBalance = new BigDecimal("0");
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_CLI_ID", referencedColumnName = "ACC_ID")
    public Client clientList;
}

