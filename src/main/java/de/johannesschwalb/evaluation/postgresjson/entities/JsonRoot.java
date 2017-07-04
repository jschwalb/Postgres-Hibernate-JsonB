package de.johannesschwalb.evaluation.postgresjson.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;

/**
 * Created by LG P310 on 04.07.2017.
 */
@Entity
public class JsonRoot extends AbstractEntity {

    @Type(type = "de.johannesschwalb.evaluation.postgresjson.hibernate.JsonB")
    private Root json;

    public Root getJson() {
        return json;
    }

    public void setJson(Root json) {
        this.json = json;
    }
}
