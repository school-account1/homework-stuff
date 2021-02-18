package com.xiao.democontactws.presentationlayer.controllers;

import com.xiao.democontactws.businesslayer.services.ContactService;
import com.xiao.democontactws.datalayer.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/contacts")
public class ContactRestController {

    private ContactService contactService;

    public ContactRestController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllContacts(@RequestParam(name="_page", defaultValue = "1") Integer pageNum, @RequestParam(name="_limit", defaultValue = "10") Integer pageSize){
        try{
            Page<Contact> page = contactService.getAllContacts(pageNum, pageSize);

            List<Contact> contactList = page.getContent();

            Map<String,Object> response = new HashMap<>();
            response.put("contacts",contactList);
            response.put("currentPage", page.getNumber()+1);
            response.put("totalItems",page.getTotalElements());
            response.put("totalPages",page.getTotalPages());

            return ResponseEntity.ok(response);
        }
        catch(Exception e) {
            return ResponseEntity.status(404).body(null);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Integer id){
        try{
            Contact c = contactService.getContactById(id);

            return ResponseEntity.ok(c);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }

    }
    @PostMapping
    public ResponseEntity<?> addNewContact(@RequestBody Contact contact){
        try{
            Contact c = contactService.addNewContact(contact);
            return ResponseEntity.ok(c);
        }catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Integer id, @RequestBody Contact contact){
        try{
            contact.setId(id);
            Contact c = contactService.updateContact(contact);

            return ResponseEntity.ok(c);
        }catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Integer id){
        try{
            Contact c = contactService.getContactById(id);
            contactService.deleteContact(c);
            return ResponseEntity.ok(c);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
}
