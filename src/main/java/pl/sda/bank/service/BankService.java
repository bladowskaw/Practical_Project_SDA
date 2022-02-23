package pl.sda.bank.service;

import pl.sda.bank.Bank;
import pl.sda.bank.exceptions.ClientNotFoundExeption;
import pl.sda.bank.model.Address;

import java.util.List;

public class BankService extends Bank {



    public void addNewClient(String firstName, String lastName, Address address) {
        clientList.add(new ClientService(firstName, lastName, address));

    }

    public List<ClientService> removeClient(ClientService client) throws ClientNotFoundExeption {
        if (clientList.contains(client)) {
            clientList.remove(client);
        } else {
            throw new ClientNotFoundExeption();
        }

        return this.clientList;
    }
}
