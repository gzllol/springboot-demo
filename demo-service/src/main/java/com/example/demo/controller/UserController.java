package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/29
 * Time: 下午3:14
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * add user
     * curl -X POST 127.0.0.1:8080/user -d 'name=tom&phone=654321'
     * @param name
     * @param phone
     * @return
     */
    @RequestMapping(path="/user", method = RequestMethod.POST)
    @ResponseBody
    public String addNewUser (@RequestParam String name, @RequestParam String phone) {
        User n = new User();
        n.setName(name);
        n.setPhone(phone);
        userRepository.save(n);
        return "Success";
    }

}
