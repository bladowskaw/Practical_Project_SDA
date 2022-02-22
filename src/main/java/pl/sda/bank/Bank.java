package pl.sda.bank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.bank.exceptions.ClientNotFoundExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Bank {

    private List<Client> clientList = new ArrayList<>();

    public void addNewClient() {
        Client client = new Client();
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
        clientList.add(new Client(firstName, lastName, address));

    }

    public List<Client> removeClient(Client client) throws ClientNotFoundExeption {
        if (clientList.contains(client)) {
            clientList.remove(client);
        } else {
            throw new ClientNotFoundExeption();
        }

        return this.clientList;
    }

}
