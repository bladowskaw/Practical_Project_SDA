package pl.sda.bank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class Bank {

   private List<Client> clientList;
   private List<Account> accountList;

    public static Client addNewClient () {
        return null;
    }

    public static void removeClient (Client c) {

    }


}

