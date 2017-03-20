package com.example.spitter.web.controller;

import com.example.spitter.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Richard on 2017/3/20.
 */
@Controller
public class SpittleController {

    private SpittleRepository spittleRepository;

    /**
     * 构造器注入
     * @param spittleRepository
     */
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittleList", method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittleAll());
        return "spittles";
    }

}
