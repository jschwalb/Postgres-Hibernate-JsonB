package de.johannesschwalb.evaluation.postgresjson.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.johannesschwalb.evaluation.postgresjson.entities.JsonRoot;
import de.johannesschwalb.evaluation.postgresjson.entities.Root;
import de.johannesschwalb.evaluation.postgresjson.repositories.JsonRootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Service
public class JsonRootService {

    @Autowired
    private JsonRootRepository repository;

    private final ObjectMapper mapper;

    public JsonRootService() {
        mapper = new ObjectMapper();
    }

    public void save(final Root root) throws JsonProcessingException {
        JsonRoot jsonRoot = new JsonRoot();
        jsonRoot.setId(root.getId());
        jsonRoot.setJson(root);

        repository.save(jsonRoot);
    }

    public Root find(final long id) throws IOException {
        JsonRoot jsonRoot = repository.findOne(id);
        return jsonRoot.getJson();
    }

    public void delete(final long id) {
        repository.delete(id);
    }

}
