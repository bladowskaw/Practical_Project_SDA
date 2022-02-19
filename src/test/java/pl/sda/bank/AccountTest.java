package pl.sda.bank;

import org.junit.jupiter.api.Test;
import pl.sda.bank.exceptions.BalanceToLowException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class AccountTest {

    @Test
    void addToAccount_shouldIncreaseBalance() {
        //given
        var account = new Account("0001", Currency.PLN);

        //when
        account.addToAccount(new BigDecimal("100"));

        //then
        assertThat(account.getAccountBalance()).isEqualTo("100");
    }

    @Test
    void subtractFromAccount_shouldDecreaseBalance() throws BalanceToLowException {
        //given
        var account = new Account("0001", Currency.PLN);
        account.addToAccount(new BigDecimal("300"));

        //when
        account.subtractFromAccount(new BigDecimal("100"));

        //then
        assertThat(account.getAccountBalance()).isEqualTo("200");
    }

    @Test
    void subtractFromAccount_shouldThrowExceptionWhenBalanceToLow() {
        //given
        var account = new Account("0001", Currency.PLN);
        account.addToAccount(new BigDecimal("100"));

        //when
        Throwable thrown = catchThrowable(() ->
                account.subtractFromAccount(new BigDecimal("200"))
        );

        //then
        assertThat(thrown).isInstanceOf(BalanceToLowException.class);
    }
}