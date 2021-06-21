package ru.sber.atm.atm.processor;

import lombok.RequiredArgsConstructor;
import ru.sber.atm.exception.AccountNotFoundException;
import ru.sber.atm.exception.CardNotFoundException;
import ru.sber.atm.exception.ClientNotFoundException;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class AtmProcessor {
    private final List<Client<Account<Balance>>> clients;

    public Response getCardBalance(String cardNo, int PIN) {
        Client<Account<Balance>> client;
        Account<Balance> account;
        Card findCard;

        if (clients.stream().noneMatch(cl -> cl.accountsStream().anyMatch(acc -> acc.cardsStream().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNo))))) {
            return new Response(ErrorsCode.CARD_NOT_FIND);
        }

        client = clients.stream().filter(cl -> cl.accountsStream().anyMatch(acc -> acc.cardsStream().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNo)))).findFirst().orElseThrow(ClientNotFoundException::new);
        account = client.accountsStream().filter(acc -> acc.cardsStream().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNo))).findFirst().orElseThrow(AccountNotFoundException::new);
        findCard = account.cardsStream().filter(card -> card.getCardNum().equalsIgnoreCase(cardNo)).findFirst().orElseThrow(CardNotFoundException::new);

        if (findCard.getPinCode() != PIN) {
            return new Response(ErrorsCode.PIN_NOT_CORRECT);
        }

        if (findCard.getDateEnd().before(new Date())) {
            return new Response(ErrorsCode.DATE_EXPIRED);
        }

        return new Response(account.getBalance().getSum(), account.getAccountNum(), account.getBalance().getIsoCode());
    }
}
