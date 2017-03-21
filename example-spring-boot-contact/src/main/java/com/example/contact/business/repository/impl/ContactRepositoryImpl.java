package com.example.contact.business.repository.impl;

import com.example.contact.business.entity.Contact;
import com.example.contact.business.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Richard on 2017/3/21.
 */
@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private static final String QUERY_ALL_SQL = "select id, first_name, last_name, phone_number, email_address " +
            "from contacts order by last_name";

    private static final String INSERT_SQL = "insert into contacts (first_name, last_name, phone_number, email_address)" +
            "values (?, ?, ?, ?)";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Contact> finalAll() {
        return jdbcOperations.query(QUERY_ALL_SQL, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact contact = new Contact();
                contact.setId(rs.getLong("id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setEmailAddress(rs.getString("email_address"));
                return contact;
            }
        });
    }

    @Override
    public void save(Contact contact) {
        jdbcOperations.update(INSERT_SQL,
                contact.getFirstName(),contact.getLastName(),
                contact.getPhoneNumber(),contact.getEmailAddress());
    }

}
