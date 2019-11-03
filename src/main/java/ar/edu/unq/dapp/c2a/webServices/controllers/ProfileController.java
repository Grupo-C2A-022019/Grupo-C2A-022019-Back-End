package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.services.profile.UserProfileDTO;
import ar.edu.unq.dapp.c2a.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(
            path = "/profile",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json"
    )

    public @ResponseBody
    UserProfileDTO getProfile(@RequestHeader("autorization") String token) {

        //ToDO: AuthService.getClientIdByToken(token)

        Long clientId = 31L;

        return profileService.getClientProfile(clientId);

    }
}
