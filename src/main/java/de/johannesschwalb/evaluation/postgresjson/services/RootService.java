package de.johannesschwalb.evaluation.postgresjson.services;

import de.johannesschwalb.evaluation.postgresjson.entities.JsonRoot;
import de.johannesschwalb.evaluation.postgresjson.entities.Root;
import de.johannesschwalb.evaluation.postgresjson.repositories.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Service
public class RootService {

    @Autowired
    private RootRepository repository;

    public void save(final Root root) {
        repository.save(root);
    }

    public Root find(final long id) {
        return repository.findOne(id);
    }

    public void delete(final long id) {
        repository.delete(id);
    }

}
