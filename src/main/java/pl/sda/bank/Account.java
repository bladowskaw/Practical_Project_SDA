package pl.sda.bank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@NoArgsConstructor
public class Account {

    private String accountNumber;
    private BigDecimal accountBalance;
    private Currency currency;

    public static void addToAccount(BigDecimal cash) {
    }

    public void subtractFromAccount(BigDecimal cash) {
        //porównaj czy kasa <= stan konta

    }

}
