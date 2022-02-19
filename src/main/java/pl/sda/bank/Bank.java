package pl.sda.bank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.bank.exceptions.CashIsNegativeException;
import pl.sda.bank.exceptions.ClientNotFoundExeption;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Bank {

    private List<Client> clientList;
    private List<Account> accountList;

    public List<Client> addNewClient(List<Client> clientList, Client client) {
        clientList.add(client);
        return clientList;
    }


    public List<Client> removeClient(List<Client> clientList, Client client) throws ClientNotFoundExeption {
        if (clientList.contains(client)) {
            clientList.remove(client);
        } else {
            throw new ClientNotFoundExeption();
        }

        return this.clientList;

    }
}
