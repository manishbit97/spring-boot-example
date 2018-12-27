package com.example.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.User;
import com.example.demo.UserRepository;

@Controller
public class MainController {



    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/signup")
    public @ResponseBody String adduser(@RequestParam String name, @RequestParam String email)
    {

        User u  = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);
        return "saved succesfully";

    }


    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<User> findall()
    {
        return userRepository.findAll();

    }
}
