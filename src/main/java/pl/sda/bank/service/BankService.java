package pl.sda.bank.service;

import pl.sda.bank.Address;
import pl.sda.bank.Bank;
import pl.sda.bank.exceptions.ClientNotFoundExeption;

import java.util.List;
import java.util.Scanner;

public class BankService extends Bank {

    public void addNewClient() {
        ClientService client = new ClientService();
        Scanner scanner = new Scanner(System.in);
        client.setFirstName(scanner.nextLine());
        client.setLastName(scanner.nextLine());
        Address address = new Address();
        address.setTownName(scanner.nextLine());
        address.setStreetName(scanner.nextLine());
        address.setStreetNumber(scanner.nextLine());
        address.setFlatNumber(scanner.nextLine());
        address.setZipCode(scanner.nextLine());
        client.setAddress(address);
        clientList.add(client);
    }

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
