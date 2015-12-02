package com.intetm.web.login;

import com.intetm.db.entity.User;
import com.intetm.service.login.LoginService;
import com.intetm.service.login.UserExistsException;
import com.intetm.web.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.intetm.db.entity.Authority.ROLE_USER;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private static final String HELLO_VIEW = "hello";

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        logger.debug("hello page");
        model.addAttribute("subject", "world");
        return HELLO_VIEW;
    }

    @RequestMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public UserDetails createUser(@RequestParam String username, @RequestParam String password) throws ServiceException {
        try {
            User user = loginService.createUser(username, password, ROLE_USER);
            return new UserDetails(user);
        } catch (UserExistsException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }
}
