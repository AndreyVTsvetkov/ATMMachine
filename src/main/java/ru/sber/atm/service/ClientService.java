package ru.sber.atm.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sber.atm.atm.processor.Account;
import ru.sber.atm.atm.processor.Balance;
import ru.sber.atm.atm.processor.BalanceWithoutOverdraft;
import ru.sber.atm.atm.processor.Card;
import ru.sber.atm.atm.processor.Client;
import ru.sber.atm.entity.AccountEntity;
import ru.sber.atm.entity.CardEntity;
import ru.sber.atm.entity.ClientEntity;
import ru.sber.atm.exception.ClientNotFoundException;
import ru.sber.atm.repository.ClientRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client<Account<Balance>>> getAllClients() {
        Iterable<ClientEntity> clientIterable = clientRepository.findAll();
        List<Client<Account<Balance>>> clients = new ArrayList<>();

        clientIterable.forEach(
                cl -> {
                    Set<AccountEntity> accountEntitySet = cl.getAccounts();
                    List<Account<Balance>> accountSet = new ArrayList<>();

                    Set<CardEntity> cardEntitySet;

                    for (AccountEntity accountEntity : accountEntitySet) {
                        cardEntitySet = accountEntity.getCards();
                        List<Card> cardsSet = new ArrayList<>();
                        for (CardEntity cardEntity : cardEntitySet) {
                            cardsSet.add(new Card(cardEntity.getId(), cardEntity.getPinCode(), cardEntity.getCardNum(), cardEntity.getDateEnd(), cardEntity.getCvcCvv2Code()));
                        }
                        accountSet.add(new Account<>(accountEntity.getId(), accountEntity.getAccountNum(), new BalanceWithoutOverdraft(new BigDecimal(accountEntity.getBalance()), accountEntity.getIsoCode()), cardsSet));
                    }

                    clients.add(new Client<>(cl.getId(), cl.getFirstName(), cl.getLastName(), cl.getAge(), accountSet));
                }
        );
        return clients;
    }
}
