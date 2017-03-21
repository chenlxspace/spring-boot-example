package com.example.contact.web.controller;

import com.example.contact.business.entity.Contact;
import com.example.contact.business.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Richard on 2017/3/21.
 */
@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        List<Contact> contacts = contactRepository.finalAll();
        model.addAttribute("contacts", contacts);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }
}
