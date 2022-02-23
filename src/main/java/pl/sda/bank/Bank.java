package pl.sda.bank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.bank.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Bank {

    public List<ClientService> clientList = new ArrayList<>();


}
