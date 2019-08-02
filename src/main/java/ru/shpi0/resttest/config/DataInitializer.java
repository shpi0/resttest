package ru.shpi0.resttest.config;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shpi0.resttest.model.Application;
import ru.shpi0.resttest.model.Contact;
import ru.shpi0.resttest.service.ContactService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    @Autowired
    private ContactService contactService;

    public void init() {
        contactOne();
        contactTwo();
        contactThree();
        contactFour();
        contactFive();
    }

    private void contactOne() {
        List<Application> applications = new ArrayList<Application>() {
            {
                add(new Application(ZonedDateTime.of(2019,  4,  7, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_14"));
                add(new Application(ZonedDateTime.of(2019,  2,  2, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_13"));
                add(new Application(ZonedDateTime.of(2019,  1,  2, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_12"));
                add(new Application(ZonedDateTime.of(2018, 11, 15, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_11"));
                add(new Application(ZonedDateTime.of(2018, 10, 11, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_10"));
            }
        };
        contactService.add(new Contact(applications));
    }

    private void contactTwo() {
        contactService.add(new Contact());
    }

    private void contactThree() {
        List<Application> applications = new ArrayList<Application>() {
            {
                add(new Application(ZonedDateTime.of(2018, 10, 11, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_30"));
            }
        };
        contactService.add(new Contact(applications));
    }

    private void contactFour() {
        List<Application> applications = new ArrayList<Application>() {
            {
                add(new Application(ZonedDateTime.of(2018,  4, 11, 12,  0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_43"));
                add(new Application(ZonedDateTime.of(2018, 12, 11, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_42"));
                add(new Application(ZonedDateTime.of(2018, 11, 11, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_41"));
                add(new Application(ZonedDateTime.of(2018, 10, 11, 12, 0, 0, 0, ZoneId.systemDefault()).toLocalDateTime(), "APP_40"));
            }
        };
        contactService.add(new Contact(applications));
    }

    private void contactFive() {
        contactService.add(new Contact());
    }

}
