package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.services.business.BusinessDTO;
import ar.edu.unq.dapp.c2a.services.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @RequestMapping(
            path = "/businesses/{id}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    BusinessDTO getMenuById(@PathVariable Long id) {
        return businessService.getBusiness(id);
    }

    @RequestMapping(
            path = "/businesses",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    BusinessDTO createBusiness(@RequestBody BusinessDTO business) {
        //TODO add validations
        // TODO: replace with  actual implementation
        // long ownerId = authService.getOwnerIdByToken(token);
        long ownerId = 1L;

        business.setId(
                businessService.createBusiness(
                        business.getName(),
                        business.getDescription(),
                        ownerId,
                        business.getImg(),
                        business.getUrlServ(),
                        business.getEmail(),
                        business.getSchedule(),
                        business.getTelephone()
                )
        );

        return business;
    }

    @RequestMapping(path = "/businesses/own", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Collection<BusinessDTO> getOwnBusinesses(
            @RequestHeader(name = "autorization", required = false) String token
    ) {
        // TODO: replace with  actual implementation
        // long ownerId = authService.getOwnerIdByToken(token);
        long ownerId = 1L;

        return businessService.getOwnerBusinesses(ownerId);
    }
}
