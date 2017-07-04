package de.johannesschwalb.evaluation.postgresjson.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Entity
public class Root extends AbstractEntityWithSubNodes<NodeOne> {

    public Root() {
        //Default;
    }

}
