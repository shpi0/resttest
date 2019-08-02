package ru.shpi0.resttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shpi0.resttest.model.Contact;
import ru.shpi0.resttest.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact add(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    public Contact update(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    public Optional<Contact> getById(Long id) {
        return contactRepository.findById(id);
    }

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

}
