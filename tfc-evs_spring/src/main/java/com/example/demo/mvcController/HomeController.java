package com.example.demo.mvcController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PasswordEncoder passEncoder;


    @GetMapping("/")
    public String mostrarHome() {
        return "redirect:/productos/";
    }

    @GetMapping("encodepass/{pass}")
    @ResponseBody
    public String encriptarPass(@PathVariable("pass") String pass) {
        return passEncoder.encode(pass);
    }

}
