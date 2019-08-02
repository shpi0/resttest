package ru.shpi0.resttest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shpi0.resttest.model.Application;
import ru.shpi0.resttest.repository.ApplicationRepository;

import java.util.Optional;

@Service
public class ApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Optional<Application> getLastApplicationByContactId(Long contactId) {
        logger.info("getLastApplicationByContactId {}", contactId);
        return applicationRepository.findFirstByContactId(contactId);
    }

}
