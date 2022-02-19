package pl.sda.bank;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bank {

    private List<Client> clientList;
    private List<Account> accountList;

    public static Client addNewClient(Client client, List<Client> clientList) {


        return null;
    }

    public static void removeClient(Client c) {

    }


}

