package ru.shpi0.resttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shpi0.resttest.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
