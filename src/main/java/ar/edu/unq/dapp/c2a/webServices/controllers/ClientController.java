package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.services.profile.ClientDTO;
import ar.edu.unq.dapp.c2a.services.profile.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    ClientDTO getProfile(@RequestHeader(value = "autorization",required =false) String token) {

        //ToDO: AuthService.getClientIdByToken(token)

        Long clientId = 2L;

        return clientService.getClientProfile(clientId);

    }
}
