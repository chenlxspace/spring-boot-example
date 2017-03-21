package com.example.contact.business.repository;

import com.example.contact.business.entity.Contact;

import java.util.List;

/**
 * Created by Richard on 2017/3/21.
 */
public interface ContactRepository {
    List<Contact> finalAll();
    void save(Contact contact);
}
