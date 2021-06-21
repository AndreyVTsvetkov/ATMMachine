package ru.sber.atm.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.atm.atm.processor.*;
import ru.sber.atm.service.ClientService;

@RestController
@AllArgsConstructor
@Log
public class AtmRestController {
    private ClientService clientService;

    @GetMapping("/card_no/{cardNo}/{PIN}")
    public Response getClientBalance(
            @PathVariable("cardNo") String cardNo,
            @PathVariable("PIN") int PIN)
    {
        Response response;
        AtmProcessor atmProcessor = new AtmProcessor(clientService.getAllClients());

        response = atmProcessor.getCardBalance(cardNo, PIN);
        log.info(response.toString());
        return response;
    }
}
