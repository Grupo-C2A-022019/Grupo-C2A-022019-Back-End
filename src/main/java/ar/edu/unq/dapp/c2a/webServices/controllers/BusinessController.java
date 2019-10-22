package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.services.business.BusinessDTO;
import ar.edu.unq.dapp.c2a.services.business.BusinessService;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import ar.edu.unq.dapp.c2a.services.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @RequestMapping(
            path = "/business",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    BusinessDTO createBusiness(@RequestBody BusinessDTO business) throws ValidationException {
        //TODO add validations

        business.setId(
                businessService.createMenu(
                        business.getName(),
                        business.getDescription(),
                        business.getImg(),
                        business.getUrlServ(),
                        business.getEmail(),
                        business.getHora_y_dia(),
                        business.getTel()
                )
        );

        return business;
    }
}
