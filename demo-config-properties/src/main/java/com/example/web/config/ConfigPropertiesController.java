package com.example.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Richard on 2017/3/19.
 */
@RestController
public class ConfigPropertiesController {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "Book Name: " + bookName + " And Book Author: " + bookAuthor + " AuthorSettings: " + authorSettings;
    }

}
