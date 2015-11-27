package com.intetm.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String HELLO_VIEW = "hello";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        logger.debug("hello page");
        model.addAttribute("subject", "world");
        return HELLO_VIEW;
    }
}
