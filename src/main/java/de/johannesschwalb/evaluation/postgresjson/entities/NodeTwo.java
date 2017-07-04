package de.johannesschwalb.evaluation.postgresjson.entities;

import javax.persistence.Entity;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Entity
public class NodeTwo extends AbstractEntityWithSubNodes<NodeThree> {

    public NodeTwo() {
        //Default
    }
}
