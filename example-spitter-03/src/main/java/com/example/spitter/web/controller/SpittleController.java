package com.example.spitter.web.controller;

import com.example.spitter.entity.Spittle;
import com.example.spitter.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = "50") long max,
                                  @RequestParam(value = "count", defaultValue = "30") int count,
                                  Model model) {
        System.out.println("max:" + max);
        System.out.println("count:" + count);
        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList", spittles);
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
