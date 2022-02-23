package pl.sda.bank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account {


    public String accountNumber;
    public Currency currency;
    public BigDecimal accountBalance = new BigDecimal(0);

}
