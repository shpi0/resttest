package ru.shpi0.resttest.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name="contacts_applications",
            joinColumns = @JoinColumn( name="application_id"),
            inverseJoinColumns = @JoinColumn( name="contact_id")
    )
    private List<Application> applications;

    public Contact() {
    }

    public Contact(List<Application> applications) {
        this.applications = applications;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId) &&
                Objects.equals(applications, contact.applications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, applications);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", applications=" + applications +
                '}';
    }
}
