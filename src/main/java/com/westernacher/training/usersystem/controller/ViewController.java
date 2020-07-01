<<<<<<< HEAD
package com.westernacher.training.usersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Kristiyan SLavov
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Kristiyan Slavov");

        return "index";
    }
}
=======
package com.westernacher.training.usersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Kristiyan SLavov
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Kristiyan Slavov");

        return "index";
    }
}
>>>>>>> b74f18ba09c654dfca642dd884af12d791583ada
