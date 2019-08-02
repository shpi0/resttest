package ru.shpi0.resttest.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.shpi0.resttest.model.Application;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class ApplicationRepository {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Application> findFirstByContactId(Long contactId) {
        logger.info("findFirstByContactId {}", contactId);
        try {
            Application application = entityManager.createQuery("SELECT app FROM Contact AS c LEFT JOIN c.applications AS app WHERE c.id = :id ORDER BY app.dtCreated DESC", Application.class)
                    .setParameter("id", contactId)
                    .setMaxResults(1)
                    .getSingleResult();
            logger.info("Query returned {}", application);
            return Optional.ofNullable(application);
        } catch (Exception e) {
            logger.error("Exception during method findFirstByContactId() with contactId={}", contactId, e);
        }
        return Optional.empty();
    }

}
