package com.example.contact.business.repository;

import com.example.contact.business.entity.Contact;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * Created by Richard on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testFinalAll(){
        List<Contact> contants = contactRepository.finalAll();
        Assert.assertEquals(2, contants.size());
    }

    @Test
    public void testSave() {

    }

}
