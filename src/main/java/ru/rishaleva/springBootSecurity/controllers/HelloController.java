package ru.rishaleva.springBootSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/")
    public String sayHello(ModelMap modelMap) {
        List<String> messages = new ArrayList<>();
        messages.add("Добро пожаловать");
        messages.add("Для аутентификации нажмите кнопну");
        modelMap.addAttribute("messages",messages);
        return "hello";
    }
}
