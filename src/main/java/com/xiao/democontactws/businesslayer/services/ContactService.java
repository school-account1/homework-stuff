package com.xiao.democontactws.businesslayer.services;

import com.xiao.democontactws.datalayer.entities.Contact;
import org.springframework.data.domain.Page;

public interface ContactService {

    public Page<Contact> getAllContacts(Integer pageNum, Integer pageSize);

    public Contact getContactById(Integer id);

    public Contact addNewContact(Contact contact);

    public Contact updateContact(Contact contact);

    public void deleteContact(Contact contact);
}
