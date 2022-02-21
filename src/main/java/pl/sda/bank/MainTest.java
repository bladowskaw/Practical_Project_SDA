package pl.sda.bank;

import pl.sda.bank.exceptions.AccountNotFoundException;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.ClientNotFoundExeption;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class MainTest {
    /* Main testowy służący do sprawdzenia funkcjonalności napisanego kodu, który został napisany */


    public static void main(String[] args) throws AccountNotFoundException, ClientNotFoundExeption, BalanceToLowException {

        Bank bank = new Bank();


        bank.addNewClient("Jan", "Kow", new Address("Warszawa", "Długa", "55", "1", "70-150") );
        bank.addNewClient("Marian", "Kow", new Address("Warszawa", "Długa", "55", "1", "70-150") );
        //System.out.println(bank.getClientList().toString());

        /*List<Account> accountList = bank.getClientList()
                .stream()
                .flatMap(c -> {
                    return c.getAccountList().stream();
                })
                .collect(Collectors.toList());
        accountList.add(new Account("1", Currency.valueOf("PLN")));*/


        bank.getClientList().get(0).getAccountList().add(new Account("1", Currency.valueOf("PLN")));
        bank.getClientList().get(0).getAccountList().add(new Account("2", Currency.valueOf("USD")));
        bank.getClientList().get(0).getAccountList().get(0).addToAccount(BigDecimal.valueOf(1500.00));


        bank.getClientList().get(1).getAccountList().add(new Account("1", Currency.valueOf("PLN")));
        bank.getClientList().get(1).getAccountList().add(new Account("2", Currency.valueOf("USD")));

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));


        bank.removeClient(bank.getClientList().get(1));

        System.out.println("**************************");

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));

        System.out.println("**************************");


        bank.getClientList().get(0).getAccountList().get(0).subtractFromAccount(BigDecimal.valueOf(-1500.00));

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));

        /*Client client1 = new Client("1", "Alex", "b", address, listClient1);
        Account accountAlex1 = new Account("57775757", Currency.PLN);
        Account accountAlex2 = new Account("999997", Currency.PLN);
        client1.createNewAccount(listClient1,accountAlex1);
        client1.createNewAccount(listClient1, accountAlex2);
        System.out.println(listClient1);
        client1.removeAccount(accountAlex1, listClient1);
        System.out.println(listClient1);*/


    }
}
