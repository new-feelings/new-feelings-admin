package org.feelings.auth.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author lyq on 2020-01-03 9:38 上午
 * @desc
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/currentUser")
    public Principal user(Principal principal){
        return principal;
    }

}
