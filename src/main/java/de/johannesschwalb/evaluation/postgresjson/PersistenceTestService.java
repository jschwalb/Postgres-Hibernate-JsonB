package de.johannesschwalb.evaluation.postgresjson;

import de.johannesschwalb.evaluation.postgresjson.entities.Root;
import de.johannesschwalb.evaluation.postgresjson.services.JsonRootService;
import de.johannesschwalb.evaluation.postgresjson.services.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Service
public class PersistenceTestService {

    @Autowired
    private JsonRootService jsonRootService;

    @Autowired
    private RootService rootService;

    @Autowired
    private EntityManager em;

    @PostConstruct
    public void init() throws IOException {
        Root warmUpRoot = TreeFactory.create(2);
        jsonRootService.save(warmUpRoot);
        rootService.save(warmUpRoot);
        jsonRootService.find(warmUpRoot.getId());
        rootService.find(warmUpRoot.getId());
        jsonRootService.delete(warmUpRoot.getId());
        rootService.delete(warmUpRoot.getId());

        em.clear();

        Root root = TreeFactory.create(3);
        long id = root.getId();

        Instant startJson = Instant.now();
        jsonRootService.save(root);
        Duration durationJson = Duration.between(startJson, Instant.now());
        System.out.println("JSONB saving took " +  durationJson.toMillis() + ".");

        Instant startRoot = Instant.now();
        rootService.save(root);
        Duration durationRoot = Duration.between(startRoot, Instant.now());
        System.out.println("Classical Hibernate saving took " + durationRoot.toMillis() + ".");

        em.clear();

        Instant startRootLoading = Instant.now();
        Root loadedRoot = rootService.find(id);
        Duration durationRootLoading = Duration.between(startRootLoading, Instant.now());
        System.out.println("Classical Hibernate loading took " + durationRootLoading.toMillis() + ".");

        em.clear();

        Instant startJsonLoading = Instant.now();
        Root loadedJsonRoot = jsonRootService.find(id);
        Duration durationJsonLoad = Duration.between(startJsonLoading, Instant.now());
        System.out.println("JSONB loading took " +  durationJsonLoad.toMillis() + ".");


    }

}
