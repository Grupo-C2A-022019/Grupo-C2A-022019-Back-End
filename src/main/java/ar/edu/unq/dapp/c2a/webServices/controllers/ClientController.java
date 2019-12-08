package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.services.profile.ClientDTO;
import ar.edu.unq.dapp.c2a.services.profile.ClientService;
import ar.edu.unq.dapp.c2a.services.profile.StatementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.money.MonetaryAmount;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            path = "/profile",
            method = RequestMethod.GET,

            produces = "application/json"
    )

    public @ResponseBody
    ClientDTO getProfile(@RequestHeader(value = "autorization", required = false) String token) {

        //ToDO: AuthService.getClientIdByToken(token)

        Long clientId = 1L;

        return clientService.getClientProfile(clientId);

    }

    @RequestMapping(
            path = "/statements",
            method = RequestMethod.GET,

            produces = "application/json"
    )

    public @ResponseBody
    List<StatementDTO> getStatements(@RequestHeader(value = "autorization", required = false) String token) {
        //ToDO: AuthService.getClientIdByToken(token)

        Long clientId = 1L;

        return clientService.getAccountStatements(clientId);
    }



    @RequestMapping(
            path = "/insertCredit",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )

    public @ResponseBody
    void addCredit(@RequestHeader(value = "autorization", required = false) @RequestBody MonetaryAmount saldo) {

        //ToDO: AuthService.getClientIdByToken(token)

        Long clientId = 1L;

        clientService.addClientCredit(clientId,saldo);

    }

}
