package com.xiao.democontactws.businesslayer.services;

import com.xiao.democontactws.datalayer.dao.ContactRepository;
import com.xiao.democontactws.datalayer.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository repo;

    public ContactServiceImpl(ContactRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<Contact> getAllContacts(Integer pageNum, Integer pageSize) {

        Pageable p = PageRequest.of(pageNum -1,pageSize);

        return repo.findAll(p);
    }

    @Override
    public Contact getContactById(Integer id) {

        Contact c = repo.findById(id).get();

        return null;
    }

    @Override
    public Contact addNewContact(Contact contact) {

        Contact c = repo.save(contact);
        return c;
    }

    @Override
    public Contact updateContact(Contact contact) {
        Contact c = repo.save(contact);
        return c;
    }

    @Override
    public void deleteContact(Contact contact) {
        repo.delete(contact);
    }
}
