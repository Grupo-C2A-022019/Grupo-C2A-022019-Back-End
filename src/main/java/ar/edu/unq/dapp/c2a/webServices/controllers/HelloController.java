package ar.edu.unq.dapp.c2a.webServices.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    public String index() {
        return new Gson().toJson("Greetings from Spring Boot!");
    }
}
