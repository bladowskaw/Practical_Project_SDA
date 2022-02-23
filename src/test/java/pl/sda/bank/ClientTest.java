package pl.sda.bank;

import org.junit.jupiter.api.Test;
import pl.sda.bank.exceptions.AccountNotFoundException;
import pl.sda.bank.service.AccountService;
import pl.sda.bank.service.ClientService;

import static org.assertj.core.api.Assertions.assertThat;


class ClientTest {

    @Test
    void removeAccount_shouldRemoveAccountFromList() throws AccountNotFoundException {
        //given
        ClientService client = new ClientService();
        client.createNewAccount("123", Currency.PLN);

        //when
        client.removeAccount(new AccountService("123",Currency.PLN));

        //than
        assertThat(client.getAccountList().size()).isEqualTo(0);
    }
    @Test
    void createNewAccount_shouldAddNewAccountToList() {
        //given
        ClientService client = new ClientService();

        //when
        client.createNewAccount("123", Currency.PLN);
        client.createNewAccount("234",Currency.PLN);

        //than
        assertThat(client.getAccountList().size()).isEqualTo(2);
    }

}