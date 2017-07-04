package de.johannesschwalb.evaluation.postgresjson.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * Created by LG P310 on 04.07.2017.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
